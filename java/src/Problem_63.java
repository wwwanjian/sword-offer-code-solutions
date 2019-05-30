/**
 * @author wwwanjian
 * @className Problem_63
 * @description TODO
 * @create 2019/5/30 16:18
 * @vsersion 1.0
 **/
//股票的最大利润
public class Problem_63 {
    public static void main(String args[]) {
        //获取股票数组
        int[] arr = {9, 11, 8, 5, 7, 12, 16, 14};
        //获取最大利润
        int result = getMaxPro(arr);
        //打印结果
        System.out.println(result);
    }

    //获取最大利润
    public static int getMaxPro(int[] arr) {
        //输入检查
        if (arr == null || arr.length < 1) {
            return -1;
        }
        //最大利润
        int result = getMaxProCore(arr);
        return result;
    }

    //思路1：暴力遍历，时间O(n2)
    //思路2：两两相减然后找这个减数数组的最大连续子数组和，O(n)
    //思路3：遍历一次，把当前数值作为卖出价，记录此前的最小值，减去即为当前卖出价的最大利润，遍历到最后可找到最大利润
    private static int getMaxProCore(int[] arr) {
        //记录最小值和最大利润
        int min = arr[0];
        int max = arr[1] - min;
        for (int i = 2; i < arr.length; ++i) {
            if (arr[i - 1] < min) {
                min = arr[i - 1];
            }
            int diff = arr[i] - min;
            if (max < diff) {
                max = diff;
            }
        }
        return max;
    }
}