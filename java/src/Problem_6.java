import java.util.LinkedList;

/**
 * @file null.java
 * @auther wwwanjian
 * @create 2019-04-26 8:53
 */
//从尾到头打印链表
public class Problem_6 {
    public static void main(String[] args) {
        //构造链表
        Node node_1 = new Node("a");
        Node node_2 = new Node("b");
        Node node_3 = new Node("c");
        Node node_4 = new Node("d");
        Node node_5 = new Node("e");
        node_1.setNext(node_2);
        node_2.setNext(node_3);
        node_3.setNext(node_4);
        node_4.setNext(node_5);
        //从尾到头打印
        Node temp = node_1;
        while (temp.getNext()!=null){
            System.out.print(temp.getValue()+"-->");
            temp = temp.getNext();
        }
        System.out.println(temp.getValue());
        long start = System.nanoTime();
        printNodeFromEndToStart_3(node_1);
        long end = System.nanoTime();
        System.out.println("总共用时(ns):"+(end-start));
    }

    //使用LinkedList的addFrist特性模拟栈+打印 用时：306600ns
    private static void printNodeFromEndToStart_1(Node head){
        //判断空链表
        if(head.getValue()==null){
            return;
        }
        LinkedList<String> ll = new LinkedList<>();
        Node temp = head;
        //添加到链表
        ll.addFirst(temp.getValue());
        while (temp.getNext()!=null){
            temp = temp.getNext();
            ll.addFirst(temp.getValue());
        }
        //遍历链表
        for (String str:ll
             ) {
            System.out.println(str);
        }
    }

    //输出链表
    private static void printNodeFromEndToStart_2(Node head){
        Node resveredHead = reserve_1(head);
        Node temp = resveredHead;
        System.out.println(temp.getValue());
        while (temp.getNext()!=null){
            temp = temp.getNext();
            System.out.println(temp.getValue());
        }
    }
    //用递归反转链表+打印 用时：76999ns
    private static Node reserve_1(Node head){
        if(head.getNext()==null){
            return head;
        }
        Node reservedHead = reserve_2(head.getNext());//得到反转头节点
        head.getNext().setNext(head);//反转指针方向
        head.setNext(null);
        return reservedHead;
    }

    //用循环反转链表+打印 用时:92899ns
    private static Node reserve_2(Node head){
        Node pre = head;
        Node cur = head.getNext();
        Node temp;
        while (cur!=null){
            temp = cur.getNext();
            cur.setNext(pre);
            pre = cur;
            cur = temp;
        }
        head.setNext(null);
        return pre;
    }
    //递归打印 用时:124701
    private static void printNodeFromEndToStart_3(Node head){
        if(head!=null){
            if (head.getNext()!=null){
                printNodeFromEndToStart_3(head.getNext());
            }
            System.out.println(head.getValue());
        }
    }

}

//链表节点数据结构
class Node{
    private String value;
    private Node next;
    public Node(){}
    public Node(String value){
        super();
        this.value = value;
    }
    public Node(String value, Node next){
        super();
        this.value = value;
        this.next = next;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public String getValue() {
        return value;
    }

    public Node getNext() {
        return next;
    }
}
