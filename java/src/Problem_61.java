import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.Arrays;

/**
 * @author wwwanjian
 * @className Problem_61
 * @description TODO
 * @create 2019/5/30 15:21
 * @vsersion 1.0
 **/
//扑克牌中的顺子
public class Problem_61 {
    public static void main(String args[]) {
        //获取牌
        int[] arr = {0,1,3,4,5};
        //判断顺子
        boolean result = isContinuous(arr);
        //输出结果
        System.out.println(result);
    }

    //判断顺子
    public static boolean isContinuous(int[] arr) {
        //输入检查
        if (arr == null || arr.length < 1) {
            return false;
        }
        //排序
        Arrays.sort(arr);
        //统计0的个数
        int numOfZeros = 0;
        for (int i = 0; i < arr.length && arr[i] == 0; ++i) {
            ++numOfZeros;
        }
        //统计缺口或者对子
        int small = numOfZeros;//第一个不为0的下标
        int big = small + 1;//相邻的两个数
        int numOfGaps = 0;
        //一直遍历过去查找缺口或者对子
        while (big < arr.length) {
            //如果是对子不可能是顺子
            if (arr[small] == arr[big]) {
                return false;
            }
            //统计缺口
            numOfGaps += arr[big] - arr[small] - 1;
            small = big;
            big++;
        }
        //判断缺口数和0的数量
        return numOfGaps <= numOfZeros;
    }
}