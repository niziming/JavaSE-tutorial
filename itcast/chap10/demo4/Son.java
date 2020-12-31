package itcast.chap10.demo4;

public class Son extends Father implements InterfaceDemo, InterfaceDemo1 {
    // 重写接口中抽象方法【必须】
    // 重写接口中默认方法【不重名时可选】
    // public void show() {
    //     super.show();
    //     System.out.println("我是子");
    // }

    public static void main(String[] args) {
        Son son = new Son();
        son.show();
        son.method1();
        son.demo();
        son.demo1();
        son.method2();
        InterfaceDemo.staticMethod();
        InterfaceDemo1.staticMethod();
    }

    @Override
    public void demo() {
        System.out.println("实现demo接口");
    }

    @Override
    public void method1() {
        System.out.println("实现demo CollectionUsed 中重复的默认方法");
    }

    @Override
    public void demo1() {
        System.out.println("实现demo1接口");
    }
}
