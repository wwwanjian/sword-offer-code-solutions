/**
 * @file null.java
 * @auther wwwanjian
 * @create 2019-04-26 16:48
 */
//找到二叉树中给点节点中序遍历的下一个节点
public class Problem_8 {
    public static void main(String[] args) {
        //构造二叉树

        //得到指定节点的下一节点

        //打印节点
    }

    //得到下一节点
    public static TreeNode getNext(TreeNode node){
        TreeNode next = null;
        //如果有右子树，则下一节点就是右子树最左子节点
        if (node.getrChild()!==null){

        }
        //如果没有右子树
            //如果是父节点左子节点，下一节点就是父节点
            //如果是右子节点，下一节点是向上直到找到一个是父节点左子节点的节点
        return new TreeNode();
    }
}


//节点数据结构
class TreeNodeP{
    private int value;
    private TreeNodeP lChild;
    private TreeNodeP rChild;
    private TreeNodeP pChild;
    public TreeNodeP(){}
    public TreeNodeP(int value){
        this.value = value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setlChild(TreeNodeP lChild) {
        this.lChild = lChild;
    }

    public void setrChild(TreeNodeP rChild) {
        this.rChild = rChild;
    }

    public void setpChild(TreeNodeP pChild) {
        this.pChild = pChild;
    }

    public int getValue() {
        return value;
    }

    public TreeNodeP getlChild() {
        return lChild;
    }

    public TreeNodeP getrChild() {
        return rChild;
    }

    public TreeNodeP getpChild() {
        return pChild;
    }
}
