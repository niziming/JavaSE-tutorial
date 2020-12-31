package itcast.chap14.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;

public class Student implements Comparable<Student>{
    String name;
    int age;

    public Student(String name, int age) {
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
        Student student = (Student) obj;
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

    @Override
    public int compareTo(Student o) {
        return this.age - o.age; // 升序
    }

    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList();
        list.add(new Student("rose", 18));
        list.add(new Student("jack", 16));
        list.add(new Student("abc", 16));
        list.add(new Student("ace", 17));
        list.add(new Student("mark", 16));

        // 当我们调用Collections.sort()方法的时候 程序报错了
        // 实现集合接口 后可以调用了
        Collections.sort(list);

        for (Student s : list) {
            System.out.println(s);
        }
        System.out.println(list);
    }

}
