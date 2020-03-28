package itcast.day10;

public interface InterfaceName {
    // 抽象方法
    abstract void abstractMethod();
    // 抽象方法可以缺省
    void defaultAbstractMethod();
    // 默认方法
    default void defaultMethod() {
        // 执行语句
        System.out.println("我是接口的默认方法");
        privateStaticMethod();
        methodPrivete();
    }
    // 静态方法
    static void staticMethode() {
        System.out.println("我是接口的默认静态方法");
        privateStaticMethod();
        // 执行语句
    }
    // JDK9新增私有方法
    void methodPrivete() {
        // 执行语句
        System.out.println("我是接口的私有方法,只可以被默认方法调用!");
    }

    // JDK9私有静态方法
    static void privateStaticMethod() {
        // 执行语句
        System.out.println("我是接口的私有静态方法, 默认方法和静态方法都可以调用!");
    }
}
