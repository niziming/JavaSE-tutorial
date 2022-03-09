package chap26annotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class RoleTest {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // String string = doString();
        // System.out.println(string);
        Method roleTest = RoleTest.class.getDeclaredMethod("doString");
        Role annotation = roleTest.getAnnotation(Role.class);
        Method[] declaredMethods = annotation.annotationType().getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            Object invoke = declaredMethod.invoke(annotation);
            System.out.println(invoke);
        }
        System.out.println(roleTest);
        System.out.println(annotation);
    }

    @Role(roleName = "role1")
    @Role(roleName = "role2")
    public String doString(){
        return "hello";
    }
}
