package chap26annotation.kuangstudy;

import java.lang.annotation.*;
import java.lang.reflect.Field;

public class ReflectGetAnnotation {
    public static void main(String[] args) {
        try {
            Class<?> aClass = Class.forName("chap26annotation.kuangstudy.Person");
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
class Person{
    @Param(column = "id", type = Integer.class, len = 10)
    Integer id;
    @Param(column = "age", type = Integer.class, len = 10)
    Integer age;
    @Param(column = "name", type = String.class, len = 10)
    String name;

    public Person(Integer id, Integer age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public Person() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
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
