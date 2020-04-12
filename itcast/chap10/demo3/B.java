package itcast.day10.demo3;

public interface B {
    default void method(){
        System.out.println("InterfaceB");
    }
}
