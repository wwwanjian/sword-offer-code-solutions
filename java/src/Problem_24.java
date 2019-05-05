/**
 * @author wwwanjian
 * @className Problem_24
 * @description TODO
 * @create 2019/5/5 22:18
 * @vsersion 1.0
 **/
//反转链表
public class Problem_24 {
    public static void main(String args[]) {
        //构造链表
        Node_24 node_1 = new Node_24(1);
        Node_24 node_2 = new Node_24(2);
        Node_24 node_3 = new Node_24(3);
        Node_24 node_4 = new Node_24(4);
        Node_24 node_5 = new Node_24(5);
        node_1.setNext(node_2);
        node_2.setNext(node_3);
        node_3.setNext(node_4);
        node_4.setNext(node_5);
        int k=9;
        //反转链表
        long start = System.nanoTime();
        Node_24 head = recerverLink(node_1);
        long end = System.nanoTime();
        System.out.println("总共用时(ns):" + (end - start));
        //输出结果
        System.out.println(head.getValue());
    }

    //反转链表  遍历并且改变指针方向
    public static Node_24 recerverLink(Node_24 head) {
        if (head==null||head.getNext()==null){
            return head;
        }
        //记录三个指针
        Node_24 temp = head;
        Node_24 pre = temp;
        Node_24 next = temp.getNext();
        while (next.getNext()!=null){//next到达最后一个节点
            temp = next;
            next = next.getNext();
            temp.setNext(pre);
            pre = temp;
        }
        //最后一个节点指向前一个
        next.setNext(temp);
        head.setNext(null);//第一个节点指向空
        return next;
    }
}

//节点数据结构
class Node_24 {
    private int value;
    private Node_24 next;

    public Node_24() {
    }

    public Node_24(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public Node_24 getNext() {
        return next;
    }

    public void setNext(Node_24 next) {
        this.next = next;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
