import java.util.function.Predicate;

/**
 * @author wwwanjian
 * @className Problem_21
 * @description TODO
 * @create 2019/5/5 19:21
 * @vsersion 1.0
 **/
//给定一个数组，调整使得奇数在前偶数在后
public class Problem_21 {
    public static void main(String args[]) {
        //构建数组
        int[] arr = {1, 2, 3, 4, 5, 6};
        // 调整数组
        long start = System.nanoTime();
        adjustArr_2(arr, p -> (p & 1) == 1);
        long end = System.nanoTime();
        System.out.println("总共用时(ns):" + (end - start));
        //输出结果
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

    }

    //调整数组 维护两个指针，时间复杂度O(n)  用时2400ns
    public static void adjustArr_1(int[] arr) {
        //输入检测
        if (arr.length < 2) {
            return;
        }
        int frontIndex = 0;
        int backIndex = arr.length - 1;
        //循环移动指针直到两个指针相遇
        while (frontIndex < backIndex) {
            while (frontIndex < backIndex && (arr[frontIndex] & 0x01) == 1) {//使用右移1位代替除以2
                ++frontIndex;
            }
            while (frontIndex < backIndex && (arr[backIndex] & 0x01) == 0) {
                --backIndex;
            }
            if (frontIndex < backIndex) {
                int temp = arr[frontIndex];
                arr[frontIndex] = arr[backIndex];
                arr[backIndex] = temp;
            }
        }
    }

    //解耦解法，具有扩展性,把函数作为参数  但是效率很低 用时35987000ns
    public static void adjustArr_2(int[] arr, Predicate<Integer> p) {
        //输入检测
        if (arr.length < 2) {
            return;
        }
        int frontIndex = 0;
        int backIndex = arr.length - 1;
        //循环移动指针直到两个指针相遇
        while (frontIndex < backIndex) {
            while (frontIndex < backIndex && p.test(arr[frontIndex])) {//使用右移1位代替除以2
                ++frontIndex;
            }
            while (frontIndex < backIndex && !p.test(arr[backIndex])) {
                --backIndex;
            }
            if (frontIndex < backIndex) {
                int temp = arr[frontIndex];
                arr[frontIndex] = arr[backIndex];
                arr[backIndex] = temp;
            }
        }
    }
}
