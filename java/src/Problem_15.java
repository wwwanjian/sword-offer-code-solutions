/**
 * @author wwwanjian
 * @className Problem_15
 * @description TODO
 * @create 2019/4/29 23:35
 * @vsersion 1.0
 **/
//输出整数的二进制中1的个数
public class Problem_15 {
    public static void main(String args[]) {
        //获取输入
        int n = 7;
        //获取结果
        long start = System.nanoTime();
        int timesOfOne = getTimesOfOne_4(n);
        long end = System.nanoTime();
        System.out.println("总共用时(ns):" + (end - start));
        //打印结果
        System.out.println(timesOfOne);
    }

    //获得二进制中1的个数 通过字符串转化得到, 用时20000ns
    public static int getTimesOfOne_1(int n) {
        //转化为二进制字符串
        String binStr = Integer.toBinaryString(n);
//        System.out.println(binStr);
        //计算1的个数
        int timesOfOne = 0;
        for (int i = 0; i < binStr.length(); ++i) {
            if (binStr.charAt(i) == '1') {
                ++timesOfOne;
            }
        }
        return timesOfOne;
    }

    //通过对整数移位判断最后一位直到所有为0但是对负数没办法 用时2000ns
    public static int getTimesOfOne_2(int n) {
        //判断正负
        if (n < 0) {
            return 0;
        }
        int timesOfOne = 0;
        //循环判断最后一位
        while (n != 0) {
            timesOfOne += n & 1;
            n = n >> 1;
        }
        return timesOfOne;
    }
    //通过对flag移位来判断每一位   用时2300ns
    public static int getTimesOfOne_3(int n){
        int timesOfOne = 0;
        int flag = 1;
        while (flag!=0){
            if ((n&flag)!=0){
                ++timesOfOne;
            }
            flag = flag << 1;
        }
        return timesOfOne;
    }
    //减1在与原数位与运算可以消除最后一个1，能够消除多少次就有多少个1 用时1700ns
    public static int getTimesOfOne_4(int n){
        int timesOfOne = 0;
        while (n!=0){
            n = n&(n-1);
            ++timesOfOne;
        }
        return timesOfOne;
    }
}
