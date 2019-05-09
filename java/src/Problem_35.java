/**
 * @author wwwanjian
 * @className Problem_35
 * @description TODO
 * @create 2019/5/8 16:44
 * @vsersion 1.0
 **/
//实现一个函数复制链表
public class Problem_35 {
    public static void main(String args[]) {
        //构造链表
        Node_35 node_A = new Node_35(1);
        Node_35 node_B = new Node_35(2);
        Node_35 node_C = new Node_35(3);
        Node_35 node_D = new Node_35(4);
        Node_35 node_E = new Node_35(5);
        node_A.setpNext(node_B);
        node_B.setpNext(node_C);
        node_C.setpNext(node_D);
        node_D.setpNext(node_E);
        node_A.setpSibling(node_C);
        node_B.setpSibling(node_E);
        node_D.setpSibling(node_B);
        //复制链表
        Node_35 newlyHead = copyComplexLink(node_A);
        //打印结果
        System.out.println(newlyHead.getValue());
    }
    //复制复杂链表
    //思路1：先复制每个节点和pnext，然后在复制pSibling，这种方法O(n2)时间
    //思路2：创建一个hash表，然后就可以快速定位pSiling，需要O(n)时间和O(n)空间
    //思路3：复制每个节点并连接在相同节点后面
    public static Node_35 copyComplexLink(Node_35 head){
        //输入检测
        if (head==null){
            return null;
        }
        //创建复制节点并连接到原节点后面
        cloneNodeAndLink(head);
        //把pSiling指向下一个
        setPsiling(head);
        //拆分链表
        return splitLink(head);
    }
    //创建节点
    public static void cloneNodeAndLink(Node_35 head){
        Node_35 temp = head;
        while (temp!=null){
            Node_35 newNode = new Node_35();
            newNode.setValue(temp.getValue());
            newNode.setpNext(temp.getpNext());
            temp.setpNext(newNode);
            temp = newNode.getpNext();
        }
    }
    //设置pSiling
    public static void setPsiling(Node_35 head){
        Node_35 temp = head;
        while (temp!=null){
            if (temp.getpSibling()!=null){
                temp.getpNext().setpSibling(temp.getpSibling().getpNext());
            }
            temp = temp.getpNext().getpNext();
        }
    }
    //拆分链表 奇数项是原链表，偶数项是新链表
    public static Node_35 splitLink(Node_35 head){
        Node_35 newHead = head.getpNext();
        Node_35 temp = newHead;
        while (temp.getpNext()!=null){
            temp.setpNext(temp.getpNext().getpNext());
            temp = temp.getpNext();
        }
        return newHead;
    }
}

//节点数据结构
class Node_35{
    private int value;
    private Node_35 pNext;
    private Node_35 pSibling;
    public Node_35(){}
    public Node_35(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public Node_35 getpNext() {
        return pNext;
    }

    public Node_35 getpSibling() {
        return pSibling;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setpNext(Node_35 pNext) {
        this.pNext = pNext;
    }

    public void setpSibling(Node_35 pSibling) {
        this.pSibling = pSibling;
    }
}
