package itcast.chap09.demo4;

public class Zi extends Fu {
    @Override
    void show() {
        System.out.println("重写了父中的show");
    }

    void show1() {
        System.out.println("Zi中的show1");
    }
}
