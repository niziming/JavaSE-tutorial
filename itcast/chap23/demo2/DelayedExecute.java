package itcast.chap23.demo2;

// Lambda的延迟执行
public class DelayedExecute {
    // 未延迟执行的
    static void log(int level, String msg) {
        System.out.println("log执行了");
        if (level == 1) System.out.println("LOG-debugger-level" + level + ":" + msg);
    }

    // lambda延迟执行的
    static void log1(int level, MsgBuilder builder) {
        System.out.println("log1执行");
        if (level == 1) System.out.println(builder.buildMsg());
    }


    public static void main(String[] args) {
        String a = "Hello";
        String b = "World";
        String c = "Java";
        log(1, "hello");
        log1(1, () -> a+b+c);
        log(2, "hello");
        log1(2, () ->{
            System.out.println("lambda未执行");
            return a+b+c;
        });
    }
}

@FunctionalInterface
interface MsgBuilder{
    String buildMsg ();
}
