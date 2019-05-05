/**
 * @author wwwanjian
 * @className Problem_19
 * @description TODO
 * @create 2019/5/5 12:35
 * @vsersion 1.0
 **/
//正则表达式匹配
public class Problem_19 {
    public static void main(String args[]) {
        //获取输入
        String str = "abcd";
        String pattern = "ab*d";
        //获取结果
        long start = System.nanoTime();
        boolean result = regeMatch(str, pattern);
        long end = System.nanoTime();
        System.out.println("总共用时(ns):" + (end - start));
        //打印结果
        System.out.println(result);
    }

    //正则匹配实现 用时3400ns
    public static boolean regeMatch(String str, String pattern) {
        //检测输入
        if (str.length() < 1 && pattern.length() < 1) {
            return true;
        }
        else if (str.length()<1||pattern.length()<1){
            return false;
        }
        //递归匹配
        return matchCore(str, 0, pattern, 0);
    }

    //递归匹配函数
    public static boolean matchCore(String str, int strIndex, String pattern, int patIndex) {
        //递归终止条件
        if (strIndex>=str.length()&&patIndex>=pattern.length()){
            return true;
        }
        if (strIndex<str.length()&&patIndex>=pattern.length()){
            return false;
        }
        if (patIndex+1<pattern.length()&&pattern.charAt(patIndex+1)=='*'){
            if (pattern.charAt(patIndex)==str.charAt(strIndex)||(pattern.charAt(patIndex)=='.'&&strIndex<str.length())){
                return matchCore(str,strIndex+1,pattern,patIndex+2)
                        ||matchCore(str,strIndex+1,pattern,patIndex)
                        ||matchCore(str,strIndex,pattern,patIndex+2);
            }
            else {
                return matchCore(str,strIndex,pattern,patIndex+2);
            }
        }
        if (str.charAt(strIndex)==pattern.charAt(patIndex)||pattern.charAt(patIndex)=='.'){
            return matchCore(str,strIndex+1,pattern,patIndex+1);
        }
        return false;
    }
}
