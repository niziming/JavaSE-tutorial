package chap18.demo2;

// 函数式编程
public class MyRunnable {
    public static void main(String[] args) {
        // 传统写法
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " 开始执行");
            }
        };
        new Thread(runnable).start();

        // lambda
        new Thread(() -> System.out.println("hello")).start();


    }
}
