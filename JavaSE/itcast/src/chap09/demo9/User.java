package chap09.demo9;

abstract class User {
    String name;
    int money;
    abstract void sendRedPkg (int amount);
    abstract void recRedPkg (int amount, int peopleNum);
    void test () {
        System.out.println("我是抽象类的默认方法");
    }
}
