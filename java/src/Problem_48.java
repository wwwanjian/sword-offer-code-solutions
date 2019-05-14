import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

/**
 * @author wwwanjian
 * @className Problem_48
 * @description TODO
 * @create 2019/5/13 10:12
 * @vsersion 1.0
 **/
//找到最长不含重复字符的字符串的长度
public class Problem_48 {
    public static void main(String args[]) {
        //获得字符串
        String str = "";
        //找到这个字符串
        int max = findMaxLengthStr(str);
        //输出结果
        System.out.println(max);
    }

    //入口
    public static int findMaxLengthStr(String str) {
        //输入检查
        if (str == null || str.length() < 1) {
            return 0;
        }
        //得到结果
        int maxStr = findMaxStr_2(str);
        return maxStr;
    }

    //找到最长无重复字符串
    //思路：遍历从头到尾，每遍历一个字符，检查是否在已有字符中，无则加入，有则把该字符串加入list,最后list中最长的就是
    public static int findMaxStr_1(String str) {
        return 0;
    }

    //解法2
    //动态规划，若当前字符不重复f(n)=f(n-1)+1,若重复则再计算d,
    public static int findMaxStr_2(String str) {
        int length = str.length();
        int[] maxArray = new int[length];
        //循环计算下一个索引的最大长度
        for (int index = 0; index < length; ++index) {
            if (index == 0) {
                maxArray[index] = 1;
            } else {
                //判断前面有没有重复字符
                boolean isDuplicate = false;
                int i;
                for (i = index -1; i>=0; --i) {
                    if (str.charAt(i) == str.charAt(index)) {
                        isDuplicate = true;
                        break;
                    }
                }
                //判断距离
                if (isDuplicate) {
                    int d = index - i;
                    if (d>maxArray[index-1]){
                        maxArray[index] = maxArray[index-1]+1;
                    }
                    else {
                        maxArray[index] = d;
                    }
                } else {
                    maxArray[index] = maxArray[index - 1] + 1;
                }
            }
        }
        int max = -1;
        for (int j = 0; j < length; ++j) {
            if (maxArray[j] > max) {
                max = maxArray[j];
            }
        }
        return max;
    }
}