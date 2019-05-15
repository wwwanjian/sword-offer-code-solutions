/**
 * @author wwwanjian
 * @className Problem_55
 * @description TODO
 * @create 2019/5/15 16:03
 * @vsersion 1.0
 **/
//二叉树的深度
public class Problem_55 {
    public static boolean isBalanced = false;

    public static void main(String args[]) {
        //构建二叉搜索树
        Node_55 node_1 = new Node_55(5);
        Node_55 node_2 = new Node_55(3);
        Node_55 node_3 = new Node_55(7);
        Node_55 node_4 = new Node_55(2);
        Node_55 node_5 = new Node_55(4);
        Node_55 node_6 = new Node_55(6);
        Node_55 node_7 = new Node_55(8);
        node_1.setpLeft(node_2);
        node_1.setpRight(node_3);
        node_2.setpLeft(node_4);
        node_4.setpRight(node_5);
        node_5.setpLeft(node_7);
        node_7.setpRight(node_6);
        //获取树的深度
//        int result = getTreeDepth(node_7);
        boolean result = isBalanceTree(node_5);
        //打印结果
        System.out.println(result);
    }

    //题目一：求树的深度
    public static int getTreeDepth(Node_55 root) {
        //输入检查
        if (root == null) {
            return 0;
        }
        //获得深度
        int depth = getTreeDepthCore(root, 0);
        //返回结果
        return depth;
    }

    //获取树的深度
    //思路：递归左右子树返回最大的那个
    private static int getTreeDepthCore(Node_55 root, int d) {
        int left = d + 1;
        int right = d + 1;
        if (root.getpLeft() != null) {
            left = getTreeDepthCore(root.getpLeft(), left);
        }
        if (root.getpRight() != null) {
            right = getTreeDepthCore(root.getpRight(), right);
        }
        return left > right ? left : right;
    }

    //题目二：判断是不是平衡二叉树
    public static boolean isBalanceTree(Node_55 root) {
        //输入检查
        if (root == null) {
            return false;
        }
        //判断平衡
        isBalanceTreeCore(root);
        //返回结果
        return isBalanced;
    }

    //判断平衡
    //思路1:暴力遍历所有子树深度
    //思路2：避免重复遍历，只遍历一次，后序遍历然后边遍历边判断
    public static int isBalanceTreeCore(Node_55 root) {
        //终止
        if (root == null) {
            isBalanced = true;
            return 0;
        }
        int left = isBalanceTreeCore(root.getpLeft());
        int right = isBalanceTreeCore(root.getpRight());
        if (Math.abs(left - right) <= 1) {
            isBalanced = true;
        } else {
            isBalanced = false;
        }
        return left > right ? left + 1 : right + 1;
    }
}

//二叉树节点
class Node_55 {
    private int value;
    private Node_55 pLeft;
    private Node_55 pRight;

    public Node_55() {
    }

    public Node_55(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public Node_55 getpLeft() {
        return pLeft;
    }

    public Node_55 getpRight() {
        return pRight;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setpLeft(Node_55 pLeft) {
        this.pLeft = pLeft;
    }

    public void setpRight(Node_55 pRight) {
        this.pRight = pRight;
    }
}