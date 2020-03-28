package itcast.day10;

public class C implements A, B {
    @Override
    public void show() {
        System.out.println("我是show");
    }

    @Override
    public void showA() {
        System.out.println("我是showa");
    }

    @Override
    public void showB() {
        System.out.println("我是showb");
    }

    public static void main(String[] args) {
        C c = new C();
        c.show();
        c.showA();
        c.showB();
    }
}
