package itcast.day19.demo1;

public class RunnableImpl implements Runnable{
    @Override
    public void run() {
        System.out.println("多线程任务执行!");
    }
}
