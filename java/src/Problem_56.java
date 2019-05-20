import java.util.ArrayList;
import java.util.List;

/**
 * @author wwwanjian
 * @className Problem_56
 * @description TODO
 * @create 2019/5/15 17:38
 * @vsersion 1.0
 **/
//找到数组中只出现一次的两个数字，要求时间O(n)，空间O(1)
public class Problem_56 {
    public static void main(String args[]) {
        //获取数组
        int[] arr = {3, 3, 3, 2, 5, 5, 5, 7, 7, 7};
        //找到两个数字
//        findTwoOneNum(arr);
        findOneNum(arr);
        //打印结果
    }

    //题目一：找到数组中两个出现一次的数
    //找到两个出现一次的数字
    //思路：异或可以互相抵消，然后剩下的两个数字异或即可分开两个数字
    public static void findTwoOneNum(int[] arr) {
        //输入检查
        if (arr == null || arr.length < 1) {
            return;
        }
        //异或找到最后的数
        int temp = 0;
        for (int i = 0; i < arr.length; ++i) {
            temp = temp ^ arr[i];
        }
        //找到第一个1的索引位置
        String temp_str = Integer.toBinaryString(temp);
        int index = 0;
        for (int i = temp_str.length() - 1; i >= 0; --i) {
            if (temp_str.charAt(i) == '1') {
                index = i;
                break;
            }
        }
        index = temp_str.length() - 1 - index;
        //把两个数分开成两个子数组分别求一次的数
        int result_1 = 0;
        int result_2 = 0;
        for (int i = 0; i < arr.length; ++i) {
            if (((arr[i] >> index) & 1) == 1) {//分开两个数组进行异或
                result_1 = result_1 ^ arr[i];
            } else {
                result_2 = result_2 ^ arr[i];
            }
        }
        System.out.println(result_1);
        System.out.println(result_2);
    }

    //题目二：数组中找到出现一次的数字，其他出现三次
    //思路：出现三次的数字加起来每一位可以被3整除，不能整除的那一位就是出现一次的数字的那一位
    public static void findOneNum(int[] arr) {
        //输入检查
        if (arr == null || arr.length < 1) {
            return;
        }
        //把每个二进制位加起来
        int[] bitSum = new int[32];
        for (int i = 0; i < arr.length; ++i) {//遍历每个数
            int bitMast = 1;
            for (int j = 31; j >= 0; --j) {//遍历每个位
                if ((arr[i] & bitMast) != 0) {
                    bitSum[j] += 1;
                }
                bitMast = bitMast << 1;
            }
        }
        //整除3,多出来的就是那个数
        int result = 0;
        for (int j = 0; j < 32; ++j) {
            result = result << 1;
            result += bitSum[j] % 3;
        }
        System.out.println(result);
    }
}