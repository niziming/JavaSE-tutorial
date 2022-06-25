package chap14.set;

import java.util.HashSet;
import java.util.Objects;

public class Student {
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

    public static void main(String[] args) {
        Student student = new Student("ziming", 25);
        Student student1 = new Student("郭德纲", 44);
        Student student2 = new Student("ziming", 25);
        HashSet hashSet = new HashSet();
        hashSet.add(student);
        hashSet.add(student1);
        hashSet.add(student2);

        System.out.println(hashSet);
        System.out.println(Objects.hash(student));
        System.out.println(Objects.hashCode(student));
    }
}
