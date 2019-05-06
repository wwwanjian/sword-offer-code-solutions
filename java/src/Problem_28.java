import jdk.nashorn.internal.objects.NativeInt8Array;

/**
 * @author wwwanjian
 * @className Problem_28
 * @description TODO
 * @create 2019/5/6 21:51
 * @vsersion 1.0
 **/
//判断一棵树是不是对称的
public class Problem_28 {
    public static void main(String args[]) {
        //构造树
        Node_28 node_1 = new Node_28(1);
        Node_28 node_2 = new Node_28(1);
        Node_28 node_3 = new Node_28(1);
        Node_28 node_4 = new Node_28(1);
        Node_28 node_5 = new Node_28(1);
        node_1.setpLeft(node_2);
        node_1.setpRight(node_3);
        node_2.setpLeft(node_4);
        node_2.setpRight(node_5);
        int j;
        //判断是不是对称的
        long start = System.nanoTime();
        boolean result = isSymmetricTree(node_1);
        long end = System.nanoTime();
        System.out.println("总共用时(ns):" + (end - start));
        //打印结果
        System.out.println(result);
    }

    //判断二叉树对称性
    //一种思路是得到二叉树的镜像，然后比较两棵树是否相等(可用前面的B是A的子树问题求解)
    //书中的思路是前序对称遍历和前序遍历一致则该树是对称的
    public static boolean isSymmetricTree(Node_28 root) {
        //输入检测
        if (root == null) {
            return false;
        }
        //检查对称性
        boolean result = isSymmetric(root,root);
        return result;
    }

    //前序和对称前序递归遍历
    public static boolean isSymmetric(Node_28 root1, Node_28 root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        if (root1.getValue() != root2.getValue()) {
            return false;
        }
        return isSymmetric(root1.getpLeft(), root2.getpRight()) && isSymmetric(root1.getpRight(), root2.getpLeft());
    }
}

//树节点数据结构
class Node_28 {
    private int value;
    private Node_28 pLeft;
    private Node_28 pRight;

    public Node_28() {
    }

    public Node_28(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public Node_28 getpLeft() {
        return pLeft;
    }

    public Node_28 getpRight() {
        return pRight;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setpLeft(Node_28 pLeft) {
        this.pLeft = pLeft;
    }

    public void setpRight(Node_28 pRight) {
        this.pRight = pRight;
    }
}
