/**
 * @author wwwanjian
 * @className Problem_25
 * @description TODO
 * @create 2019/5/5 23:18
 * @vsersion 1.0
 **/
//合并排序的链表，并且排序
public class Problem_25 {
    public static void main(String args[]) {
        //构造链表
        Node_25 node_1 = new Node_25(1);
        Node_25 node_2 = new Node_25(2);
        Node_25 node_3 = new Node_25(2);
        Node_25 node_4 = new Node_25(4);
        Node_25 node_5 = new Node_25(5);
        node_1.setNext(node_2);
        node_2.setNext(node_3);
        node_3.setNext(node_4);
        node_4.setNext(node_5);
        Node_25 node_6 = new Node_25(3);
        Node_25 node_7 = new Node_25(5);
        Node_25 node_8 = new Node_25(7);
        Node_25 node_9 = new Node_25(9);
        Node_25 node_10 = new Node_25(10);
        node_6.setNext(node_7);
        node_7.setNext(node_8);
        node_8.setNext(node_9);
        node_9.setNext(node_10);
        //合并链表
        int k;
        long start = System.nanoTime();
        Node_25 head = mergeTwoSortedLink(node_1, node_6);
        long end = System.nanoTime();
        System.out.println("总共用时(ns):" + (end - start));
        //输出结果
        Node_25 temp = head;
        System.out.println(temp.getValue());
        while (temp.getNext()!=null){
            temp = temp.getNext();
            System.out.println(temp.getValue());
        }
    }
    //合并链表，递归比较当前节点
    public static Node_25 mergeTwoSortedLink(Node_25 link1, Node_25 link2) {
        //输入检测
        if (link1==null&&link2==null){
            return null;
        }
        else if (link1!=null&&link2==null){
            return link1;
        }
        else if (link1==null&&link2!=null){
            return link2;
        }
        //合并链表
        Node_25 head = null;
        //得到头结点
        if (link1.getValue()>link2.getValue()){
            head = link2;
            link2 = link2.getNext();
            head.setNext(mergeTwoSortedLink(link1,link2));
        }
        else {
            head = link1;
            link1 = link1.getNext();
            head.setNext(mergeTwoSortedLink(link1,link2));
        }
        return head;
    }
}

//节点数据结构
class Node_25 {
    private int value;
    private Node_25 next;

    public Node_25() {
    }

    public Node_25(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public Node_25 getNext() {
        return next;
    }

    public void setNext(Node_25 next) {
        this.next = next;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
