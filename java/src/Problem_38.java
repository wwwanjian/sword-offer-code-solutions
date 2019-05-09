/**
 * @author wwwanjian
 * @className Problem_38
 * @description TODO
 * @create 2019/5/8 21:40
 * @vsersion 1.0
 **/
//打印字符串的所有排列组合
public class Problem_38 {
    public static void main(String args[]) {
        //获取字符串
        String str = "abcde";
        //打印所有排列组合
        printAllCombination(str);
    }

    //打印所有排列组合
    //str转化为数组，确定每个字符，然后递归确定每个字符
    public static void printAllCombination(String str) {
        //输入检查
        if (str == null || str.length() < 1) {
            return;
        }
        StringBuffer stringBuffer = new StringBuffer(str);
        combinationChar(stringBuffer, 0);
    }

    //递归组合函数
    public static void combinationChar(StringBuffer str, int begin) {
        if (begin >= str.length()) {//排列到最后一个
            System.out.println(str.toString());
        } else {//没到最后一个
            for (int i = begin; i < str.length(); ++i) {//往后遍历
                //交换确定的字母位置
                char temp = str.charAt(begin);
                str.setCharAt(begin, str.charAt(i));
                str.setCharAt(i, temp);
                //递归下一个位置
                combinationChar(str, begin + 1);
                //交换回来，相当于初始化下一次的位置
                temp = str.charAt(begin);
                str.setCharAt(begin, str.charAt(i));
                str.setCharAt(i, temp);
            }
        }
    }
}
