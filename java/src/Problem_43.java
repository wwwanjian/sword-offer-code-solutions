/**
 * @author wwwanjian
 * @className Problem_43
 * @description TODO
 * @create 2019/5/9 15:19
 * @vsersion 1.0
 **/
//1-n中1出现的次数
public class Problem_43 {
    public static void main(String args[]) {
        //获取n
        int n = 1;
        //求1出现的次数
        int result = timesOfOne(n);
        //打印结果
        System.out.println(result);
    }

    //求1出现的次数
    //思路1：每个数字转化为字符串再统计1，O(n2)
    //思路2：分成两段分治 O(logN)
    public static int timesOfOne(int n) {
        //输入检测
        if (n < 1) {
            return 0;
        }
        //转化为字符串进行
        String str = String.valueOf(n);
        //获取次数
        return calTimesOfOneRecur(str);
    }

    //递归统计  三部分：最高位为1的部分+剩下为1的部分+递归的部分
    private static int calTimesOfOneRecur(String str) {
        int frist = str.charAt(0) - 48;
        int fristBitTimes = 0;
        int length = str.length();
        if (length < 2) {
            if (frist < 1) {
                return 0;
            } else {
                return 1;
            }
        }
        //获取第一位
        String subString = str.substring(1);
        //统计最高位为1的次数
        if (frist == 1) {
            fristBitTimes = Integer.parseInt(subString) + 1;
        } else {
            fristBitTimes = (int) Math.pow(10, length - 1);
        }
        //统计剩下为1的次数
        int leftBitTimes = 0;
        leftBitTimes = (int) Math.pow(10, length - 2) * frist * (length - 1);
        //统计递归的次数
        int curBitTimes = calTimesOfOneRecur(subString);
        return fristBitTimes + leftBitTimes + curBitTimes;
    }
}