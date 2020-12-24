package itcast.chap09.demo9;


public class Main {
    public static void main(String[] args) {
        Lord lord = new Lord("群主", 100);
        Lord lord1 = new Lord("成员1", 50);
        Lord lord2 = new Lord("成员2", 40);
        lord.sendRedPkg(50);
        lord1.recRedPkg(50, 2);
        lord2.recRedPkg(50, 2);
        System.out.println(lord);
        System.out.println(lord1);
        System.out.println(lord2);
        lord.test();
    }
}
