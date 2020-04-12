package itcast.day17;

public class Main {
    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable, "小强");
        thread.start();
        for (int i = 0; i < 10; i++) {
            System.out.println("旺财" + i);
        }
    }
}
