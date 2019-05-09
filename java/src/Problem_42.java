/**
 * @author wwwanjian
 * @className Problem_42
 * @description TODO
 * @create 2019/5/9 14:36
 * @vsersion 1.0
 **/
//连续子数组的最大和
public class Problem_42 {
    public static void main(String args[]) {
        //获得数组
        int[] arr = {1,-2,3,10,-4,7,2,-5};
        //求最大连续和
        int result = getMaxSumFromArr(arr);
        //打印结果
        System.out.println(result);
    }
    //求最大连续和入口
    public static int getMaxSumFromArr(int[] arr){
        //输入检测
        if (arr==null||arr.length<1){
            return Integer.MIN_VALUE;
        }
        //求最大连续和
        int result = getMaxSumCore_2(arr);
        return result;
    }
    //最大连续和
    //TODO:思路：分治，求左边最大和右边最大和，以及跨两边最大和？
    private static int getMaxSumCore_1(int[] arr){
        return 0;
    }
    //记录最大值，如果该值大于下一个数加上去，如果小于就舍弃重新加,O(n)
    private static int getMaxSumCore_2(int[] arr){
        int sum =0;
        int max = sum;
        for (int i=0;i<arr.length;++i){
            if (sum+arr[i]>=arr[i]){
                sum+=arr[i];
            }
            else {
                sum = arr[i];
            }
            if (sum>max){
                max = sum;
            }
        }
        return max;
    }
}