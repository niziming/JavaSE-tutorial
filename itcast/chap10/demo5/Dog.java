package itcast.chap10.demo5;

public class Dog extends Animal {

    @Override
    void eat() {
        super.eat();
        System.out.println("狗吃肉");
    }
}
