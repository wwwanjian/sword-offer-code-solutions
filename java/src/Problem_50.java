import java.util.HashMap;
import java.util.Map;

/**
 * @author wwwanjian
 * @className Problem_50
 * @description TODO
 * @create 2019/5/13 15:41
 * @vsersion 1.0
 **/
//第一个只出现一次的字符
public class Problem_50 {
    static boolean isError = false;

    public static void main(String args[]) {
        //获得字符串
        String str = "aaaa";
        //求第一个只出现一次的字符
        long start = System.nanoTime();
        char result = getFirstChar(str);
        long end = System.nanoTime();
        System.out.println("用时：" + (end - start));
        //输出结果
        System.out.println(result);
    }

    //入口函数
    public static char getFirstChar(String str) {
        if (str == null || str.length() < 1) {
            isError = true;
            return 0;
        }
        char ch = findFristUniCh_1(str);
        return ch;
    }

    //找到第一个不重复的字符  用时684700ns
    //思路1：hash表存储字符和次数，然后得到第一个字符，也可以只用一个数组来模拟hash表
    private static char findFristUniCh_1(String str) {
        Map<Character, Integer> hash = new HashMap<>();
        int length = str.length();
        for (int i = 0; i < length; ++i) {
            char ch = str.charAt(i);
            if (hash.containsKey(ch)) {
                hash.put(ch, hash.get(ch) + 1);
            } else {
                hash.put(ch, 1);
            }
        }
        for (Map.Entry<Character, Integer> vo : hash.entrySet()) {
            if (vo.getValue() == 1) {
                return vo.getKey();
            }
        }
        return 0;
    }
}