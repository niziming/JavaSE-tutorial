package itcast.chap26reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class ConstructorDemo01 {
    public static void main(String[] args) {
        Student student = new Student("ziming", 25);
        try {
            // 第一种实现方式
            Constructor con = student.getClass().getConstructor(String.class, int.class);
            // 第二种
            student.getClass().getDeclaredConstructor(new Class[]{String.class, int.class});
            System.out.println(con);
            // 创建的Constructor对象表示一个构造方法, 然后利用Constructor对象的方法操作构造方法.
            System.out.println("是否允许带可变数量的参数: " + con.isVarArgs());
            System.out.println("按声明顺序返回一个class数组获取各个参数的类型: " + Arrays.toString(con.getParameterTypes()));
            Student s = (Student) con.newInstance("ziming", 20);
            System.out.println(s);
            System.out.println(s.equals(con));
            // 获取构造方法的修饰符整数
            int modifiers = con.getModifiers();
            System.out.println(modifiers);
            System.out.println("是否使用static修饰: " + Modifier.isStatic(con.getModifiers()));
            System.out.println("是否使用publci修饰: " + Modifier.isPublic(con.getModifiers()));
            System.out.println("以字符串返回所有修饰符: " + Modifier.toString(con.getModifiers()));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public static void method() {

    }

}
