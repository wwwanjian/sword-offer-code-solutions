/**
 * @author wwwanjian
 * @className Problem_36
 * @description TODO
 * @create 2019/5/8 18:58
 * @vsersion 1.0
 **/
//将二叉搜索树转化为双向链表，不能创建新节点
public class Problem_36 {
    public static void main(String args[]) {
        //构建二叉搜索树
        Node_36 node_1 = new Node_36(10);
        Node_36 node_2 = new Node_36(6);
        Node_36 node_3 = new Node_36(14);
        Node_36 node_4 = new Node_36(4);
        Node_36 node_5 = new Node_36(8);
        Node_36 node_6 = new Node_36(12);
        Node_36 node_7 = new Node_36(16);
        node_1.setpLeft(node_2);
        node_1.setpRight(node_3);
        node_2.setpLeft(node_4);
        node_2.setpRight(node_5);
        node_3.setpLeft(node_6);
        node_3.setpRight(node_7);
        //转化成双向链表
        Node_36 phead = toBidirecLink(node_1);
        //打印结果
        System.out.println(phead.getValue());
    }

    //转为双向链表
    //思路：二叉树的中序遍历即可得到从小到大的排列，在遍历的过程中把指针调整为双向链表
    public static Node_36 toBidirecLink(Node_36 root) {
        //输入检查
        if (root == null) {
            return null;
        }
        //中序遍历并调整
        Node_36 pLast = new Node_36();
        pLast = midQueryAndAdjust(root, pLast);
        Node_36 pHead = pLast;
        while (pHead.getpLeft() != null&&pHead.getpLeft().getValue()!=-1) {
            pHead = pHead.getpLeft();
        }
        return pHead;

    }

    //二叉树递归中序遍历并调整
    public static Node_36 midQueryAndAdjust(Node_36 root, Node_36 pLast) {
        if (root == null) {
            return null;
        }
        Node_36 pCurrent = root;
        if (pCurrent.getpLeft() != null) {
            pLast = midQueryAndAdjust(pCurrent.getpLeft(), pLast);
        }
        pCurrent.setpLeft(pLast);
        if (pLast.getValue() != -1) {
            pLast.setpRight(pCurrent);
        }
        pLast = pCurrent;
        if (pCurrent.getpRight() != null) {
            pLast = midQueryAndAdjust(pCurrent.getpRight(), pLast);
        }
        return pLast;
    }
}

//二叉树节点
class Node_36 {
    private int value = -1;
    private Node_36 pLeft;
    private Node_36 pRight;

    public Node_36() {
    }

    public Node_36(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public Node_36 getpLeft() {
        return pLeft;
    }

    public Node_36 getpRight() {
        return pRight;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setpLeft(Node_36 pLeft) {
        this.pLeft = pLeft;
    }

    public void setpRight(Node_36 pRight) {
        this.pRight = pRight;
    }
}
