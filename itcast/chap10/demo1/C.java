package itcast.day10.demo1;

public class C implements A, B {

    @Override
    public void show() {
        System.out.println("nothing");
    }

    public static void main(String[] args) {
        C c = new C();
        c.show();
    }

}
