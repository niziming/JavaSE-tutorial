package chap26annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(value = ElementType.METHOD)
public @interface MyTarget {
}
