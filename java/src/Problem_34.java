import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author wwwanjian
 * @className Problem_34
 * @description TODO
 * @create 2019/5/8 16:01
 * @vsersion 1.0
 **/
//打印二叉树中节点值和为整数的所有路径
public class Problem_34 {
    public static void main(String args[]) {
        //构建二叉树
        Node_34 node_1 = new Node_34(1);
        Node_34 node_2 = new Node_34(2);
        Node_34 node_3 = new Node_34(3);
        Node_34 node_4 = new Node_34(4);
        Node_34 node_5 = new Node_34(5);
        Node_34 node_6 = new Node_34(6);
        Node_34 node_7 = new Node_34(7);
        node_1.setpLeft(node_2);
        node_1.setpRight(node_3);
        node_2.setpLeft(node_5);
        node_2.setpRight(node_7);
        node_3.setpLeft(node_4);
        node_3.setpRight(node_6);
        int sum = 10;
        //找到路径打印路径
        printPathEqualToNumuric(node_1, sum);
    }

    //找到路径并打印
    //思路：用栈存储路径，递归寻找直到叶节点
    public static void printPathEqualToNumuric(Node_34 root, int sum) {
        //输入检测
        if (root == null || sum == 0) {
            return;
        }
        int currentSum = 0;
        Stack<Integer> path = new Stack<>();
        findPathRecur(root, sum, path, currentSum);
    }

    //递归函数
    public static void findPathRecur(Node_34 root, int sum, Stack<Integer> path, int currentSum) {
        //该节点加入路径
        path.push(root.getValue());
        currentSum += root.getValue();
        //当前是不是叶节点
        if (root.getpLeft() == null && root.getpRight() == null) {
            //判断是不是找到路径
            if (currentSum == sum) {
                for (int i : path) {
                    System.out.print(i);
                    System.out.print(" ");
                }
                System.out.println();
            }
        }
        //继续递归左右子树
        if (root.getpLeft() != null) {
            findPathRecur(root.getpLeft(), sum, path, currentSum);
        }
        if (root.getpRight() != null) {
            findPathRecur(root.getpRight(), sum, path, currentSum);
        }
        //回到父节点
        path.pop();
    }
}

//二叉树节点
class Node_34 {
    private int value;
    private Node_34 pLeft;
    private Node_34 pRight;

    public Node_34() {
    }

    public Node_34(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public Node_34 getpLeft() {
        return pLeft;
    }

    public Node_34 getpRight() {
        return pRight;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setpLeft(Node_34 pLeft) {
        this.pLeft = pLeft;
    }

    public void setpRight(Node_34 pRight) {
        this.pRight = pRight;
    }
}
