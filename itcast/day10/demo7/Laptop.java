package itcast.day10.demo7;


public class Laptop {
    public void run () {
        System.out.println("笔记本运行");
    }
    public void useIO (IO io) {
        if (io != null){
            io.open();
            if (io instanceof Mouse) {
                Mouse m = (Mouse) io;
                m.click();
            } else if (io instanceof KeyBorder) {
                KeyBorder kb = (KeyBorder) io;
                kb.press();
            }
        }
        io.close();
    }
    public void shutDown () {
        System.out.println("笔记本关机");
    }
}
