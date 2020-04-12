package itcast.chap27annotation;

public class Main {
    public static void main(String[] args) {
        method();
    }

    @MyDocumented
    public static String method() {
        /**
         * 测试docment
         */
        return "你好Doc";
    }
}
