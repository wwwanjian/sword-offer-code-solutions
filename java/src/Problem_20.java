import com.sun.org.apache.bcel.internal.generic.NEW;

import javax.annotation.processing.SupportedSourceVersion;

/**
 * @author wwwanjian
 * @className Problem_20
 * @description TODO
 * @create 2019/5/5 16:11
 * @vsersion 1.0
 **/
//判断字符串是否表示数值
public class Problem_20 {
    public static void main(String args[]) {
        //获取字符串
        String str = "";
        //判断是否表示数值
        long start = System.nanoTime();
        boolean result = isNumeric(str);
        long end = System.nanoTime();
        System.out.println("总共用时(ns):" + (end - start));
        //输出结果
        System.out.println(result);
    }

    //判断函数 匹配A[.[B]][e|EC]或者.B[e|EC],A为整数部分，B为小数部分，C是指数
    public static boolean isNumeric(String str) {
        //输入检测
        if (str.length() < 1) {
            return false;
        }
        //扫描整数A
        Result result = isPartA(str);
        Result resultOfA = result;
        Result resultOfB = new Result();
        //扫描小数B
        if (resultOfA.getIndex()<str.length()&&str.charAt(resultOfA.getIndex()) == '.') {
            resultOfA.setIndex(resultOfA.getIndex() + 1);
            resultOfB = isPartB(str, resultOfA.getIndex());
            result.setIndex(resultOfB.getIndex());
            result.setResult(resultOfA.getResult() || resultOfB.getResult());
        }
        else {
            resultOfB.setIndex(resultOfA.getIndex());
        }
        //扫描指数C
        if (resultOfB.getIndex()<str.length()&&(str.charAt(resultOfB.getIndex()) == 'e' || str.charAt(resultOfB.getIndex()) == 'E')) {
            resultOfB.setIndex(resultOfB.getIndex() + 1);
            Result resultOfC = isPartC(str, resultOfB.getIndex());
            result.setIndex(resultOfC.getIndex());
            result.setResult(resultOfC.getResult() || result.getResult());
        }
        return result.getResult() && result.getIndex() == str.length();
    }

    //扫描整数函数
    public static Result isPartA(String str) {
        Result result = new Result();
        if (str.charAt(result.getIndex()) == '+' || str.charAt(result.getIndex()) == '-') {
            result.setIndex(result.getIndex() + 1);
        }
        int preIndex = result.getIndex();
        while (result.getIndex() < str.length() && str.charAt(result.getIndex()) >= '0' && str.charAt(result.getIndex()) <= '9') {
            result.setIndex(result.getIndex() + 1);
        }
        if (preIndex < result.getIndex()) {
            result.setResult(true);
        }
        return result;
    }

    //扫描小数函数
    public static Result isPartB(String str, int index) {
        Result result = new Result();
        int preIndex = index;
        result.setIndex(index);
        while (result.getIndex() < str.length() && str.charAt(result.getIndex()) >= '0' && str.charAt(result.getIndex()) <= '9') {
            result.setIndex(result.getIndex() + 1);
        }
        if (preIndex < result.getIndex()) {
            result.setResult(true);
        }
        return result;
    }

    //扫描指数函数
    public static Result isPartC(String str, int index) {
        Result result = new Result();
        result.setIndex(index);
        if (str.charAt(result.getIndex()) == '+' || str.charAt(result.getIndex()) == '-') {
            result.setIndex(result.getIndex() + 1);
        }
        int preIndex = result.getIndex();
        while (result.getIndex() < str.length() && str.charAt(result.getIndex()) >= '0' && str.charAt(result.getIndex()) <= '9') {
            result.setIndex(result.getIndex() + 1);
        }
        if (preIndex < result.getIndex()) {
            result.setResult(true);
        }
        return result;
    }
}

//记录结果
class Result {
    private boolean result = false;
    private int index = 0;

    public Result() {
    }

    public int getIndex() {
        return index;
    }

    public boolean getResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
