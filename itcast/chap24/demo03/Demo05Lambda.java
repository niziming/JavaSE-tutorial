package itcast.day24.demo03;

public class Demo05Lambda {
    public static void method(int num, Calcable lambda) {
        System.out.println(lambda.calc(num));
    }
    public static void main(String[] args) {
        method(-10, num -> Math.abs(num));
        method(-10, Math::abs);
    }
}
