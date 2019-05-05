import com.sun.xml.internal.bind.v2.runtime.NamespaceContext2;

/**
 * @author wwwanjian
 * @className Problem_22
 * @description TODO
 * @create 2019/5/5 20:18
 * @vsersion 1.0
 **/
//链表中倒数第K个节点
public class Problem_22 {
    public static void main(String args[]) {
        //构造链表
        Node_22 node_1 = new Node_22(1);
        Node_22 node_2 = new Node_22(2);
        Node_22 node_3 = new Node_22(3);
        Node_22 node_4 = new Node_22(4);
        Node_22 node_5 = new Node_22(5);
        node_1.setNext(node_2);
        node_2.setNext(node_3);
        node_3.setNext(node_4);
        node_4.setNext(node_5);
        int k = 3;
        //找到节点
        long start = System.nanoTime();
        Node_22 targetNode = findKthNode_2(node_1, k);
        long end = System.nanoTime();
        System.out.println("总共用时(ns):" + (end - start));
        //输出结果
        System.out.println(targetNode.getValue());
    }
    //找到目标节点 把倒数转化为正数 解决问题 但是需要遍历两次链表 用时3500ns
    public static Node_22 findKthNode_1(Node_22 head, int k){
        //输入检测
        if (head==null){
            return null;
        }
        //得到链表长度
        int lengthOfLink = 1;
        Node_22 temp = head;
        while (temp.getNext()!=null){
            temp = temp.getNext();
            ++lengthOfLink;
        }
        //找到正数第n-k+1个节点
        if (k>lengthOfLink){//判断k在链表范围内
            return null;
        }
        Node_22 targetNode = head;
        int index = lengthOfLink-k+1;
        for (int i = 0; i < index-1; i++) {
            targetNode = targetNode.getNext();
        }
        return targetNode;
    }

    //遍历一遍，两个指针，一个先走一个后走 用时3500ns
    public static Node_22 findKthNode_2(Node_22 head, int k){
        //输入检测
        if (head==null||k<1){
            return null;
        }
        Node_22 frontTemp = head;
        for (int i=1;i<k;++i){//先走k-1步，注意超出范围
            if (frontTemp.getNext()!=null){
                frontTemp = frontTemp.getNext();
            }
            else{
                return null;
            }
        }
        Node_22 backTemp = head;
        while (frontTemp.getNext()!=null){
            frontTemp = frontTemp.getNext();
            backTemp = backTemp.getNext();
        }
        return backTemp;
    }
}

//节点数据结构
class Node_22 {
    private int value;
    private Node_22 next;

    public Node_22() {
    }

    public Node_22(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public Node_22 getNext() {
        return next;
    }

    public void setNext(Node_22 next) {
        this.next = next;
    }

    public void setValue(int value) {
        this.value = value;
    }
}