package itcast.chap27annotation;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface MyInherited {
}
