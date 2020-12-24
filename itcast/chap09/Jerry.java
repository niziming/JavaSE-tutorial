package itcast.chap09;

public class Jerry extends Mouse {
    @Override
    void eat() {
        System.out.println("我是老鼠, 我需要吃饭");
    }

    @Override
    public void run() {
        System.out.println("我是动物我需要奔跑");
    }

    public static void main(String[] args) {
        new Jerry().eat();
        new Jerry().run();
    }
}
