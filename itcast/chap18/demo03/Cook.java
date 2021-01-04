package itcast.chap18.demo03;

public interface Cook {
    void makeFood();
    // 接口静态方法
    public static void invokeCook (Cook c) {
        c.makeFood();
    }
    // 接口默认方法
    default void test () {}

    public static void main(String[] args) {
        invokeCook(() -> System.out.println("做饭"));
    }
}
