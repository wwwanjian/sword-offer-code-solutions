import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

/**
 * @author wwwanjian
 * @className Problem_12
 * @description TODO
 * @create 2019/4/28 18:03
 * @vsersion 1.0
 **/
//判断矩阵中是否存在某个路径
public class Problem_12 {
    public static void main(String args[]) {
        //获得矩阵
        char[][] arr = {
                {'a', 'b', 't', 'g'},
//                {'c', 'f', 'c', 's'},
//                {'j', 'd', 'e', 'h'},
        };
        String path = "abfb";
        //找到路径
        long start = System.nanoTime();
        boolean hasPath = hasPathFun(arr, path);
        long end = System.nanoTime();
        System.out.println("总共用时(ns):" + (end - start));
        //输出结果
        System.out.println(hasPath);
    }

    //找到存在路径 用时：13500ns
    public static boolean hasPathFun(char[][] arr, String path) {
        //输入检测
        int rows = arr.length;
        if (rows < 1 || path.length() < 1) {
            return false;
        }
        int cols = arr[0].length;
        //走过的路径记录，默认初始化为false
        boolean[][] visited = new boolean[rows][cols];
        int pathLength = 0;//记录到那个字符了
        for (int row = 0; row < rows; ++row) {
            for (int col = 0; col < cols; ++col) {
                if (hasPathCore(arr, row, col, path, pathLength, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    //递归查找下一个
    public static boolean hasPathCore(char[][] arr, int row, int col, String path, int pathLength, boolean[][] visited) {
        boolean hasPath = false;
        //路径全部找到
        if (pathLength >= path.length()) {
            return true;
        }
        int rows = arr.length;
        int cols = arr[0].length;
        //找到一个
        if (row >= 0 && row < rows && col >= 0 && col < cols && arr[row][col] == path.charAt(pathLength) && !visited[row][col]) {
            ++pathLength;
            visited[row][col] = true;
            //找下一个
            hasPath = hasPathCore(arr, row, col - 1, path, pathLength, visited)//
                    || hasPathCore(arr, row - 1, col, path, pathLength, visited)
                    || hasPathCore(arr, row, col + 1, path, pathLength, visited)
                    || hasPathCore(arr, row + 1, col, path, pathLength, visited);

            if (!hasPath) {
                --pathLength;
                visited[row][col] = false;
            }
        }
        return hasPath;
    }
}
