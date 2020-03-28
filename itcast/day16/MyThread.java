package itcast.day16;

public class MyThread extends Thread {
    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        long l = System.currentTimeMillis();
        for (int i = 0; i < 20; i++) {
            System.out.println(getName() + ": running");
        }
        long l1 = System.currentTimeMillis() - l;
        System.out.println(l1);
    }
}
