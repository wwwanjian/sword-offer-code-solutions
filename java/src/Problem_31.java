import javax.naming.InsufficientResourcesException;
import java.util.Stack;

/**
 * @author wwwanjian
 * @className Problem_31
 * @description TODO
 * @create 2019/5/8 9:50
 * @vsersion 1.0
 **/
//输入栈压入顺序，判断序列是否是弹出顺序
public class Problem_31 {
    public static void main(String args[]) {
        //构建栈
        int[] pushOrder = {1, 2, 3, 4, 5};
        int[] popOrder = {4, 5, 3, 1, 2};
        //判断是否弹出顺序
        boolean result = isPopOrder(pushOrder, popOrder);
        //输出结果
        System.out.println(result);
    }

    //判断是否是弹出顺序
    //思路：设计两个栈，主栈为压入顺序，辅助栈按照pop顺序入栈和出栈
    public static boolean isPopOrder(int[] pushOrder, int[] popOrder) {
        //输入检测
        if (pushOrder.length < 1 || popOrder.length < 1) {
            return false;
        }
        Stack<Integer> mainStack = new Stack<>();
        Stack<Integer> supportStack = new Stack<>();
        //按照入栈反序入主栈
        for (int i = pushOrder.length - 1; i >= 0; --i) {
            mainStack.push(pushOrder[i]);
        }
        //按照出栈顺序出入辅助栈
        for (int i : popOrder) {//遍历出栈的数
            if (supportStack.isEmpty() || supportStack.lastElement() != i) {//辅助栈为空或者不等于当前出栈数
                while (!mainStack.isEmpty()) {//一直按照入栈顺序入栈直到全部入栈或者找到出栈的数值
                    int ele = mainStack.pop();//主栈出列
                    if (ele == i) {//找到出栈的数值
                        supportStack.push(ele);//压入辅助栈
                        break;
                    }
                    supportStack.push(ele);//压入辅助栈
                }
                if (mainStack.isEmpty() && supportStack.lastElement() != i) {//如果全部入栈且栈顶不是要找的元素
                    return false;
                }
            }
            //栈顶是要找的元素
            supportStack.pop();
        }
        if (mainStack.isEmpty() && supportStack.isEmpty()) {//两个栈都为空则找到
            return true;
        }
        return false;
    }
}