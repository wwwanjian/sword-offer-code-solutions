import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author wwwanjian
 * @className Problem_45
 * @description TODO
 * @create 2019/5/9 20:21
 * @vsersion 1.0
 **/
//把一个正整数数组所有数字拼接成一个最小的数
public class Problem_45 {
    public static void main(String args[]) {
        //获得数组
        int[] arr = {123};
        //拼接数组
        String result = contactMinNum(arr);
        //打印结果
        System.out.println(result);
    }

    //拼接数组
    //思路1：转化为字符串数组，然后以第一个字符排序拼接，如果第一个字符一样那么以第二个字符类推
    //思路2：全排列然后找到最小值，需要排列n!次，还要找到最小值
    //思路3：设计一个排序规则，然后让数组排序再拼接得到最小值，注意大数问题
    public static String contactMinNum(int[] arr) {
        //输入检测
        if (arr == null || arr.length < 1) {
            return "Error Input";
        }
        //全部转化为字符串
        int length = arr.length;
        String[] strs = new String[length];
        for (int i = 0; i < length; ++i) {
            strs[i] = String.valueOf(arr[i]);
        }
        //根据字符串排序,定义比较规则
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s1 = o1 + o2;
                String s2 = o2 + o1;
                return s1.compareTo(s2);
            }
        });
        //拼接字符串
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < strs.length; i++) {
            result.append(strs[i]);
        }
        return result.toString();
    }
}
