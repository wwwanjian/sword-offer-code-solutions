/**
 * @author wwwanjian
 * @className Problem_51
 * @description TODO
 * @create 2019/5/13 16:53
 * @vsersion 1.0
 **/
//找到数组中逆序对的总数
public class Problem_51 {
    public static void main(String args[]) {
        //获得数组
        int[] arr = {7,6,5,4};
        //求逆序对总数
        long start = System.nanoTime();
        int sum = entrance(arr);
        long end = System.nanoTime();
        System.out.println("用时：" + (end - start));
        //输出结果
        System.out.println(sum);
    }

    //入口函数
    public static int entrance(int[] arr) {
        if (arr == null || arr.length < 1) {
            return -1;
        }
        int[] sup = new int[arr.length];
        for (int i = 0; i < arr.length; ++i) {
            sup[i] = arr[i];
        }
        int result = getSumOfCoples(arr, sup, 0, arr.length - 1);
        return result;
    }

    //求逆序对总数
    //思路1：从头到尾遍历每个数字和其后的每个数字比较，效率低下
    //思路2：递归分治，这里实现递归思路
    private static int getSumOfCoples(int[] arr, int[] sup, int start, int end) {
        //终止条件，子数组只有一个数
        if (start == end) {
            sup[start] = arr[start];
            return 0;
        }
        //递归左右两个子数组次数
        int mid = (end + start) / 2;
        int left = getSumOfCoples(arr, sup, start, mid);
        int right = getSumOfCoples(arr, sup, mid + 1, end);
        //计算合并两个数组的次数
        int i_left = mid;
        int i_right = end;
        int i_sup = end;
        int count = 0;
        while (i_left >= start && i_right > mid) {
            if (arr[i_left] > arr[i_right]) {
                sup[i_sup--] = arr[i_left--];
                count += i_right - mid;
            } else {
                sup[i_sup--] = arr[i_right--];
            }
        }
        if (i_left >= start) {
            sup[i_sup--] = arr[i_left];
        }
        if (i_right > mid) {
            sup[i_sup] = arr[i_right];
        }
        //复制原数组
        for (int i = 0; i < sup.length; ++i) {
            arr[i] = sup[i];
        }
        return count + left + right;
    }
}