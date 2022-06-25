package chap27reflect;


public class ClassExamples {
    public static void main(String[] args) {
        method();
    }
    // 获取class实例的方法
    public static void method() {
        // 通过类型class静态变量
        Class<String> clz1 = String.class;
        String str = "HelloTest";
        // 通过对象的getClass()方法
        Class clz2 = str.getClass();
        Class clz3 = int.class;
        Class clz4= Integer.class;
        System.out.println("clz2类名名称" + clz2.getName());
        System.out.println("clz2是否是接口" + clz2.isInterface());
        System.out.println("clz2是否是数组" + clz2.isArray());
        System.out.println("clz2的父类名" + clz2.getSuperclass());
        System.out.println("clz2是否基本类型" + clz2.isPrimitive());
        System.out.println("clz3是否基本类型" + clz3.isPrimitive());
        System.out.println("clz4是否基本类型" + clz4.isPrimitive());
    }

}
