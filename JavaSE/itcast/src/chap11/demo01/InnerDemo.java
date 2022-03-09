package chap11.demo01;

public class InnerDemo {
    public static void main(String[] args) {
        FlyAble f = new FlyAble() {
            @Override
            public void fly() {
                System.out.println("fly interface");
            }
        };
        f.fly();
    }
}
