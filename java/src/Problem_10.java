/**
 * @author wwwanjian
 * @className Problem_10
 * @description TODO
 * @create 2019/4/28 10:42
 * @vsersion 1.0
 **/
//求斐波那契数列
public class Problem_10 {
    public static void main(String args[]) {
        long start = System.nanoTime();
        long result =  fibonacciByRecursive(50);
        long end = System.nanoTime();
        System.out.println("总共用时(ns):"+(end-start));
        System.out.println(result);
    }
    //递归解法 n=50 用时50375315000ns
    public static long fibonacciByRecursive(int n){
        //终止条件
        if(n==0){
            return 0;
        }
        else if(n==1){
            return 1;
        }
        //递归调用
        return fibonacciByRecursive(n-1)+fibonacciByRecursive(n-2);
    }
    //循环解法 n=50 用时4100ns  12586269025
    public static long fibonacciByLoop(int n){
        if(n==0){
            return 0;
        }
        else if(n==1){
            return 1;
        }
        long sum = 0;
        int i=2;
        long pre = 1;
        long prePre = 0;
        while (i<=n){
            sum = pre+prePre;
            prePre = pre;
            pre = sum;
            i++;
        }
        return sum;
    }
}
