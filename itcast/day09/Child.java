package itcast.day09;

public class Child extends Father {
    int num = 6;

    public void show() {
        System.out.println("father" + super.num);
        System.out.println("child" + num);
    }
}
