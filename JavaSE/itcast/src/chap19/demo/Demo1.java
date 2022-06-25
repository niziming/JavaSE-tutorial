package chap19.demo;

public class Demo1 {
    public static void main(String[] args) {
        int method = method(1, 5);
        System.out.println(method);
    }
    public static int method(int start, int end){
        if (start == end) return start;
        return start * method(++start, end);
    }
}
