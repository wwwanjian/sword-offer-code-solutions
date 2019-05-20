/**
 * @author wwwanjian
 * @className Problem_57
 * @description TODO
 * @create 2019/5/20 19:15
 * @vsersion 1.0
 **/
//和为s的数字
public class Problem_57 {
    public static void main(String args[]) {
        //获取数组
        int[] arr = {1, 2, 4, 7, 10, 15};
        int s = 9;
        //输出和为s的两个数
//        getSumOfTwo(arr, s);
        //输入和为s的序列
        printSumSeque(s);
    }

    //题目一：在递增数组中找到和s的两个数
    //思路1：暴力双层遍历，时间O(n2)
    //思路2：暴力单层遍历+二分查找，O(nlgn)
    //思路3：利用递增序列，定义两个头尾指针，加起来大于s则尾向前移动，小于s头指针向前移动 O（n）
    public static void getSumOfTwo(int[] arr, int s) {
        //输入检查
        if (arr == null || arr.length < 1) {
            return;
        }
        //定义头尾指针
        int head = 0;
        int fail = arr.length - 1;
        //移动头尾指针直到找到或者相遇
        while (head != fail) {
            if ((arr[head] + arr[fail]) > s) {
                --fail;
            } else if ((arr[head] + arr[fail]) < s) {
                ++head;
            } else {
                break;
            }
        }
        //判断有没有找到
        if (head != fail) {
            System.out.println(arr[head]);
            System.out.println(arr[fail]);
        } else {
            System.out.println("there are not two num sum is s!");
        }
    }

    //题目二：和为s的连续正数序列
    //思路：从1,2开始逐步增大，直到和为s
    public static void printSumSeque(int s) {
        //输入检查
        if (s < 3) {
            return;
        }
        //定义头尾
        int head = 1;
        int fail = 2;
        int middle = (s + 1) / 2;
        //逐步增大
        while (head < middle) {
            int sum = 0;
            for (int i = head; i <= fail; ++i) {
                sum += i;
            }
            if (sum < s) {
                ++fail;
            } else if (sum > s) {
                ++head;
            } else {
                for (int i = head; i <= fail; ++i) {
                    System.out.print(i + " ");
                }
                System.out.println();
                ++fail;
            }
        }
    }
}
