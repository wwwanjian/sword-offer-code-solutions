/**
 * @file null.java
 * @auther wwwanjian
 * @create 2019-04-26 16:48
 */
//找到二叉树中给点节点中序遍历的下一个节点
public class Problem_8 {
    public static void main(String[] args) {
        //构造二叉树
        TreeNodeP a= new TreeNodeP('a');
        TreeNodeP b= new TreeNodeP('b');
        TreeNodeP c= new TreeNodeP('c');
        TreeNodeP d= new TreeNodeP('d');
        TreeNodeP e= new TreeNodeP('e');
        TreeNodeP f= new TreeNodeP('f');
        TreeNodeP g= new TreeNodeP('g');
        TreeNodeP h= new TreeNodeP('h');
        TreeNodeP i= new TreeNodeP('i');
        a.setlChild(b);
        a.setrChild(c);
        b.setlChild(d);
        b.setrChild(e);
        b.setpChild(a);
        c.setlChild(f);
        c.setrChild(g);
        c.setpChild(a);
        d.setpChild(b);
        e.setlChild(h);
        e.setrChild(i);
        e.setpChild(b);
        f.setpChild(c);
        g.setpChild(c);
        h.setpChild(e);
        i.setpChild(e);
        //得到指定节点的下一节点
        long start = System.nanoTime();
        TreeNodeP next = getNext(a);
        long end = System.nanoTime();
        System.out.println("总共用时(ns):"+(end-start));

        //打印节点
        System.out.println(next.getValue());
    }

    //得到下一节点 用时4400ns
    public static TreeNodeP getNext(TreeNodeP node){
        TreeNodeP next = null;
        //如果有右子树，则下一节点就是右子树最左子节点
        if (node.getrChild()!=null){
            TreeNodeP temp = node.getrChild();
            while (temp.getlChild()!=null){
                temp = temp.getlChild();
            }
            next = temp;
        }
        else if(node.getpChild()!=null){//如果没有右子树但是有父节点
            //如果是父节点左子节点，下一节点就是父节点
            if(node==node.getpChild().getlChild()) {
                next = node.getpChild();
            }
            else {// 如果是右子节点，下一节点是向上直到找到一个是父节点左子节点的节点
                TreeNodeP temp = node.getpChild();
                TreeNodeP current = node;
                while (temp!=null&&current==temp.getrChild()){
                    current = temp;
                    temp = temp.getpChild();
                }
                next = temp;
            }
        }
        return next;
    }
}


//节点数据结构
class TreeNodeP{
    private char value;
    private TreeNodeP lChild;
    private TreeNodeP rChild;
    private TreeNodeP pChild;
    public TreeNodeP(){}
    public TreeNodeP(char value){
        this.value = value;
    }

    public void setValue(char value) {
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

    public char getValue() {
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
