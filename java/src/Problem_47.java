/**
 * @author wwwanjian
 * @className Problem_47
 * @description TODO
 * @create 2019/5/10 13:02
 * @vsersion 1.0
 **/
//再给定棋盘和权重的情况左上角出发路径最大和为多少
public class Problem_47 {
    public static void main(String args[]) {
        //获得棋盘
        int[][] martix = {
                {1,2,3,4,5},
                {2,3,4,5,6},
        };
        //获得最多的和
        int result = getMaxPathEntrance(martix);
        //打印结果
        System.out.println(result);

    }
    //获得最多和入口
    public static int getMaxPathEntrance(int[][] martix){
        //输入检查
        if (martix==null||martix.length<1||martix[0].length<1){
            return 0;
        }
        //获得最大和
        int result = getMaxPathSum_1(martix);
        return result;
    }
    //获得最大和
    private static int getMaxPathSum_1(int[][] martix){

        return 0;
    }
}
