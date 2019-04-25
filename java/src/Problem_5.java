import java.sql.SQLSyntaxErrorException;

/**
 * @file null.java
 * @auther wwwanjian
 * @create 2019-04-25 19:58
 */

//把字符串空格替换成%20
public class Problem_5 {
    public static void main(String[] args) {
        //获取字符串
        String str = "We  are Happy";
        //替换字符串
        long start = System.nanoTime();
        str = solution_2(str);
        long end = System.nanoTime();
        //输出字符串
        System.out.println(str);
        System.out.println("总共用时(ns)："+(end-start));
    }
    //按照空格切割然后用%20拼接起来
    private static String solution_1(String str){
        //切割字符串, 比较耗时.....T.T
        String[]  sourceStrs = str.split(" ");
        //空字符串
        if(sourceStrs.length==0){
            return str;
        }
        String result = sourceStrs[0];
        //拼接字符串
        for (int i=1;i<sourceStrs.length;i++) {
            //判断是不是空格
            if (sourceStrs[i].equals(" ")) {
                result = result + "%20";
            } else {
                result = result + "%20" + sourceStrs[i];
            }
        }
        return result;
    }
    //计算出空格个数得到字符串长度，复制字符串和替换
    private static String solution_2(String str){
        //获得字符数组
        char[] oriArr = str.toCharArray();
        int oriLength = oriArr.length;
        int spaceNums=0;
        //统计空格个数
        for (char c: oriArr
             ) {
            if(c==' '){
                spaceNums++;
            }
        }
        //得到新的字符数组长度
        int newArrLength = oriLength+spaceNums*2;
        char[] newArr=new char[newArrLength];
        //得到新的字符数组
        int front = oriLength-1;
        int back = newArrLength-1;
        while(front>=0){
            if(oriArr[front]!=' '){
                newArr[back--]=oriArr[front--];
            }
            else {
                front--;
                newArr[back--]='0';
                newArr[back--]='2';
                newArr[back--]='%';
            }
        }
        return new String(newArr);
    }
}
