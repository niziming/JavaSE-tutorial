package itcast.chap10.demo4;

public interface InterfaceDemo {
    void demo();
    public default void show() {
        System.out.println("接口中的show方法");
    }
    default void method1() {
    }
    // 静态方法
    // 接口中，存在同名的静态方法并不会冲突，原因是只能通过各自接口名访问静态方法。
    static void staticMethod () {
        System.out.println("demo4 static method");
    }
}
