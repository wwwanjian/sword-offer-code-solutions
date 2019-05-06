/**
 * @author wwwanjian
 * @className Problem_27
 * @description TODO
 * @create 2019/5/6 20:29
 * @vsersion 1.0
 **/
//输出二叉树的镜像
public class Problem_27 {
    public static void main(String args[]) {
        //构造树
        Node_27 node_A_1 = new Node_27(1);
        Node_27 node_A_2 = new Node_27(2);
        Node_27 node_A_3 = new Node_27(3);
        Node_27 node_A_4 = new Node_27(4);
        Node_27 node_A_5 = new Node_27(5);
        node_A_1.setpLeft(node_A_2);
        node_A_1.setpRight(node_A_3);
        node_A_2.setpLeft(node_A_4);
        node_A_3.setpRight(node_A_5);
        //判断是不是子树
        long start = System.nanoTime();
        Node_27 head = getMirrorTree_1(node_A_1);
        long end = System.nanoTime();
        System.out.println("总共用时(ns):" + (end - start));
        //打印结果
        System.out.println(head.getValue());
    }
    //得到二叉树的镜像  遍历的过程中进行镜像
    public static Node_27 getMirrorTree_1(Node_27 root){
        //错误检测
        if (root==null){
            return null;
        }
        //遍历二叉树
        Node_27 tempLeft = root.getpLeft();
        Node_27 tempRight = root.getpRight();
        root.setpLeft(tempRight);
        root.setpRight(tempLeft);
        getMirrorTree_1(tempLeft);
        getMirrorTree_1(tempRight);
        return root;
    }
}

//树节点数据结构
class Node_27 {
    private int value;
    private Node_27 pLeft;
    private Node_27 pRight;

    public Node_27() {
    }

    public Node_27(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public Node_27 getpLeft() {
        return pLeft;
    }

    public Node_27 getpRight() {
        return pRight;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setpLeft(Node_27 pLeft) {
        this.pLeft = pLeft;
    }

    public void setpRight(Node_27 pRight) {
        this.pRight = pRight;
    }
}
