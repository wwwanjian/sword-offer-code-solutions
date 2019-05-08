/**
 * @author wwwanjian
 * @className Problem_29
 * @description TODO
 * @create 2019/5/7 23:26
 * @vsersion 1.0
 **/
//顺时针打印矩阵
public class Problem_29 {
    public static void main(String args[]) {
        //创建矩阵
        int[][] martix = {
                {1, 2, 3, 4, 5},
                {5, 6, 7, 8, 9},
                {9, 10, 11, 12, 13},
                {13, 14, 15, 16, 17},
                {18, 19, 20, 21, 22},
        };
        //打印矩阵
        long start = System.nanoTime();
        printMartixEntrance(martix);
        long end = System.nanoTime();
        System.out.println("总共用时(ns):" + (end - start));
    }

    //顺时针打印矩阵，一圈一圈递归打印
    public static void printMartixEntrance(int[][] martix) {
        //输入检测
        if (martix.length < 1) {
            return;
        }
        int rows = martix.length;
        int cols = martix[0].length;
        printMartixClockwiseRecur(martix, 1, rows, cols);
    }

    //递归打印 用时542600ns
    public static void printMartixClockwiseRecur(int[][] martix, int round, int rows, int cols) {
        //终止条件
        if (round > (rows + 1) / 2 || round > (cols + 1) / 2) {
            return;
        }
        //打印最上面一排
        int i;
        for (i = round - 1; i < cols - round + 1; ++i) {
            System.out.print(martix[round - 1][i]);
            System.out.print(',');
        }
        --i;
        //打印最右边
        if (round-1>=rows-round-1){
            return;
        }
        int j;
        for (j = round; j < rows - round + 1; ++j) {
            System.out.print(martix[j][i]);
            System.out.print(',');
        }
        --j;
        //打印最下边
        if (round-1>=cols-round-1){
            return;
        }
        int k;
        for (k = cols - round - 1; k >= round - 1; --k) {
            System.out.print(martix[j][k]);
            System.out.print(',');
        }
        ++k;
        //打印最左边
        if (round>=rows-round){
            return;
        }
        int m;
        for (m = rows - round - 1; m >= round; --m) {
            System.out.print(martix[m][k]);
            System.out.print(',');
        }
        //打印下一圈
        printMartixClockwiseRecur(martix, round + 1, rows, cols);
    }
}
