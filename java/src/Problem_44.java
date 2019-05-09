/**
 * @author wwwanjian
 * @className Problem_44
 * @description TODO
 * @create 2019/5/9 16:47
 * @vsersion 1.0
 **/
//从序列012345678910...找到指定位的值
public class Problem_44 {
    public static void main(String args[]) {
        //指定位
        int k = 2894;
        //找到指定位
        int result = getBitInSeq(k);
//        int result = getMaxBit(2);
        //打印结果
        System.out.println(result);
    }
    //找到指定位
    //思路：先找到所属几位数，然后找到所属数字，再找到所属位
    public static int getBitInSeq(int k){
        //输入检查
        if (k<0){
            return -1;
        }
        if (k<10){
            return k;
        }
        //找到所属区段
        int bits = String.valueOf(k).length();
        int maxbit = getMaxBit(bits);
        int minbit = getMaxBit(bits-1);
//        int n = bits;
        while (minbit>k){
            --bits;
            maxbit = getMaxBit(bits);
            minbit = getMaxBit(bits-1);
        }
        //找到属于哪个数字
        int numric = (k-minbit+bits-1)/bits+(int)Math.pow(10,bits-1) - 1;
        //找到属于哪个位
        int bit = (k-minbit+bits-1)%bits;
        int result = String.valueOf(numric).charAt(bit) - 48;
        return result;
    }
    //递归计算n位数在序列中的最大位
    private static int getMaxBit(int n){
        if (n==1){
            return 9;
        }
        if (n==0){
            return 0;
        }
        int maxBit;
        maxBit = (int)(Math.pow(10,n)-Math.pow(10,n-1))*n;
        maxBit += getMaxBit(n-1);
        return maxBit;
    }
}