package chap11.demo3;

public class InnerDemo {
    public static void main(String[] args) {
        /*
        1.等号右边:是匿名内部类，定义并创建该接口的子类对象
         */
        new FlyAble() {
            @Override
            void fly() {
                System.out.println("hello");
            }
        }.fly();
    }
}
