package chap10.demo1;

public interface InterfaceDefinition {
    // 抽象方法 JDK 7及以前
    // 默认方法 JDK 8
    // 静态方法 JDK 8
    // 私有方法 JDK 9
    void method(); // abstract可以省略

    // 默认方法：使用 default 修饰，不可省略，供子类调用或者子类重写。
    default void defaultMethod () {
    }

    // 静态方法：使用 static 修饰，供接口直接调用。
    static void staticMethod () {
    }

    // 私有方法：使用 private 修饰，供接口中的默认方法或者静态方法调用。
    private void privateMethod () {
        //do something
    }
}
