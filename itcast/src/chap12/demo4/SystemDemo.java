package chap12.demo4;

public class SystemDemo {
    public static void main(String[] args) {
        long l = System.currentTimeMillis();
        for (int i = 0; i < 9999; i++) {
            System.out.println(
                    i
            );
        }
        System.out.println(System.currentTimeMillis() - l);
    }
}
