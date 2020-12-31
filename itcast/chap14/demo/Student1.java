package itcast.chap14.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;

public class Student1{
    private String name;
    private int age;

    public Student1(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Student1 student = (Student1) obj;
        return age == student.age &&
               Objects.equals(name, student.name);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) {
        ArrayList<Student1> list = new ArrayList();
        list.add(new Student1("rose", 18));
        list.add(new Student1("jack", 16));
        list.add(new Student1("abc", 16));
        list.add(new Student1("ace", 17));
        list.add(new Student1("mark", 16));

        // 当我们调用Collections.sort()方法的时候 程序报错了
        // 实现集合接口 后可以调用了
        Collections.sort(list, new Comparator<Student1>() {
            // 年龄升序
            // @Override
            // public int compare(Student1 o1, Student1 o2) {
            //     return o1.getAge() - o2.getAge();
            // }
            // 年龄降序
            // @Override
            // public int compare(Student1 o1, Student1 o2) {
            //     return o2.getAge() - o1.getAge();
            // }
            // 姓名首字母降序
            @Override
            public int compare(Student1 o1, Student1 o2) {
                return o2.getName().charAt(0) - o1.getName().charAt(0);
            }
        });

        for (Student1 s : list) {
            System.out.println(s);
        }
    }

}
