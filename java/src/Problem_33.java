/**
 * @author wwwanjian
 * @className Problem_33
 * @description TODO
 * @create 2019/5/8 10:57
 * @vsersion 1.0
 **/
//判断某序列是不是某二叉搜索树的后序遍历
public class Problem_33 {
    public static void main(String args[]) {
        //输入序列
        int[] backOrder = {4, 11, 6, 14, 16, 15, 10};
        //判断是不是后续遍历
        boolean result = isBackOrder(backOrder);
        //输出结果
        System.out.println(result);
    }

    //判断是不是后续遍历
    //思路：后序遍历最后一个是根节点，二叉搜索树比它大的是右子树小的是左子树，则可以分治递归
    public static boolean isBackOrder(int[] arr) {
        //输入检测
        if (arr == null || arr.length < 1) {
            return false;
        }
        boolean result = isBackOrderRecur(arr, 0, arr.length);
        return result;
    }

    //递归函数  找到根节点，然后判断左右子树递归，
    public static boolean isBackOrderRecur(int[] arr, int start, int end) {
        //找到根节点
        int root = arr[end - 1];
        //找到左子树
        int i;
        for (i = start; i < end - 1; ++i) {
            if (arr[i] > root) {
                break;
            }
        }
        //右子树比root大
        int j;
        for (j = i; j < end - 1; ++j) {
            if (arr[j] < root) {
                return false;
            }
        }
        //递归
        boolean left = true;
        if (i > start) {
            left = isBackOrderRecur(arr, start, i);
        }
        boolean right = true;
        if (i < end - 1) {
            right = isBackOrderRecur(arr, i, end - 1);
        }
        return left && right;
    }
}