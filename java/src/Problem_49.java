/**
 * @author wwwanjian
 * @className Problem_49
 * @description TODO
 * @create 2019/5/13 10:59
 * @vsersion 1.0
 **/
//求某个丑数
public class Problem_49 {
    public static void main(String args[]) {
        //获得索引
        int index = 1500;
        //求该索引丑数
        long start = System.nanoTime();
        int result = getUglyNumeric(index);
        long end = System.nanoTime();
        System.out.println("用时：" + (end - start));
        //输出结果
        System.out.println(result);
    }

    //求指定索引丑数
    public static int getUglyNumeric(int index) {
        //输入检查
        if (index < 1) {
            return 0;
        }
        //获取结果
        int result = getUglyNum_2(index);
        return result;
    }

    //获取指定丑数 i=1500 n=859963392  用时7276225100ns
    //思路：从2遍历，直到index，则arr[index]就是想要的数，效率很低,
    private static int getUglyNum_1(int index) {
        int arr_index = 1;
        if (index == 1) {
            return 1;
        }
        //遍历找到丑数加入数组直到数组满了
        for (int i = 2; ; ++i) {
            //判断丑数
            if (isUglyNum(i)) {
                arr_index++;
            }
            if (arr_index >= index) {
                return i;
            }
        }
    }

    //解法2：利用已有的丑数*2/3/5来得到新的丑数，避免了不是丑数的计算,用时200800ns
    private static int getUglyNum_2(int index) {
        if (index == 1) {
            return 1;
        }
        int[] uglyArr = new int[index];
        uglyArr[0] = 1;
        int T2 = 0;
        int T3 = 0;
        int T5 = 0;
        for (int i = 1; i < index; ++i) {
            int m = min(uglyArr[T2] * 2, uglyArr[T3] * 3, uglyArr[T5] * 5);
            uglyArr[i] = m;
            while (uglyArr[T2] * 2 <= uglyArr[i]) {
                ++T2;
            }
            while (uglyArr[T3] * 3 <= uglyArr[i]) {
                ++T3;
            }
            while (uglyArr[T5] * 5 <= uglyArr[i]) {
                ++T5;
            }
        }
        return uglyArr[index - 1];
    }

    //判断一个数是不是丑数
    private static boolean isUglyNum(int num) {
        while (num % 2 == 0) {
            num /= 2;
        }
        while (num % 3 == 0) {
            num /= 3;
        }
        while (num % 5 == 0) {
            num /= 5;
        }
        return num == 1;
    }

    //找到最小值
    public static int min(int a, int b, int c) {
        int temp = a > b ? b : a;
        return c > temp ? temp : c;
    }
}