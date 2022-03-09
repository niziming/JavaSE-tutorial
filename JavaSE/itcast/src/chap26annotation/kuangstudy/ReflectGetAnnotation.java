package chap26annotation.kuangstudy;

import lombok.Data;

import java.lang.annotation.*;
import java.lang.reflect.Field;

public class ReflectGetAnnotation {
    public static void main(String[] args) {
        try {
            Class<?> aClass = Class.forName("itcast.chap26annotation.kuangstudy.Person");
            Table annotation = aClass.getAnnotation(Table.class);
            System.out.println("annotation.value() = " + annotation.value());

            Field name = aClass.getDeclaredField("name");
            System.out.println("name = " + name);
            Param param = name.getAnnotation(Param.class);
            System.out.println("param = " + param.column());
            System.out.println("param = " + param.len());
            System.out.println("param = " + param.type());


        } catch (ClassNotFoundException | NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}


@Table("person")
@Data
class Person{
    @Param(column = "id", type = Integer.class, len = 10)
    Integer id;
    @Param(column = "age", type = Integer.class, len = 10)
    Integer age;
    @Param(column = "name", type = String.class, len = 10)
    String name;
}

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@interface Table{
    String value() default "db";
}
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@interface Param{
    String column() default "Column";
    Class type() default String.class;
    int len() default 0;
}
