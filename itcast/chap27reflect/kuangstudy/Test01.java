package itcast.chap27reflect.kuangstudy;

public class Test01 {
    public static void main(String[] args) {
        A a = new A();
        System.out.println("a.m = " + a.m);
    }
}

class A{
    static {
        System.out.println("\"A类静态代码块初始化\" = " + "A类静态代码块初始化");
        m = 300;
    }
    static int m = 100;
    public A () {
        System.out.println("A.A无参初始化");
    }
}
