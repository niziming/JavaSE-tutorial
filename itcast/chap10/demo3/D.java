package itcast.day10.demo3;

public interface D extends A, B {
    @Override
    default void method() {
        System.out.println("InterfaceD extends A, B");
    }
}
