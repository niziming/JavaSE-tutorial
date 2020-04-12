package itcast.day10.demo3;

public class C implements A, B {

    @Override
    public void method() {
        System.out.println("我是A类的方法");
    }

    /**
     * 小贴士：
     * 子接口重写默认方法时，default关键字可以保留。
     * 子类重写默认方法时，default关键字不可以保留。
     * @param args
     */
    public static void main(String[] args) {
        new C().method();
    }
}
