import javax.xml.stream.FactoryConfigurationError;
import java.util.Stack;

/**
 * @author wwwanjian
 * @className Problem_52
 * @description TODO
 * @create 2019/5/15 11:09
 * @vsersion 1.0
 **/
//链表的第一个公共节点
public class Problem_52 {
    public static void main(String args[]) {
        //构造链表
        Node_52 node_1 = new Node_52(1);
        Node_52 node_2 = new Node_52(2);
        Node_52 node_3 = new Node_52(2);
        Node_52 node_4 = new Node_52(4);
        Node_52 node_5 = new Node_52(5);
        node_1.setNext(node_2);
        node_2.setNext(node_3);
        node_3.setNext(node_4);
        node_4.setNext(node_5);
        Node_52 node_6 = new Node_52(6);
        Node_52 node_7 = new Node_52(7);
        Node_52 node_8 = new Node_52(8);
        node_6.setNext(node_7);
        node_7.setNext(node_8);
        node_8.setNext(node_5);
        //找到公共节点
        long start = System.nanoTime();
        Node_52 theFirstComNode = entraince(node_1, node_6);
        long end = System.nanoTime();
        System.out.println("总共用时(ns):" + (end - start));
        //输出结果
        System.out.println(theFirstComNode.getValue());
    }

    //入口
    public static Node_52 entraince(Node_52 head_1, Node_52 head_2) {
        //输入检查
        if (head_1 == null || head_2 == null) {
            return null;
        }
        //找到第一个节点
        Node_52 result = find1stComNode_2(head_1, head_2);
        //返回结果
        return result;
    }

    //找到第一个公共节点
    //思路1：暴力解法，两层遍历 O(mn)
    //思路2：从尾部开始比较，最后一个相同的节点就是第一相同的节点，可以用栈来实现尾部先出，O(m+n)，额外空间m+n
    private static Node_52 find1stComNode_1(Node_52 head_1, Node_52 head_2) {
        //两个链表入栈
        Stack<Node_52> stack_1 = new Stack<>();
        Stack<Node_52> stack_2 = new Stack<>();
        stack_1.push(head_1);
        stack_2.push(head_2);
        Node_52 temp = head_1;
        while (temp.getNext() != null) {
            temp = temp.getNext();
            stack_1.push(temp);
        }
        temp = head_2;
        while (temp.getNext() != null) {
            temp = temp.getNext();
            stack_2.push(temp);
        }
        //出栈比较
        boolean isfinded = false;
        Node_52 temp2 = null;
        Node_52 comNode = null;
        while (!stack_1.isEmpty() && !stack_2.isEmpty()) {
            temp = stack_1.pop();
            temp2 = stack_2.pop();
            if (temp.getValue() != temp2.getValue()) {//找到第一个非公共节点
                isfinded = true;
                break;
            }
            comNode = temp2;
        }
        if (isfinded) {
            return comNode;
        }
        return null;
    }

    //思路3：找到链表长度，然后长的先走到与短的一样长的地方，再同时走开始比较，不需要额外空间
    private static Node_52 find1stComNode_2(Node_52 head_1, Node_52 head_2) {
        //找到两个链表长度
        int length_1 = 1;
        Node_52 temp = head_1;
        while (temp.getNext() != null) {
            ++length_1;
            temp = temp.getNext();
        }
        int length_2 = 1;
        temp = head_2;
        while (temp.getNext() != null) {
            ++length_2;
            temp = temp.getNext();
        }
        //长的先走
        temp = head_1;
        Node_52 temp2 = head_2;
        if (length_1 > length_2) {
            while (length_1 != length_2) {
                temp = temp.getNext();
                --length_1;
            }
        } else {
            while (length_1 != length_2) {
                temp2 = temp2.getNext();
                --length_2;
            }
        }
        //一起走
        while (temp.getNext() != null || temp2 != null) {
            if (temp.getValue() == temp2.getValue()) {
                return temp;
            }
            temp = temp.getNext();
            temp2 = temp2.getNext();
        }
        return null;
    }
}

//节点数据结构
class Node_52 {
    private int value;
    private Node_52 next;

    public Node_52() {
    }

    public Node_52(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public Node_52 getNext() {
        return next;
    }

    public void setNext(Node_52 next) {
        this.next = next;
    }

    public void setValue(int value) {
        this.value = value;
    }
}