/**
 * @author wwwanjian
 * @className Problem_58
 * @description TODO
 * @create 2019/5/20 20:38
 * @vsersion 1.0
 **/
//翻转字符串
public class Problem_58 {
    public static void main(String args[]) {
        //获取字符串
        String str = "abcdefg";
        //翻转单词
//        String result = reserverWords(str);
        String result = leftRotateString(str, 2);
        //结果
        System.out.println(result);
    }

    //题目一：翻转单词顺序
    //思路：先翻转整个句子，再翻转每个单词
    public static String reserverWords(String str) {
        //输入检查
        if (str == null || str.length() < 1) {
            return "invalid input!";
        }
        StringBuilder stringBuilder = new StringBuilder(str);
        //翻转整个句子
        reserverString(stringBuilder, 0, str.length() - 1);
        //根据空格翻转单词
        int start = 0;
        int end = 0;
        for (int i = 0; i < stringBuilder.length(); ++i) {
            if (stringBuilder.charAt(i) == ' ') {
                reserverString(stringBuilder, start, end - 1);
                start = i + 1;
                end = i + 1;
            } else {
                ++end;
            }
        }
        return stringBuilder.toString();
    }

    //题目二：左旋字符串
    //思路1：借助辅助空间，把后面的复制到辅助空间，再接上要旋转的
    //思路2：和第一题思路一样先翻转整个字符串再把两部分当做单词反转回来
    public static String leftRotateString(String str, int n) {
        //输入检查
        if (str == null || str.length() < 1 || n < 0 || n > str.length()) {
            return "invalid input";
        }
        //确保下面反转两个不会越界
        if (n == 0 || n == str.length()) {
            return str;
        }
        //反转整个字符串
        StringBuilder stringBuilder = new StringBuilder(str);
        reserverString(stringBuilder, 0, stringBuilder.length() - 1);
        //反转两个单词
        reserverString(stringBuilder, 0, stringBuilder.length() - n - 1);
        reserverString(stringBuilder, stringBuilder.length() - n, stringBuilder.length() - 1);
        return stringBuilder.toString();
    }


    //翻转字符串,交换首尾
    public static void reserverString(StringBuilder str, int start, int end) {
        if (start < 0 || end < 0) {
            return;
        }
        while (start <= end) {
            char temp = str.charAt(start);
            str.setCharAt(start, str.charAt(end));
            str.setCharAt(end, temp);
            --end;
            ++start;
        }
    }
}
