package itcast.day10.demo5;

public class Main {
    public static void main(String[] args) {
        Animal a = new Cat();
        a.eat();

        try {
            Dog d = (Dog)a;
            a.eat();
        } catch (Exception e) {
            String string = e.toString();
        }
    }
    public static void showCatEat (Cat c) {
        c.eat();
    }
    public static void showDogEat (Dog d) {
        d.eat();
    }
    public static void showAnimalEat (Animal a) {
        a.eat();
    }
}
