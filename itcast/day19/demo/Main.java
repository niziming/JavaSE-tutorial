package itcast.day19.demo;

public class Main {
    public static void main(String[] args) {
        Baozi b = new Baozi();
        Chihuo c = new Chihuo("吃货", b);
        BaoziPu baoziPu = new BaoziPu("包子铺", b);
        baoziPu.start();
        c.start();
    }
}
