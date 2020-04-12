package itcast.chap27annotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestDemo {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // 通过反射拿到method对象,即对象注释的信息
        Method method = new TestDemo().getClass().getDeclaredMethod("method");
        // Test annotation;
        // annotation = creadThread.getAnnotation(Test.class);
        // creadThread.invoke(new TestDemo());
        // System.out.println(annotation.age() + " : "  + annotation.name());
    }

    /**
     *
     */
    //如果@Test不加上声明周期注解, 方法是拿不到注解对象的.
    @Test(name = "hello", age = 20)
    public static void method() {
        System.out.println("hello");
    }

}
