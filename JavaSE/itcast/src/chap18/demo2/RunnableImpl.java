package chap18.demo2;

public class RunnableImpl implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " 开始执行");
    }

    public static void main(String[] args) {
        // 阶段1
        RunnableImpl runnable = new RunnableImpl(); // 实现了接口
        new Thread(runnable).start();

        // 阶段2
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " 开始执行");
            }
        }).start();

        // 阶段3
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " 开始执行");
        }).start();

        // 阶段4
        new Thread(() -> System.out.println(Thread.currentThread().getName() + " 开始执行")).start();

        // Lambda表达式的标准格式为：
        // (参数类型 参数名称) ‐> { 代码语句 }

    }
}
