package chap27reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Arrays;

public class Student {
    private String name;
    private int age;

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static void main(String[] args) {
        Student student = new Student();
        Class aClass = student.getClass();
        Class[] interfaces = aClass.getInterfaces();
        System.out.println(Arrays.toString(interfaces));
        Constructor[] constructor = aClass.getConstructors();
        System.out.println(Arrays.toString(constructor));
        Field[] declaredFields = aClass.getDeclaredFields();
        System.out.println(Arrays.toString(declaredFields));
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
