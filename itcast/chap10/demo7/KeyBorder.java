package itcast.day10.demo7;

public class KeyBorder implements IO {
    @Override
    public void open() {
        System.out.println("键盘开启");
    }

    @Override
    public void close() {
        System.out.println("键盘关闭");
    }

    public void press () {
        System.out.println("键盘打字");
    }
}
