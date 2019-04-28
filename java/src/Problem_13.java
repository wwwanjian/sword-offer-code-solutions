/**
 * @author wwwanjian
 * @className Problem_13
 * @description TODO
 * @create 2019/4/28 21:17
 * @vsersion 1.0
 **/
//在m*n的方格上机器人从原点开始运动最多能够达到多少个格子，坐标数位之和不超过k
public class Problem_13 {
    public static void main(String args[]) {
        //矩阵行列数
        int threshold = 0;
        int rows = 1;
        int cols = 5;
        //获取格子
        long start = System.nanoTime();
        int moveCounts = getMovingCount(threshold, rows, cols);
        long end = System.nanoTime();
        System.out.println("总共用时(ns):" + (end - start));
        //输出结果
        System.out.println(moveCounts);
    }

    //获取格子数
    public static int getMovingCount(int threshold, int rows, int cols) {
        //判断输入合法
        if (threshold < 0 || rows <= 0 || cols <= 0) {
            return 0;
        }
        boolean[][] visited = new boolean[rows][cols];

        //通过递归函数得到格子数
        int moveCounts = movingCount(threshold, rows, cols, 0, 0, visited);
        //返回格子数
        return moveCounts;
    }

    //递归函数
    public static int movingCount(int threshold, int rows, int cols, int row, int col, boolean[][] visited) {
        //检查能否进入改点
        int countMove = 0;
        if (isAllowToEnter(threshold, rows, cols, row, col, visited)) {
            //统计下一个点
            visited[row][col] = true;
            countMove = 1 + movingCount(threshold, rows, cols, row - 1, col, visited)
                    + movingCount(threshold, rows, cols, row + 1, col, visited)
                    + movingCount(threshold, rows, cols, row, col - 1, visited)
                    + movingCount(threshold, rows, cols, row, col + 1, visited);
        }
        //返回总数
        return countMove;
    }

    //检查能够进入该点
    public static boolean isAllowToEnter(int threshold, int rows, int cols, int row, int col, boolean[][] visited) {
        if (row >= 0 && row < rows && col >= 0 && col < cols && !visited[row][col]
                && getSumOfDigit(row) + getSumOfDigit(col) <= threshold) {
            return true;
        }
        return false;
    }

    //得到数位和, int->String char->int
    public static int getSumOfDigit(int digit) {
        int sum = 0;
        String strOfDigit = String.valueOf(digit);
        for (int i = 0; i < strOfDigit.length(); ++i) {
            sum += strOfDigit.charAt(i) - 48;
        }
        return sum;
    }
}
