package chap17.demo2;

public class MyThread extends Thread {
    MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            //getName()方法 来自父亲
            System.out.println(getName() + i);
        }
    }

    public static void main(String[] args) {
        System.out.println("main开始执行");
        MyThread jermaine = new MyThread("jermaine");
        //开启了一个新的线程
        jermaine.start();
        for (int i = 0; i < 30; i++) {
            System.out.println("非线程" + i);
        }
    }
}
