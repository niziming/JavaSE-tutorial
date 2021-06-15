package atguigu.chap12generic.generic;

import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 非泛型类中定义泛型方法
 */
public class Method {
    public static void main(String[] args) throws FileNotFoundException {
        test("java是门好远");
        test2(new ArrayList());
        test3(new FileInputStream("a.txt"));
    }

    private static<T extends Closeable> void test3(T ...t) {
        for (T t1 : t) {
            if (null != t1) {
                try {
                    t1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    /**
     * T止咳是list或者list的子类
     * @param t
     * @param <T>
     */
    private static<T extends List> void test2(T t) {
        t.add("aa");
        System.out.println("t = " + t);
    }

    /**
     *泛型方法，在返回类型前面使用泛型字母
     * @param t
     * @param <T>
     */
    private static <T> void test(T t) {
        System.out.println("t = " + t);
    }

}
