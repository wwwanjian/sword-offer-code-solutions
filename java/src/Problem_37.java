import org.omg.PortableInterceptor.NON_EXISTENT;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wwwanjian
 * @className Problem_37
 * @description TODO
 * @create 2019/5/8 20:08
 * @vsersion 1.0
 **/
//实现序列化和反序列化二叉树
public class Problem_37 {
    public static void main(String args[]) {
        //构建二叉树
        Node_37 node_1 = new Node_37(1);
        Node_37 node_2 = new Node_37(2);
        Node_37 node_3 = new Node_37(3);
        Node_37 node_4 = new Node_37(4);
        Node_37 node_5 = new Node_37(5);
        Node_37 node_6 = new Node_37(6);
        node_1.setpLeft(node_2);
        node_1.setpRight(node_3);
        node_2.setpLeft(node_4);
        node_3.setpLeft(node_5);
        node_3.setpRight(node_6);
        //序列化与反序列化
        Solution so = new Solution();
        String str = so.Serialize(node_1);
        Node_37 pHead = so.Deserialize(str);
        //打印结果
        System.out.println();
    }

    //序列化二叉树
    //思路：前序遍历把空指针也记录下来保证还原二叉树
    public static void serilizerBiTree(Node_37 root, ArrayList<Character> str) {
        str.add((char) (root.getValue() + 48));
        if (root.getpLeft() == null) {
            str.add('$');
        } else {
            serilizerBiTree(root.getpLeft(), str);
        }
        if (root.getpRight() == null) {
            str.add('$');
        } else {
            serilizerBiTree(root.getpRight(), str);
        }
    }

    //反序列化二叉树
    public static void deSerilizerBiTree(Node_37 root, ArrayList<Character> str, List<Integer> index) {
        if (str.get(index.get(0)) != '$') {
            root = new Node_37(str.get(index.get(0)) - 48);
            index.set(0, index.get(0) + 1);
            deSerilizerBiTree(root.getpLeft(), str, index);
            deSerilizerBiTree(root.getpLeft(), str, index);
        }
        index.set(0, index.get(0) + 1);
    }
}

class Solution {
    public int index = -1;
    String Serialize(Node_37 root) {
        StringBuilder s = new StringBuilder();
        if(root == null){
            s.append("#,");
            return s.toString();
        }
        s.append(root.getValue()+",");
        s.append(Serialize(root.getpLeft()));
        s.append(Serialize(root.getpRight()));
        return s.toString();
    }
    Node_37 Deserialize(String str) {
        index++;
        String[] DLRseq = str.split(",");
        Node_37 leave = null;
        if(!DLRseq[index].equals("#")){
            leave = new Node_37(Integer.valueOf(DLRseq[index]));
            leave.setpLeft(Deserialize(str));
            leave.setpRight(Deserialize(str));
        }
        return leave;
    }
}

//二叉树节点
class Node_37 {
    private int value;
    private Node_37 pLeft;
    private Node_37 pRight;

    public Node_37() {
    }

    public Node_37(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public Node_37 getpLeft() {
        return pLeft;
    }

    public Node_37 getpRight() {
        return pRight;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setpLeft(Node_37 pLeft) {
        this.pLeft = pLeft;
    }

    public void setpRight(Node_37 pRight) {
        this.pRight = pRight;
    }
}