/**
 * @author wwwanjian
 * @className Problem_65
 * @description TODO
 * @create 2019/5/30 16:54
 * @vsersion 1.0
 **/
//不用加减乘除做加法
public class Problem_65 {
    public static void main(String args[]) {
        //获取两个数
        int x = 10;
        int y = 10;
        //获取结果
        int result = twoSum(x, y);
        //打印结果
        System.out.println(result);
    }

    //求两数之和
    //思路：先异或后与再相加
    public static int twoSum(int x, int y) {
        int sum, carry;
        do {
            sum = x ^ y;
            carry = (x & y) << 1;
            x = sum;
            y = carry;
        } while (y != 0);
        return x;
    }
}