package chap24stream.demo02;

public class Main {
    public static void main(String[] args) {
        Student student = new Student();
        method(student::getSomeInfo);
    }

    public static void method(Print p) {
        p.print(new Student());
    }

}
