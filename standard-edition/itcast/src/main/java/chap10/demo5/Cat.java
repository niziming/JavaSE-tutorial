package chap10.demo5;

public class Cat extends Animal {

    @Override
    void eat() {
        super.eat();
        System.out.println("猫吃鱼");
    }
}
