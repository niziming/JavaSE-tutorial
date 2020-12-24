package itcast.chap09.demo;

abstract class User {
    String name;
    int money;
    abstract void sendRedPkg (int amount);
    abstract void recRedPkg (int amount, int peopleNum);
}
