/**
 * @author wwwanjian
 * @className Problem_16
 * @description 问题Problem_16
 * @create 2019/4/30 11:06
 * @vsersion 1.0
 **/
//实现pow(double base, int ex)函数，不能使用库函数，不考虑大数
public class Problem_16 {
    public static void main(String args[]) {
        //获取输入
        double base = -5.6;
        int ex = 9;
        //获取结果
        long start = System.nanoTime();
        double result = pow_3(base, ex);
        long end = System.nanoTime();
        System.out.println("总共用时(ns):" + (end - start));
        //打印结果
        System.out.println(result);
    }

    //计算pow  循环乘积  base = 5.6, ex=9 用时:2200ns
    public static double pow_1(double base, int ex) {
        double result = 1;
        while (ex-- > 0) {//指数是0或者负数？
            result *= base;
        }
        return result;
    }

    //判断正负，循环乘积，效率低 用时:27900ns
    public static double pow_2(double base, int ex) {
        //输入检测
        if (equals(base, 0.0) && ex < 0) {
            return 0;
        }
        //去除符号
        int exWithNoSign = Math.abs(ex);
        double result = 1.0;
        for (int i = 0; i < exWithNoSign; ++i) {
            result *= base;
        }
        //加上符号
        if (ex < 0) {
            result = 1.0 / result;
        }
        return result;
    }

    //效率递归解法，把多次方拆开 用时2700ns
    public static double pow_3(double base, int ex) {
        //递归终止条件
        if (ex == 0) {
            return 1;
        } else if (ex == 1) {
            return base;
        }
        //递归调用
        double result = pow_3(base, ex >> 1) * pow_3(base, ex >> 1);
        if ((ex&1)==1){
            result*=base;
        }
        //返回
        return result;
    }

    //判断两个double是否相等
    public static boolean equals(double a, double b) {
        return Math.abs(a - b) < 0.00001;
    }

}