package chap18.demo06;

public interface Calculator {
    Integer calc(Integer a, Integer b);

    public static void invokeCalc(int a, int b, Calculator c) {
        Integer calc = c.calc(a, b);
        System.out.println("result is " + calc);
    }

    public static void main(String[] args) {
        invokeCalc(1, 2, (a, b) -> a + b);
    }
}
