/**
 * @author wwwanjian
 * @className Problem_14
 * @description TODO
 * @create 2019/4/28 22:19
 * @vsersion 1.0
 **/
//把长n的绳子剪m段，所有段的乘积最大的解法，输出最大乘积
public class Problem_14 {
    public static void main(String args[]) {
        //获取输入
        int n = 50;
        int m = 4;
        //获取结果
        long start = System.nanoTime();
        long maxMutil = getMaxMuti(n, m);
        long end = System.nanoTime();
        System.out.println("总共用时(ns):" + (end - start));
        //打印结果
        System.out.println(maxMutil);
    }

    //获取最大乘积
    public static long getMaxMuti(int length, int pices) {
        //输入判断
        if (length <= 1 || pices <= 1) {
            return 0;
        }
        long maxMuti = 0;
        //得到乘积
        maxMuti = getMaxMuti_Solution_1(length, pices);
        return maxMuti;
    }

    //动态规划解法，从上往下分解问题，从下往上求解 n=50时 17600ns
    public static long getMaxMuti_Solution_1(int length, int pices) {
        //输入判断
        if (length < 2) {
            return 0;
        } else if (length == 2) {
            return 1;
        } else if (length == 3) {
            return 2;
        }
        //分解问题，把最大乘积保存在矩阵中然后取出来即可，避免重复计算
        long[] maxMartin = new long[length + 1];
        maxMartin[0] = 0;
        maxMartin[1] = 1;
        maxMartin[2] = 2;
        maxMartin[3] = 3;
        for (int i = 4; i <= length; ++i) {
            long max = 0;
            for (int j = 1; j <= i / 2; ++j) {
                long temp = maxMartin[j] * maxMartin[i - j];
                if (max < temp) {
                    max = temp;
                }
            }
            maxMartin[i] = max;
        }
        return maxMartin[length];
    }

    //贪婪解法 n=50:23000ns TODO 原理不是很清楚
    public static long getMaxMuti_Solution_2(int length, int pices) {
        //输入判断
        if (length < 2) {
            return 0;
        } else if (length == 2) {
            return 1;
        } else if (length == 3) {
            return 2;
        }
        //尽量分成3的几段
        long result = 1;
        int last = 1;
        int numOf3 = length / 3;
        if (length % 3 == 1) {
            --numOf3;
            last = 4;
        } else if (length % 3 == 2) {
            last = 2;
        }
        result = (int)Math.pow(3, numOf3)*last;
        return result;
    }
}
