package itcast.chap10.demo5;

public class Polymorphic {
    public static void main(String[] args) {
        Cat cat = new Cat();
        Dog dog = new Dog();
        cat.eat();
        dog.eat();

        // 向上转型
        Animal animal = new Cat();
        animal.eat();

        // 向下转型
        Cat animal1 = (Cat) animal;
        animal.eat();

        // 转型的异常 ClassCastException
        // 向下转型 
        // Dog d = (Dog)animal;
        System.out.println(animal instanceof Animal);
        System.out.println(animal instanceof Cat);
        System.out.println(animal instanceof Dog);
        System.out.println(cat instanceof Animal);
        // d.eat();
    }

}
