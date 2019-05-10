/**
 * @author wwwanjian
 * @className Problem_46
 * @description TODO
 * @create 2019/5/9 22:05
 * @vsersion 1.0
 **/
//将数字翻译成字符串
public class Problem_46 {
    public static void main(String args[]) {
        //获取数字
        int n = 12258;
        //翻译字符串
        int result = transDigitsToChar(n);
        //打印字符串
        System.out.println(result);
    }

    //翻译字符串
    //思路1：转化为字符串，然后第一个字符可以是两个数字或者一个数字，则f(n)=f(n-1)+f(n-2)
    public static int transDigitsToChar(int n) {
        //输入检查
        if (n < 0) {
            return 0;
        }
        //递归多少种方法
        String str = String.valueOf(n);
        int result = trnsLoop(str, 0);
        return result;
    }

    //递归函数  递归方法存在冗余计算,可用循环来代替
    private static int transRecurly(String str, int index) {
        //终止条件
        if (index > str.length()) {
            return 0;
        }
        if (index == str.length() - 1||index == str.length()) {
            return 1;
        }
        //判断开始两个字符是不是在0-25范围
        int s;
        s = Integer.parseInt(String.valueOf(str.charAt(index)) + str.charAt(index + 1));
        if (s < 26) {//如果在0-25内则有两个翻译方法
            return transRecurly(str, index + 1) + transRecurly(str, index + 2);
        } else {//如果不在则只有一个翻译
            return transRecurly(str, index + 1);
        }
    }
    //循环代码 效率比递归要高
    private static int trnsLoop(String str, int index){
        int length = str.length();
        //一位数直接输出
        if (length<2){
            return 1;
        }
        //储存中间结果
        int[] count = new int[length+1];
        count[length] = 1;//最后两个可以成为一个字符
        int i;
        for (i=length-1;i>=0;--i){
            if (i==length-1){
                count[i] = 1;
            }
            else {
                int temp = Integer.parseInt(String.valueOf(str.charAt(i)) + str.charAt(i + 1));
                if (temp<26){
                    count[i] = count[i+1] + count[i+2];
                }
                else {
                    count[i] = count[i+1];
                }
            }
        }
        return count[0];
    }
}
