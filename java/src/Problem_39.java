/**
 * @author wwwanjian
 * @className Problem_39
 * @description TODO
 * @create 2019/5/8 22:06
 * @vsersion 1.0
 **/
//找到数组中出现次数超过一半的数字
public class Problem_39 {
    public static void main(String args[]) {
        //构建数组
        int[] arr = {2,2,2,1,3,4,2,2,5};
        //找到出现超过一半的数字
        int result = findTimesOverHalf(arr);
        //输出结果
        System.out.println(result);
    }
    //找到出现次数超过一半的数字
    //思路1：用一个hsah表存储数字和字数,但是hash长度如何确定？
    //思路2：用快速排序中的partition函数找到中间的那个数
    //思路3：超过半数则表示比其他所有数字次数和还要多
    public static int findTimesOverHalf(int[] arr){
        //输入检测
        if (arr==null||arr.length<1){
            return Integer.MIN_VALUE;
        }
        //统计次数 思路3 找到次数最多的那个
        int result = arr[0];
        int times = 1;
        for (int i=0;i<arr.length;++i){
            if (times==0){
                result = arr[i];
                times = 1;
            }
            else {
                if (result==arr[i]){
                    ++times;
                }
                else {
                    --times;
                }
            }
        }
        times = 0;
        //确认result是不是超过半数
        for (int i=0;i<arr.length;++i){
            if (arr[i]==result){
                ++times;
            }
        }
        if (times*2>=arr.length){
            return result;
        }
        return Integer.MIN_VALUE;
    }
}
