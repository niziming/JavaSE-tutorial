package chap09;

public class Pig extends Animal {
    @Override
    public void run() {
        System.out.println("im pig i must to be run");
    }

    public static void main(String[] args) {
        new Pig().run();
    }
}
