import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.*;

/**
 * @author wwwanjian
 * @className Problem_59
 * @description TODO
 * @create 2019/5/20 22:14
 * @vsersion 1.0
 **/
//队列的最大值
public class Problem_59 {
    public static void main(String args[]) {
        //获取数组
        int[] arr = {2,3,4,2,6,2,5,1};
        int size = 3;
        //得到最大值数组
        List<Integer> result = getSumArr(arr, size);
        //打印结果
        System.out.println(result);
    }

    //题目一：滑动窗口的最大值
    //思路1：暴力遍历，O（nk）
    //思路2：用队列保存最大值信息，O(n)
    public static List<Integer> getSumArr(int[] arr, int size) {
        //输入判断
        if (arr == null || arr.length < 1 || size < 1 || arr.length < size) {
            return null;
        }
        //队列寻找最大值
        Deque<Integer> index = new ArrayDeque<>();
        Deque<Integer> maxInWindow = new ArrayDeque<>();
        //第一个窗口
        for (int i = 0; i < size; ++i) {
            while (!index.isEmpty() && arr[i] >= arr[index.getLast()]) {
                index.removeLast();
            }
            index.addLast(i);
        }
        //后面的滑动窗口
        for (int i = size; i < arr.length; ++i) {
            maxInWindow.addLast(arr[index.getFirst()]);
            while (!index.isEmpty() && arr[i] >= arr[index.getLast()]) {
                index.removeLast();
            }
            if (!index.isEmpty() && index.getFirst() <= (i - size)) {
                index.removeFirst();
            }
            index.addLast(i);
        }
        maxInWindow.addLast(arr[index.getFirst()]);
        return new ArrayList<>(maxInWindow);
    }
    //题目二：队列的最大值，定义一个队列并实现max,且O(1)
    //思路1：上面的滑动窗口可以实现这个功能，size=1即可

}

//带最大值的队列
class QueueWithMax{

}
