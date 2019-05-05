/**
 * @author wwwanjian
 * @className Problem_17
 * @description 问题Problem_17
 * @create 2019/4/30 16:40
 * @vsersion 1.0
 **/
//从1打印到最大的n位数的十进制
public class Problem_17 {
    public static void main(String args[]) {
        //获取输入
        int n = 1;
        //获取结果
        long start = System.nanoTime();
        print_2(n);
        long end = System.nanoTime();
        System.out.println("总共用时(ns):" + (end - start));
        //打印结果
//        System.out.println(result);
    }

    //通过字符串来记录大数 用时1883800ns
    public static void print_1(int n) {
        //输入检测
        if (n < 1) {
            return;
        }
        //循环打印
        StringBuilder bigNum = new StringBuilder("0");
        boolean addNewBit = false;
        while (bigNum.length() <= n) {//循环终止条件
            //末尾+1
            for (int i = bigNum.length() - 1; i >= 0; --i) {
                if (bigNum.charAt(i) == '9') {//判断进位
                    bigNum.setCharAt(i, '0');
                    if (i == 0) {
                        addNewBit = true;
                    }
                } else {//不进位
                    bigNum.setCharAt(i, (char) (bigNum.charAt(i) + 1));
                    break;
                }
            }
            if (addNewBit) {
                bigNum.insert(0, "1");
                addNewBit = false;
            }
            if (bigNum.length() <= n) {
                System.out.println(bigNum.toString()); //打印结果
            }
        }
    }

    //问题转化为实际上是0-9的字符全排列问题,用递归实现全排列 用时2188200ns
    public static void print_2(int n) {
        //输入检测
        if (n < 1) {
            return;
        }
        //进行排列
        char[] str = new char[n];
        for (int i = 0; i < str.length; ++i) {
            str[i] = '0';
        }
        for (int i = 0; i < 10; ++i) {
            str[0] = (char) (i + '0');
            toMaxDigRecur(str,n,0);
        }

    }

    //排列递归函数
    public static void toMaxDigRecur(char[] str, int length, int index) {
        if (index==length-1){//判断是不是最后一位排列
            //打印字符串
            PrintStrFromNotZero(str);
            return;
        }
        //排列下一位
        for (int i=0;i<10;++i){
            str[index+1] = (char)('0'+i);
            toMaxDigRecur(str, length, index+1);
        }
    }
    //打印字符串，从第一个不是0的开始打印
    public static void PrintStrFromNotZero(char[] arr){
        boolean isBegining = false;
        for (int i=0;i<arr.length;++i){
            if (!isBegining&&arr[i]!='0'){
                isBegining = true;
            }
            if (isBegining){
                System.out.print(arr[i]);
            }
        }
        System.out.println();
    }
}