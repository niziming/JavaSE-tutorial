package itcast.day11.demo01;

public class InnerDemo2 {
    public static void main(String[] args) {
        showFly(new FlyAble() {
            @Override
            public void fly() {
                System.out.println("i can fly");
            }
        });
    }
    public static void showFly (FlyAble f) {
        f.fly();
    }
}
