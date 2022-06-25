package chap17.demo;

public class MyThread extends Thread {
    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if ((i) % 10 == 0) {
                // getName()方法 来自父亲
                System.out.println("-----------" + getName() + i);
            }
            System.out.println(i);
            try {
                Thread.sleep(1000);
                System.out.println("线程睡眠1S");
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
