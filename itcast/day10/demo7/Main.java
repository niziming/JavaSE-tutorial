package itcast.day10.demo7;

public class Main {
    public static void main(String[] args) {
        Laptop lt = new Laptop();
        lt.run();
        IO ioMouse = new Mouse();
        lt.useIO(ioMouse);

        KeyBorder kb = new KeyBorder();
        IO ioK = new KeyBorder();
        lt.useIO(kb);

        lt.shutDown();
    }
}
