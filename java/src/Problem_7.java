import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @file null.java
 * @auther wwwanjian
 * @create 2019-04-26 10:32
 */

//根据前序和中序遍历结果，得到二叉树
public class Problem_7 {
    public static void main(String[] args) {
        //得到前序和中序序列
        int[] preOrder = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] inOrder = {4, 7, 2, 1, 5, 3, 8, 6};
        //根据前序和中序得到二叉树
        long start = System.nanoTime();
        BiTree biTree = new BiTree(preOrder, inOrder);
        long end = System.nanoTime();
        System.out.println("总共用时(ns):" + (end - start));
        //输出二叉树
        BiTree.printBiTreePerFloor(biTree.getHead());
    }
}

//二叉树构建
class BiTree {
    private TreeNode head;

    public BiTree() {
    }

    public BiTree(int[] preOrder, int[] inOrder) {
        //根据前序和中序得到二叉树头节点
        this.head = createBiTree(preOrder, inOrder);
    }

    public TreeNode getHead() {
        return head;
    }

    //二叉树递归构造函数，返回头节点
    private static TreeNode createBiTree(int[] preOrder, int[] inOrder) {
        //输入检测
        if (preOrder.length != inOrder.length || preOrder.length < 1) {
            return new TreeNode();
        }
        TreeNode root = createCore(preOrder, inOrder);
        return root;
    }

    //递归函数
    private static TreeNode createCore(int[] preOrder, int[] inOrder) {
        //递归终止条件
        if (preOrder.length == 1) {
            return new TreeNode(preOrder[0]);
        } else if (preOrder.length == 0) {
            return null;
        }
        //得到根节点
        TreeNode root = new TreeNode(preOrder[0]);
        //划分左右子树的前中序列
        int[] leftPreOrder = {};
        int[] leftInOrder = {};
        int[] rightPreOrder = {};
        int[] rightInOrder = {};
        int i;
        //找到划分点
        for (i = 0; i < inOrder.length; i++) {
            if (inOrder[i] == preOrder[0]) {
                break;
            }
        }
        System.out.println(i);
        //进行划分,需要注意没有左/右子树的情况
        if (i == 0)//没有左子树
        {
            rightPreOrder = Arrays.copyOfRange(preOrder, i + 1, preOrder.length);
            rightInOrder = Arrays.copyOfRange(inOrder, i + 1, inOrder.length);
        } else if (i == preOrder.length - 1) {//没有右子树
            leftPreOrder = Arrays.copyOfRange(preOrder, 1, i + 1);
            leftInOrder = Arrays.copyOfRange(inOrder, 0, i);
        } else {
            leftPreOrder = Arrays.copyOfRange(preOrder, 1, i + 1);
            leftInOrder = Arrays.copyOfRange(inOrder, 0, i);
            rightPreOrder = Arrays.copyOfRange(preOrder, i + 1, preOrder.length);
            rightInOrder = Arrays.copyOfRange(inOrder, i + 1, inOrder.length);
        }
        System.out.println(leftPreOrder.length);
        System.out.println(leftInOrder.length);
        System.out.println(rightPreOrder.length);
        System.out.println(rightInOrder.length);
        //递归得到左右子树的根节点
        root.setlChild(createCore(leftPreOrder, leftInOrder));
        root.setrChild(createCore(rightPreOrder, rightInOrder));
        return root;
    }

    //输出二叉树 按层
    public static void printBiTreePerFloor(TreeNode root) {
        if (root == null) {
            return;
        }
        //用队列存储要打印的节点
        Queue<TreeNode> queue = new LinkedList<>();
        int current;//当前层节点数,当前打印完就回车
        int next;//下一层节点数
        queue.add(root);
        current = 1;
        next = 0;
        while (!queue.isEmpty()) {
            TreeNode temp = queue.remove();
            System.out.print(temp.getValue());
            System.out.print(' ');
            current--;
            if (temp.getlChild() != null) {
                queue.add(temp.getlChild());
                next++;
            }
            if (temp.getrChild() != null) {
                queue.add(temp.getrChild());
                next++;
            }
            if (current == 0) {
                System.out.println();
                current = next;
                next = 0;
            }
        }
    }
}

//节点数据结构
class TreeNode {
    private int value;
    private TreeNode lChild;
    private TreeNode rChild;

    public TreeNode() {
    }

    public TreeNode(int value) {
        this.value = value;
    }

    public TreeNode(int value, TreeNode lChild, TreeNode rChild) {
        this.value = value;
        this.lChild = lChild;
        this.rChild = rChild;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setlChild(TreeNode lChild) {
        this.lChild = lChild;
    }

    public void setrChild(TreeNode rChild) {
        this.rChild = rChild;
    }

    public int getValue() {
        return value;
    }

    public TreeNode getlChild() {
        return lChild;
    }

    public TreeNode getrChild() {
        return rChild;
    }
}
