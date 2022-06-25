package chap13.demo4;

public class GenericMethod {
    // 修饰符 <代表泛型的变量> 返回值类型 方法名(参数){  }
    public <E> void show (E e) {
        System.out.println(e.getClass());
    }
    public <E> void show1 (E e) {
        System.out.println(e.getClass());
    }
    public static <E> void show2 (E e) {
        System.out.println(e.getClass());
    }

    public static void main(String[] args) {
        GenericMethod genericMethod = new GenericMethod();
        genericMethod.show(1);
    }
}
