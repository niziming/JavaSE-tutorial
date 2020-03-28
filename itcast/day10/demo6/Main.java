package itcast.day10.demo6;

public class Main {
    public static void main(String[] args) {
        Animal c = new Cat();
        Animal d = new Dog();
        System.out.println(c instanceof Cat);
        System.out.println(c instanceof Animal);
        System.out.println(d instanceof Dog);
        System.out.println(d instanceof Animal);
        System.out.println(c instanceof Dog);
        System.out.println(d instanceof Cat);
    }
}
