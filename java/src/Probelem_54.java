import java.util.ArrayList;
import java.util.List;

/**
 * @author wwwanjian
 * @className Probelem_54
 * @description TODO
 * @create 2019/5/15 15:18
 * @vsersion 1.0
 **/
//找到二叉搜索树的第k大节点
public class Probelem_54 {
    public static int current = 1;

    public static void main(String args[]) {
        //构建二叉搜索树
        Node_54 node_1 = new Node_54(5);
        Node_54 node_2 = new Node_54(3);
        Node_54 node_3 = new Node_54(7);
        Node_54 node_4 = new Node_54(2);
        Node_54 node_5 = new Node_54(4);
        Node_54 node_6 = new Node_54(6);
        Node_54 node_7 = new Node_54(8);
        node_1.setpLeft(node_2);
        node_1.setpRight(node_3);
        node_2.setpLeft(node_4);
        node_2.setpRight(node_5);
        node_3.setpLeft(node_6);
        node_3.setpRight(node_7);
        int k = 1;
        //找到第k大节点
        Node_54 result = findKthMax(node_1, k);
        //输出结果
        System.out.println(result.getValue());
    }

    //入口函数
    public static Node_54 findKthMax(Node_54 root, int k) {
        //输入检查
        if (root == null || k < 1) {
            return null;
        }
        //找到第k大
        Node_54 result = inOrderKth(root, k);
        //返回结果
        return result;
    }

    //找到第k大的节点
    //思路1：中序遍历，第k大就是遍历的第k个
    private static Node_54 inOrderKth(Node_54 root, int k) {
        Node_54 result = null;
        if (root.getpLeft() != null) {
            result = inOrderKth(root.getpLeft(), k);
        }
        if (result != null) {
            return result;
        }
        if (k == current) {
            return root;
        }
        ++current;
        if (root.getpRight() != null) {
            result = inOrderKth(root.getpRight(), k);
        }
        return result;
    }
}

//二叉树节点
class Node_54 {
    private int value;
    private Node_54 pLeft;
    private Node_54 pRight;

    public Node_54() {
    }

    public Node_54(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public Node_54 getpLeft() {
        return pLeft;
    }

    public Node_54 getpRight() {
        return pRight;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setpLeft(Node_54 pLeft) {
        this.pLeft = pLeft;
    }

    public void setpRight(Node_54 pRight) {
        this.pRight = pRight;
    }
}