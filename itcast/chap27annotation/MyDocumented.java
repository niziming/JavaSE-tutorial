package itcast.chap27annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Documented
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface MyDocumented {
    public String value() default "这是@Documented注解";
}
