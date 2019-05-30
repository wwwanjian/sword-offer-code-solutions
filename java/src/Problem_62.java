/**
 * @author wwwanjian
 * @className Problem_62
 * @description TODO
 * @create 2019/5/30 15:38
 * @vsersion 1.0
 **/
//圆圈中最后剩下的数字
public class Problem_62 {
    public static void main(String args[]) {
        //获取n，m
        int n = 10;
        int m = 2;
        //获取剩下的数字
        int result = getLastNum(n, m);
        //打印结果
        System.out.println(result);
    }

    //找到圆圈中剩下的数字
    public static int getLastNum(int n, int m) {
        if (n < 1 || m < 1) {
            return -1;
        }
        return getLastNumCore(n, m);
    }

    //思路1：把所有数字组成一个环形链表，每次走M步就删除该节点直到剩下一个节点，时间是O(mn)
    //思路2：删除一个数字后剩下的数组也是一连续的序列，然后映射到0-n-2，即变成一个递归问题。O(n)
    private static int getLastNumCore(int n, int m) {
        int last = 0;
        for (int i = 2; i < n; ++i) {
            last = (last + m) % i;
        }
        return last;
    }
}