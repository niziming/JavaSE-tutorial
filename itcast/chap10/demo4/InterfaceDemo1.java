package itcast.chap10.demo4;

public interface InterfaceDemo1 {
    void demo1();
    default void method1() {

    }
    default void method2() {
        System.out.println("demo1 default method2接口中，有多个默认方法时，实现类都可继承使用");
    }
    // 静态方法
    // 接口中，存在同名的静态方法并不会冲突，原因是只能通过各自接口名访问静态方法。
    static void staticMethod () {
        System.out.println("demo1 static method");
    }
}
