/**
 * @author wwwanjian
 * @className Problem_26
 * @description TODO
 * @create 2019/5/6 14:54
 * @vsersion 1.0
 **/
//判断B是不是A的子树
public class Problem_26 {
    public static void main(String args[]) {
        //构造树
        Node_26 node_A_1 = new Node_26(1);
        Node_26 node_A_2 = new Node_26(2);
        Node_26 node_A_3 = new Node_26(3);
        Node_26 node_A_4 = new Node_26(4);
        Node_26 node_A_5 = new Node_26(5);
        node_A_1.setpLeft(node_A_2);
        node_A_2.setpLeft(node_A_3);
        node_A_3.setpLeft(node_A_4);
        node_A_4.setpLeft(node_A_5);
        Node_26 node_B_1 = new Node_26(1);
        Node_26 node_B_2 = new Node_26(2);
        Node_26 node_B_3 = new Node_26(3);
        node_B_1.setpLeft(node_B_2);
        node_B_2.setpLeft(node_B_3);
        //判断是不是子树
        long start = System.nanoTime();
        boolean isChild = isChildTree_2(node_A_1, node_B_1);
        long end = System.nanoTime();
        System.out.println("总共用时(ns):" + (end - start));
        //打印结果
        System.out.println(isChild);
    }

    //判断B树是不是A树子树 思路：B完全和A的前序和中序遍历部分重复则是子树
    public static boolean isChildTree_1(Node_26 headOfA, Node_26 headOfB) {
        //输入检测
        if (headOfA==null||headOfB==null){
            return false;
        }
        //得到两树的前序遍历

        //得到两树的中序遍历

        //比较前序和中序遍历
        return false;
    }

    //遍历A树找到和B树根节点相同的节点在判断子树
    public static boolean isChildTree_2(Node_26 headOfA, Node_26 headOfB){
        //输入检测
        if (headOfA==null||headOfB==null){
            return false;
        }
        //递归遍历
        boolean result = false;
        if (headOfA.getValue()==headOfB.getValue()){
            result = hasSameChild(headOfA,headOfB);
        }
        if (!result){
            result = isChildTree_2(headOfA.getpRight(),headOfB);
        }
        if (!result){
            result = isChildTree_2(headOfA.getpLeft(),headOfB);
        }
        return result;
    }
    //检查子树是否相同
    public static boolean hasSameChild(Node_26 headOfA, Node_26 headOfB){
        //B树为空说明包含于A树
        if (headOfB==null){
            return true;
        }
        //B树不为空A树为空说明B不是A的子
        if (headOfA==null){
            return false;
        }
        //两个值不相等
        if (headOfA.getValue()!=headOfB.getValue()){
            return false;
        }
        //相等的话判断左右子树
        return hasSameChild(headOfA.getpLeft(),headOfB.getpLeft())&&hasSameChild(headOfA.getpRight(),headOfB.getpRight());
    }
}

//树节点数据结构
class Node_26 {
    private int value;
    private Node_26 pLeft;
    private Node_26 pRight;

    public Node_26() {
    }

    public Node_26(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public Node_26 getpLeft() {
        return pLeft;
    }

    public Node_26 getpRight() {
        return pRight;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setpLeft(Node_26 pLeft) {
        this.pLeft = pLeft;
    }

    public void setpRight(Node_26 pRight) {
        this.pRight = pRight;
    }
}