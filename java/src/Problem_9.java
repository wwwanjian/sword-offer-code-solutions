import javax.xml.stream.events.StartDocument;
import java.util.Stack;

/**
 * @author wwwanjian
 * @className Problem_9
 * @description TODO
 * @create 2019/4/28 10:06
 * @vsersion 1.0
 **/
//用两个栈实现一个队列
public class Problem_9 {
    public static void main(String args[]) {
        CQuce queue = new CQuce();
        queue.appendTail('a');
        queue.appendTail('b');
        queue.appendTail('c');
        long start = System.nanoTime();
        char c = queue.deleteHead();
        long end = System.nanoTime();
        System.out.println("总共用时(ns):"+(end-start));
        System.out.println(c);
    }
}

class CQuce{
    private Stack<Character> stack_1 = new Stack<>();
    private Stack<Character> stack_2 = new Stack<>();
    public CQuce(){};
    public void appendTail(char c){
        stack_1.add(c);
    }
    //用时21100ns
    public char deleteHead(){
        if (stack_2.isEmpty()){
            while (!stack_1.isEmpty()){
                char c = stack_1.pop();
                stack_2.add(c);
            }
            return stack_2.pop();
        }
        else {
            return stack_2.pop();
        }
    }
}
