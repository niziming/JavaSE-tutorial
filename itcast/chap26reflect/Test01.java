package itcast.chap26reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class Test01 {
    public static void main(String[] args) {
        Class<Book> book = Book.class;
        Constructor<?>[] cons = book.getDeclaredConstructors();
        for (Constructor<?> con : cons) {
            System.out.print("查看是否允许带可变参数" + con.isVarArgs());
            Class<?>[] parameterTypes = con.getParameterTypes();
            for (Class<?> parameterType : parameterTypes) {
                System.out.print(" 获取所有参数的类型" + parameterType);
            }
            // 获取所有可能跑出的异常类型
            Class<?>[] exceptionTypes = con.getExceptionTypes();
            for (Class<?> exceptionType : exceptionTypes) {
                System.out.println("获取所有可能跑出的异常类型" + exceptionType);
            }
            // 创建一个未实例化
            Book book1 = null;
            while (con.isVarArgs() == true){
                try {
                System.out.println("\n-------" + con.isVarArgs() + Arrays.toString(con.getParameterTypes()));
                Object[] objects = {new String[]{"100", "200"}};
                Book book2 = (Book)con.newInstance(objects);
                book2.print();
                break;
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
        // 设置允许访问private成员
        try {
            Constructor<Book> con1 = book.getDeclaredConstructor(); // 获取无参构造类对象
            con1.setAccessible(true);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
