package cn.zm.final_test;

public class Son extends Base{
    public void test() {
        System.out.println(2);
    }
    public static void main(String[] args) {
        Son son = new Son();
        Base father = son;
        // father.test();
    }
}
