package itcast.chap26reflect;

import java.lang.reflect.Field;

public class FieldsDemo01 {
    public static void main(String[] args) {
        method();
    }

    public static void method() {
        Book b = new Book();
        Class aClass = b.getClass();
        System.out.println("book" + b);
        try {
            // 获取到一个成员变量对象
            Field field = aClass.getDeclaredField("price");
            System.out.println("成员名称为: " + field.getName());
            System.out.println("成员类型为: " + field.getType());
            // 如果成员变量的访问权限为private,则抛异常
            System.out.println("修改前成员的值为: " + field.get(b));
            System.out.println("判断成员类型是否为int: " + field.getType().equals(int.class));
            field.setInt(b, 100);
            System.out.println("修改后成员的值为: " + field.get(b));
            System.out.println(b);
            System.out.println("判断成员类型是否为float: " + field.getType().equals(float.class));
            // 报错,类型不匹配
            // field.setFloat(b, 19.815f);
            System.out.println("判断成员类型是否为float: " + field.getType().equals(float.class));

        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}
