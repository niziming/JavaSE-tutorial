package itcast.day18.demo;

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
                if (b.flag == false) {
                    try {
                        b.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("吃货正在吃: " + b.pier + b.xianer + " 包子");
                b.flag = false;
                b.notify();
            }
        }
    }
}
