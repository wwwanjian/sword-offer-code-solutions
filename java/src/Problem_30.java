import java.util.Stack;

/**
 * @author wwwanjian
 * @className Problem_30
 * @description TODO
 * @create 2019/5/8 0:31
 * @vsersion 1.0
 **/
//设计一个栈包含min函数，push pop min时间复杂度都是O（1）
public class Problem_30 {
    public static void main(String args[]) {
        //创建栈
        StackWithMin stackWithMin = new StackWithMin();
        //测试push、pop、和min
        stackWithMin.Push(2);
        stackWithMin.Push(3);
        stackWithMin.Push(0);
        stackWithMin.Pop();
        System.out.println(stackWithMin.Min());
    }
}

//栈类
//思路1：用一个成员变量存储min，但是如果min被弹出怎么办
//思路2：用一个辅助栈保存每一步的最小值，和栈同步弹出就行
class StackWithMin {
    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> support = new Stack<>();

    public StackWithMin() {
    }

    //push
    public boolean Push(int value) {
        stack.push(value);
        //不为空的话
        if (!support.isEmpty()) {
            if (value < support.lastElement()) {
                support.push(value);
            } else {
                support.push(support.lastElement());
            }
        } else {//不为空
            support.push(value);
        }
        return true;
    }

    //pop
    public int Pop() {
        //为空处理
        if (stack.isEmpty()) {
            return -1;
        }
        support.pop();
        return stack.pop();
    }

    //min
    public int Min() {
        //为空处理
        if (support.isEmpty()) {
            return -1;
        }
        return support.lastElement();
    }

}