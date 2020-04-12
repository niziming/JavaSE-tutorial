package itcast.day19.demo;

public class Demo {
    String name;
    public Demo() {}

    public Demo(String name) {this.name = name;}

    public static void main(String[] args) {
        // b(1);
        int i = countNum(2, 2);
        System.out.println(i);
    }
    public static void b(int i){
        System.out.println(i);
        if (i == 10) return;
        b(++i);
    }
    public static int countNum(int a, int b){
        if (a == b) return a;
        return a + countNum(++a, b);
    }
}
