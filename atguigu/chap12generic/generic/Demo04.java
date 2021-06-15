package atguigu.chap12generic.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * 通配符
 * 通配符（Wildcards）
 *
 * T、K、V、E 等泛型字母为有类型，类型参数赋予具体的值
 * ？未知类型 类型参数赋予不确定值，任意类型
 * 只能用在声明类型、方法参数上，不能用在定义泛型类上
 */
public class Demo04 {
    public static void main(String[] args) {
        test(new ArrayList<String>());
        test(new ArrayList<Integer>());
    }

    private static void test(List<?> list) {
        List<?> list2; // 声明变量
        list2 = new ArrayList<String>();
        list2 = new ArrayList<Integer>();
        list2 = new ArrayList<Object>();
    }
}
