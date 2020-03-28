package itcast.day18.demo06;

public class Main {
    public static void main(String[] args) {
        invokeCal(120, 130, (a,b)->a+b);
    }
    public static void invokeCal(Integer a, Integer b, Calculator c){
        Integer calc = c.calc(a, b);
        // System.out.println("结果是" + calc);
    }
}
