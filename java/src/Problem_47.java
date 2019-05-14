/**
 * @author wwwanjian
 * @className Problem_47
 * @description TODO
 * @create 2019/5/10 13:02
 * @vsersion 1.0
 **/
//再给定棋盘和权重的情况左上角出发路径最大和为多少
public class Problem_47 {
    public static void main(String args[]) {
        //获得棋盘
        int[][] martix = {
                {1, 10, 3, 8},
                {12, 2, 9, 6},
                {5, 7, 4, 11},
                {3, 7, 16, 5}
        };
        //获得最多的和
        int result = getMaxPathEntrance(martix);
        //打印结果
        System.out.println(result);
    }

    //获得最多和入口
    public static int getMaxPathEntrance(int[][] martix) {
        //输入检查
        if (martix == null || martix.length < 1 || martix[0].length < 1) {
            return 0;
        }
        //获得最大和
        int result = getMaxPathSum_1(martix);
        return result;
    }

    //获得最大和 解法1
    //动态规划，递归分析，f(i,j)=max(f(i+1,j),f(i,j+1))+(i,j),用循环来做提高效率
    private static int getMaxPathSum_1(int[][] martix) {
        int rows = martix.length;
        int cols = martix[0].length;
        int[][] sumArray = new int[rows][cols];
        for (int row = 0; row < rows; ++row) {
            for (int col = 0; col < cols; ++col) {
                int left = 0;
                int up = 0;
                if (row > 0) {
                    up = sumArray[row - 1][col];
                }
                if (col > 0) {
                    left = sumArray[row][col - 1];
                }
                sumArray[row][col] = Math.max(up, left) + martix[row][col];
            }
        }
        int maxValue = sumArray[rows - 1][cols - 1];
        return maxValue;
    }

    //解法2
    //不必保存所有结果，实际上保存左边和上边的结果就可以了
    private static int getMaxPathSum_2(int[][] martix) {
        return 0;
    }
}
