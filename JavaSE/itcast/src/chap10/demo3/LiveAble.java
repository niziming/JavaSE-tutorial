package chap10.demo3;

public interface LiveAble {
    // abstract void eat();
    // abstract void sleep();
    // 默认方法的使用
    // 可以继承，可以重写，二选一，但是只能通过实现类的对象来调用。
    default void fly(){
        System.out.println("飞");
    }
    // 静态方法的使用
    // 静态与.class 文件相关，只能使用接口名调用，不可以通过实现类的类名或者实现类的对象调用
    static void run(){
        System.out.println("跑");
    }
    // 私有方法的使用
    // 私有方法：只有默认方法可以调用。
    // 私有静态方法：默认方法和静态方法可以调用。
    // 如果一个接口中有多个默认方法，并且方法中有重复的内容，那么可以抽取出来，封装到私有方法中，供默认方法
    // 去调用。从设计的角度讲，私有的方法是对默认方法和静态方法的辅助。同学们在已学技术的基础上，可以自行测试。
    default void defaultMethod() {
        System.out.println("我是默认方法");
        private1();
        private2();
        privateStatic1();
        privateStatic2();
        staticMethod();
    }
    static void staticMethod () {
        System.out.println("我是静态方法");
        privateStatic1();
        privateStatic2();
    }
    private void private1 () {
        System.out.println("私有方法1");
    }
    private void private2 () {
        System.out.println("私有方法2");
    }
    private static void privateStatic1 () {
        System.out.println("私有静态方法1");
    }
    private static void privateStatic2 () {
        System.out.println("私有静态方法2");
    }
}
