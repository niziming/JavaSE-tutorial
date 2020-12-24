package itcast.chap08;

import java.util.ArrayList;


public class StudentTest {
    public static void main(String[] args) {
        Student student = new Student("ziming", 12);
        Student student1 = new Student("tao", 12);
        Student student2 = new Student("cao", 12);
        ArrayList stus = new ArrayList();
        stus.add(student);
        stus.add(student1);
        stus.add(student2);
        System.out.println(stus);
        Student.showStus();
        System.out.println(Student.numberOfStudent);
        System.out.println(student.numberOfStudent);
    }
}
