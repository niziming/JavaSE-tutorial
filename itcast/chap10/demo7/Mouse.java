package itcast.day10.demo7;

public class Mouse implements IO {

    @Override
    public void open() {
        System.out.println("鼠标开启");
    }

    @Override
    public void close() {
        System.out.println("鼠标关闭");
    }
    void click () {
        System.out.println("鼠标单击");
    }
}
