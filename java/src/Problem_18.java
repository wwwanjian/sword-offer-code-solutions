import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

/**
 * @author wwwanjian
 * @className Problem_18
 * @description TODO
 * @create 2019/5/5 11:06
 * @vsersion 1.0
 **/
//在O(1)时间内删除链表节点
public class Problem_18 {
    public static void main(String args[]) {
        //创建链表
        Node_18 node_1 = new Node_18(0);
        Node_18 node_2 = new Node_18(0);
        Node_18 node_3 = new Node_18(0);
        node_1.setNext(node_2);
        node_2.setNext(node_3);
        //获取结果
        long start = System.nanoTime();
//        node_1 = deleteNode(node_1,node_1);
        node_1=deleteRelicateNode(node_1);
        PrintLink(node_1);
        long end = System.nanoTime();
        System.out.println("总共用时(ns):" + (end - start));
        //打印结果
//        System.out.println(result);
    }
    //删除指定node  直接用下一个节点覆盖该节点 注意无下一个节点和只有一个节点的情况   还有判断链表中是否存在该节点的是O(n)
    public static Node_18 deleteNode(Node_18 head, Node_18 node){
        //输入检测?

        boolean isTrailNode = false;
        //判断该节点有无下一节点
        if (node.getNext()==null){
            isTrailNode = true;
        }
        //判断该链表是不是只有一个节点
        boolean isSingleLink = false;
        if (head.getNext()==null){
            isSingleLink = true;
        }
        //删除节点
        if (isSingleLink){//只有一个节点
            head = null;
            return head;
        }
        if (isTrailNode){//尾节点
            Node_18 temp = head;
            while (temp.getNext()!=null){
                if (temp.getNext()==node){
                    temp.setNext(null);
                    return head;
                }
                temp = temp.getNext();
            }
        }
        node.setValue(node.getNext().getValue());
        node.setNext(node.getNext().getNext());
        //返回头结点
        return head;
    }
    //删除重复节点
    public static Node_18 deleteRelicateNode(Node_18 head){
        if (head==null){
            return null;
        }
        Node_18 preNode = head;
        Node_18 next = head;
        while (next.getNext()!=null){
            next = next.getNext();
            if (preNode.getValue()==next.getValue()){
                if (next.getNext()!=null){
                    continue;
                }
                else {
                    preNode.setNext(null);
                }
            }
            else {
                preNode.setNext(next);
                preNode = next;
            }
        }
        return head;
    }

    //打印链表
    public static void PrintLink(Node_18 head){
        if (head==null){
            return;
        }
        Node_18 temp = head;
        System.out.print(temp.getValue());
        while (temp.getNext()!=null){
            temp = temp.getNext();
            System.out.print("->");
            System.out.print(temp.getValue());
        }
        System.out.println();
    }
}
//节点数据结构
class Node_18{
    private int value;
    private Node_18 next;
    public Node_18(){}
    public Node_18(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public Node_18 getNext() {
        return next;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setNext(Node_18 next) {
        this.next = next;
    }
}
