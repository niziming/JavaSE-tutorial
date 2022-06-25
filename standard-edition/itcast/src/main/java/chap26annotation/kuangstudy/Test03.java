package chap26annotation.kuangstudy;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class Test03 {
    public static void main(String[] args) {
        test();
        test1();
    }

    @MyAnno1
    private static void test1() {
    }

    @MyAnno(age = 188)
    private static void test() {
    }
}

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnno{
    String name() default "";
    int age() default 0;
    int id() default -1;

    String[] school() default {"西科大"};
}

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnno1{
    String value() default "";
}

