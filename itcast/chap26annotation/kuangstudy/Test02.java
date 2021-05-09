package itcast.chap26annotation.kuangstudy;

import java.lang.annotation.*;

@MyAnnotation
public class Test02 {
    @MyAnnotation
    public void test () {

    }

    public static void main(String[] args) {

    }

}


@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited // 子类可继承父类注解
@interface MyAnnotation {
}