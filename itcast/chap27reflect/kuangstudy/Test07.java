package itcast.chap27reflect.kuangstudy;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test07 {
    public static void main(String[] args) {
        try {
            Method test = Test07.class.getDeclaredMethod("test", Map.class);
            System.out.println("test = " + test);
            Type[] genericParameterTypes = test.getGenericParameterTypes();
            List<String> collect = Arrays.stream(genericParameterTypes).map(g -> g.getTypeName()).collect(Collectors.toList());
            System.out.print(collect);
            System.out.println("test = " + test);
            Type genericParameterTypes1 = test.getGenericReturnType();
            System.out.print(genericParameterTypes1);

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }

    private Map<String, Object> test(Map<String, Object> t) {
        return null;
    }
}
