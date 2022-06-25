package chap10.demo3;

public class Animal1 implements LiveAble {

    @Override
    public void fly() {
        System.out.println("重写默认方法");
    }
}
