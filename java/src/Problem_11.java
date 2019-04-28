/**
 * @author wwwanjian
 * @className Problem_11
 * @description TODO
 * @create 2019/4/28 15:56
 * @vsersion 1.0
 **/
//排序数组旋转后的最小值
public class Problem_11 {
    public static void main(String args[]) {
        int[] arr = {0};
        long start = System.nanoTime();
        int min = getMin(arr);
        long end = System.nanoTime();
        System.out.println("总共用时(ns):" + (end - start));
        System.out.println(min);
    }

    //通过二分法查找
    public static int getMin(int[] arr) {
        //输入处理
        if (arr.length == 0) {
            return Integer.MIN_VALUE;
        } else if (arr.length == 1) {
            return arr[0];
        }
        //定义两个索引头和尾
        int head = 0;
        int back = arr.length - 1;
        int mid = head;
        //循环取中间数与第一个数比较，直到两个说明相邻
        while ((back - head) > 1) {
            //如果数组升序排列
            if (arr[back] > arr[head]) {
                back = head;
                break;
            }
            mid = (back + head) / 2;
            //如果头尾和中间都相等则只能顺序查找
            if (arr[head] == arr[back] && arr[head] == arr[mid]) {
                return getMinByOrder(arr);
            }
            //移动索引
            if (arr[mid] >= arr[head]) {
                head = mid;
            } else {
                back = mid;
            }
        }
        //第二个索引即是最小值
        return arr[back];
    }

    //顺序查找
    public static int getMinByOrder(int[] arr) {
        int temp = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < temp) {
                temp = arr[i];
            }
        }
        return temp;
    }
}
