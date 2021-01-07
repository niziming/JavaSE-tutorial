package itcast.chap18.demo07;

// Lambda省略格式
// 在Lambda标准格式的基础上，使用省略写法的规则为：
//         1. 小括号内参数的类型可以省略；
//         2. 如果小括号内有且仅有一个参，则小括号可以省略；
//         3. 如果大括号内有且仅有一个语句，则无论是否有返回值，都可以省略大括号、return关键字及语句分号。

public interface Cook {
    void makeFood(int a);
    // 接口静态方法
    public static void invokeCook (int a, Cook c) {
        c.makeFood(a);
    }
    // 接口默认方法
    default void test() {}

    public static void main(String[] args) {
        // 之前的做法
        // invokeCook(() -> System.out.println("做饭"));
        // 有且仅有一个参数时
        invokeCook(1, a -> System.out.println("做饭" + a));
    }
}
