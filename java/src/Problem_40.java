/**
 * @author wwwanjian
 * @className Problem_40
 * @description TODO
 * @create 2019/5/9 9:49
 * @vsersion 1.0
 **/
//找到最小的k个数
public class Problem_40 {
    public static void main(String args[]) {
        //获得数组
        int[] arr = {4, 5, 1, 2, 3,  6};
        int k = 1;
        //找到最小的k个数
        int[] result = findMinKNum(arr, k);
        //打印数组
        System.out.println(result);
    }

    //找到最小的k个数
    //思路1：排序
    //思路2：快排的partition函数，排到第k个数字就行 这里用这个方式
    //思路3：创建一个k的数组，每次替换最大值，可用大顶堆或者红黑树实现
    public static int[] findMinKNum(int[] arr, int k) {
        //输入检查
        if (arr == null || arr.length < 1 || k < 1 || k > arr.length) {
            return null;
        }
        //使用快排调整
        int start = 0;
        int end = arr.length - 1;
        int index = partition(arr, start, end);
        //直到调整到第k个数
        while (index != k-1) {
            if (index > k-1) {
                end = index - 1;
            } else if (index < k-1) {
                start = index + 1;
            }
            index = partition(arr, start, end);
        }
        int[] output = new int[k];
        for (int i = 0; i < k; ++i) {
            output[i] = arr[i];
        }
        return output;
    }

    //快排的partition函数
    //定义两个头尾指针交换数据直到相遇
    //从头到尾遍历把小的放前面 这里实现这个方式
    public static int partition(int[] arr, int start, int end) {
        //检查
        if (start < 0 || start >= end || start > arr.length - 1 || end < 0 || end > arr.length - 1) {
            return -1;
        }
        //参考点
        int ref = arr[end];
        int small = start - 1;
        //调整位置
        for (int i = start; i < end; ++i) {
            if (arr[i] < ref) {
                ++small;
                if (small != i) {
                    int temp = arr[i];
                    arr[i] = arr[small];
                    arr[small] = temp;
                }
            }
        }
        ++small;
        int temp = arr[small];
        arr[small] = arr[end];
        arr[end] = temp;
        return small;
    }
}