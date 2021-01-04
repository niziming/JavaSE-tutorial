package itcast.chap18.demo;

public class Chihuo extends Thread{
    Baozi b;
    public Chihuo(String name, Baozi b) {
        super(name);
        this.b = b;
    }
    @Override
    public void run() {
        while (true){
            synchronized (b) {
                if (b.flag) {
                    System.out.println("吃货正在吃: " + b.pier + b.xianer + " 包子");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    b.flag = false;
                    b.notify();
                }
                try {
                    b.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
