package itcast.day19.demo;

public class BaoziPu extends Thread{
    private Baozi b;

    public BaoziPu(String name, Baozi b) {
        super(name);
        this.b = b;
    }

    @Override
    public void run() {
        int count = 0;
        while (true){
            synchronized (b) {
                if (b.flag == true){
                    try {
                        b.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("包子铺开始做包子");
                if (count%2 == 0){
                    b.pier = "冰皮";
                    b.xianer = "五仁";
                } else {
                    b.pier = "薄皮";
                    b.xianer = "牛肉大葱";
                }
                count++ ;
                b.flag = true;
                System.out.println("包子做好了: " + b.pier + b.xianer);
                System.out.println("吃货开始吃包子");
                b.notify();
            }
        }
    }
}
