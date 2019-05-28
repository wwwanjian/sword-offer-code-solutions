/**
 * @author wwwanjian
 * @className Problem_60
 * @description TODO
 * @create 2019/5/28 22:11
 * @vsersion 1.0
 **/
//n个骰子的点数
public class Problem_60 {
    public static void main(String args[]) {
        //获取值
        int n = 3;
        //打印概率
        pringProbOfSum(n);
    }

    //打印所有和为s的出现的概率
    public static void pringProbOfSum(int n) {
        //输入检查
        if (n < 1) {
            return;
        }
        printProb_2(n);
    }

    //思路1：递归保存所有出现点数的次数
    private static void printProb_1(int n) {
        //保存次数
        int[] probablity = new int[6 * n - n + 1];
        //统计次数
        for (int i = 1; i <= 6; ++i) {
            printProb_recur(n, n, i, probablity);
        }
        //打印概率
        int total = (int) Math.pow(6, n);
        for (int i = n; i <= 6 * n; ++i) {
            double ratio = (double) probablity[i - n] / total;
            System.out.print("the probability of " + i + " is:");
            System.out.println(ratio);
        }
    }

    //递归函数统计次数
    private static void printProb_recur(int ori, int current, int sum, int[] prob) {
        if (current == 1) {
            prob[sum - ori]++;
        } else {
            for (int i = 1; i <= 6; ++i) {
                printProb_recur(ori, current - 1, i + sum, prob);
            }
        }
    }

    //用循环实现，两个数组交替保存次数
    private static void printProb_2(int n) {
        //二维数组交替保存
        int[][] probability = new int[2][6 * n + 1];
        int flag = 0;
        //初始化第一个骰子
        for (int i = 1; i <= 6; ++i) {
            probability[flag][i] = 1;
        }
        //每次加一个骰子的次数
        for (int k = 2; k <= n; ++k) {
            for (int i = 0; i < k; ++i) {
                probability[1 - flag][i] = 0;
            }
            for (int i = k; i <= 6 * k; ++i) {
                probability[1 - flag][i] = 0;
                for (int j = 1; j <= i && j <= 6; ++j) {
                    probability[1 - flag][i] += probability[flag][i - j];
                }
            }
            flag = 1 - flag;
        }
        //打印概率
        double total = Math.pow(6, n);
        for (int i = n; i <= 6 * n; ++i) {
            double ratio = (double) probability[flag][i] / total;
            System.out.print("the probability of " + i + " is:");
            System.out.println(ratio);
        }
    }
}
