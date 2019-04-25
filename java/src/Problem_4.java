/**
 * @file null.java
 * @auther wwwanjian
 * @create 2019-04-25 16:15
 */
//二维顺序数组中是否存在某个数
public class Problem_4 {
    public static void main(String[] args) {
        //获取数组
        int[][] arr = {
                {1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 15}
        };
        int target = 3;
        //判断是否包含数
        boolean result = solution_2(arr, target);
        //输出结果
        System.out.println(result);
    }

    //判断是否包含某个数,先比较中间，后遍历，时间负责
    public static boolean solution_1(int[][] arr, int target) {
        //获取行列数
        int rows = arr.length;
        int cols = arr[0].length;
        boolean result = false;
        //先比较中间的数
        int temp = arr[(rows + 1) / 2][(cols + 1) / 2];
        //大于中间的数就比较右边和下边
        if (target > temp) {
            //比较右边
            for (int i = 0; i < rows; i++) {
                for (int j = (cols + 1) / 2; j < cols; j++) {
                    if (arr[i][j] == target) {
                        result = true;
                    }
                }
            }
            //比较下边
            for (int i = 0; i < cols; i++) {
                for (int j = (rows + 1) / 2; j < rows; j++) {
                    if (arr[j][i] == target) {
                        result = true;
                    }
                }
            }
        }
        //小于比较左边和上边
        else if (target < temp) {
            //比较左边
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < (cols + 1) / 2; j++) {
                    if (arr[i][j] == target) {
                        return true;
                    }
                }
            }
            //比较上边
            for (int i = 0; i < cols; i++) {
                for (int j = 0; j < (rows + 1) / 2; j++) {
                    if (arr[j][i] == target) {
                        return true;
                    }
                }
            }
        } else {
            result = true;
        }
        return result;
    }

    //每次剔除一行或者一列，提高效率
    public static boolean solution_2(int[][] arr, int target) {
        boolean result = false;
        //获取行列数
        int rows = arr.length;
        if(rows==0){
            return false;
        }
        int cols = arr[0].length;
        int temp_row = 0;
        int temp_col = cols - 1;
        //判断右上角的数和目标大小关系
        while (temp_row < rows && temp_col >= 0) {
            if (arr[temp_row][temp_col] > target) {
                temp_col--;//剔除一列
            } else if (arr[temp_row][temp_col] < target) {
                temp_row++;//剔除一行
            } else {
                result = true;
                break;
            }
        }
        //记录右上角行列号
        return result;
    }

}
