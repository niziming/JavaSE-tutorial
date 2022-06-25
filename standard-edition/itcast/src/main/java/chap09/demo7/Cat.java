package chap09.demo7;

//一个类只能有一个父类，不可以有多个父类。
public class Cat extends Animal {
    Cat () {
        super();
    }
    void eat() {
        System.out.println("cat : eat");
    }
    void eatTest () {
        this.eat();
        super.eat();

    }
}
