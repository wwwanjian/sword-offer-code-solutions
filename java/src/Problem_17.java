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
        double base = -5.6;
        int ex = 9;
        //获取结果
        long start = System.nanoTime();

        long end = System.nanoTime();
        System.out.println("总共用时(ns):" + (end - start));
        //打印结果
//        System.out.println(result);
    }
    //通过字符串来记录大数 用时
    public static void print(int n){
        //输入检测
        if (n<1){
            return;
        }
        //循环打印
        String bigNum = "0";
        boolean addNewBit = false;
        while(bigNum.length()<=n){//循环终止条件
             //末尾+1
            for (int i=0;i<bigNum.length();++i){
                if (bigNum.charAt(i))
            }
            //判断进位

            //打印结果
        }
    }
}