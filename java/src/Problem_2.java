/**
 * @file null.java
 * @auther wwwanjian
 * @create 2019-04-25 16:00
 */
public class Problem_2 {
    public static void main(String[] args) {

    }
}

//饿汉式 线程安全
class Test {
    private Test() {
    };
    private static final Test t = new Test();

    public static Test getInstance() {
        return t;
    }
}

//懒汉式 线程不安全 多线程会出问题
class Test_2 {
    private static volatile Test_2 t = null;

    private Test_2() {};

    public static Test_2 getInstance() {
        if (t == null) {
            synchronized (Test_2.class) {
                if (t == null) {
                    t = new Test_2();
                }
            }
        }
        return t;
    }
}