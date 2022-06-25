package chap11.demo00;

/**
 * 内部类
 */
// 外部类
public class OuterClass {
    private String name = "zhang";
    // 内部类
    class InnerClass {
        public void getName () {
            System.out.println(name);
        }
    }

    public static void main(String[] args) {
        InnerClass innerClass = new OuterClass().new InnerClass();
        innerClass.getName();
    }
}
