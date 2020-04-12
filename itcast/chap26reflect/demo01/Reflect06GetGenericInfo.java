package itcast.chap26reflect.demo01;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 通过反射获取泛型信息
 */
public class Reflect06GetGenericInfo {
    public static void main(String[] args) throws NoSuchMethodException {
        // 获取到返回类型
        Method m1 = Reflect06GetGenericInfo.class.getDeclaredMethod("getGenericInfo");
        Method m2 = Reflect06GetGenericInfo.class.getDeclaredMethod("twoGenericParamsMethod", Map.class, List.class);
        Type genericReturnType = m1.getGenericReturnType();
        Type[] genericParameterTypes = m2.getGenericParameterTypes();
        System.out.println(genericReturnType);
        System.out.println(Arrays.toString(genericParameterTypes));
    }
    /**
     *
     * @return
     */
    private static ArrayList<?> getGenericInfo() {
        System.out.println("返回值为map泛型");
        return null;
    }

    /**
     * 带有两个泛型参数的方法
     * @param map
     * @param list
     */
    public static void twoGenericParamsMethod(Map<String, String> map, List<Integer> list) {
        System.out.println(map);
        System.out.println(list);
    }
}
