import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wwwanjian
 * @className Problem_32
 * @description TODO
 * @create 2019/5/8 10:33
 * @vsersion 1.0
 **/
//按顺序打印二叉树
public class Problem_32 {
    public static void main(String args[]) {
        //构建二叉树
        Node_32 node_1 = new Node_32(1);
        Node_32 node_2 = new Node_32(2);
        Node_32 node_3 = new Node_32(3);
        Node_32 node_4 = new Node_32(4);
        Node_32 node_5 = new Node_32(5);
        Node_32 node_6 = new Node_32(6);
        Node_32 node_7 = new Node_32(7);
        node_1.setpRight(node_2);
        node_2.setpRight(node_3);
        node_3.setpRight(node_4);
        node_4.setpRight(node_5);
        node_5.setpRight(node_6);
        node_6.setpRight(node_7);
        //打印二叉树
        printBiTreeByFloor(node_7);
    }

    //按顺序打印二叉树
    //思路：用队列来辅助存储
    public static void printBiTreeByFloor(Node_32 root) {
        //输入检测
        if (root == null) {
            return;
        }
        //按顺序压入队列
        Queue<Node_32> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {//取一个判断有没有子树，压入后面直到所有都取完
            Node_32 temp = queue.poll();
            System.out.print(temp.getValue());
            System.out.print(',');
            if (temp.getpLeft() != null) {
                queue.offer(temp.getpLeft());
            }
            if (temp.getpRight() != null) {
                queue.offer(temp.getpRight());
            }
        }
    }
}

//树节点数据结构
class Node_32 {
    private int value;
    private Node_32 pLeft;
    private Node_32 pRight;

    public Node_32() {
    }

    public Node_32(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public Node_32 getpLeft() {
        return pLeft;
    }

    public Node_32 getpRight() {
        return pRight;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setpLeft(Node_32 pLeft) {
        this.pLeft = pLeft;
    }

    public void setpRight(Node_32 pRight) {
        this.pRight = pRight;
    }
}