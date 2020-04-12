package itcast.day18.demo03;

public class RunnableImpl implements Runnable{
    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " 多线程任务执行!");
    }
}
