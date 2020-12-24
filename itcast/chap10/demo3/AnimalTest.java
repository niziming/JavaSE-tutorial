package itcast.chap10.demo3;

public class AnimalTest {
    public static void main(String[] args) {
        Animal animal = new Animal();
        animal.fly();
        Animal1 animal1 = new Animal1();
        animal1.fly();
        // animal.run(); // 【错误】无法继承方法,也无法调用
        LiveAble.run();

        animal1.defaultMethod();
    }
}
