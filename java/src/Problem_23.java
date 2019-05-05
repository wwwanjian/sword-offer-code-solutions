/**
 * @author wwwanjian
 * @className Problem_23
 * @description TODO
 * @create 2019/5/5 21:44
 * @vsersion 1.0
 **/
//找到环的入口节点
public class Problem_23 {
    public static void main(String args[]) {
        //构造链表
        Node_23 node_1 = new Node_23(1);
        Node_23 node_2 = new Node_23(2);
        Node_23 node_3 = new Node_23(3);
        Node_23 node_4 = new Node_23(4);
        Node_23 node_5 = new Node_23(5);
        node_1.setNext(node_2);
        node_2.setNext(node_3);
        node_3.setNext(node_4);
        node_4.setNext(node_5);
        node_5.setNext(node_2);
        //找到节点
        long start = System.nanoTime();
        Node_23 targetNode = getEntranceNode_1(node_1);
        long end = System.nanoTime();
        System.out.println("总共用时(ns):" + (end - start));
        //输出结果
        if (targetNode!=null) {
            System.out.println(targetNode.getValue());
        }
    }

    //找到入口节点
    public static Node_23 getEntranceNode_1(Node_23 head) {
        //输入检测
        if (head == null) {
            return null;
        }
        //判断环
        boolean isLoop = false;
        Node_23 pFast = head.getNext();
        Node_23 pSlow = head;
        while (pFast != pSlow && pFast != null) {
            if (pFast.getNext() != null && pFast.getNext().getNext() != null) {
                pFast = pFast.getNext().getNext();
            } else {
                isLoop = false;
            }
            if (pSlow.getNext() != null) {
                pSlow = pSlow.getNext();
            }
        }
        if (pFast == pSlow) {
            isLoop = true;
        }
        if (!isLoop) {
            return null;
        }
        //计算环的节点数
        int numOfNode = 1;
        Node_23 temp = pFast.getNext();
        while (temp != pFast) {
            ++numOfNode;
            temp = temp.getNext();
        }
        //找到入口点
        pFast = head;
        pSlow = head;
        for (int i=0;i<numOfNode;++i){//先走节点数的步数
            pFast = pFast.getNext();
        }
        while (pFast!=pSlow){//两个一起走直到相遇
            pFast = pFast.getNext();
            pSlow = pSlow.getNext();
        }
        //返回入口点
        return pFast;
    }

    //判断环 通过两个指针
    public static boolean isLoopLink(Node_23 head) {
        if (head.getNext() == null) {
            return false;
        }
        Node_23 pFast = head.getNext();
        Node_23 pSlow = head;
        while (pFast != pSlow && pFast != null) {
            if (pFast.getNext() != null && pFast.getNext().getNext() != null) {
                pFast = pFast.getNext().getNext();
            } else {
                return false;
            }
            if (pSlow.getNext() != null) {
                pSlow = pSlow.getNext();
            }
        }
        return pFast == pSlow;
    }
}


//节点数据结构
class Node_23 {
    private int value;
    private Node_23 next;

    public Node_23() {
    }

    public Node_23(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public Node_23 getNext() {
        return next;
    }

    public void setNext(Node_23 next) {
        this.next = next;
    }

    public void setValue(int value) {
        this.value = value;
    }
}