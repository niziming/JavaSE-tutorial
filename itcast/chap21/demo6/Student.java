package itcast.chap21.demo6;

import java.io.*;
import java.util.ArrayList;

// ObjectOutputStream类 将Java对象的原始数据类型写出到文件,实现对象的持久存储
// 序列化操作

public class Student implements Serializable {

    // Serializable 接口给需要序列化的类，提供了一个序列版本号。 serialVersionUID 该版本号的目的在于验证序
    // 列化的对象和对应类是否版本匹配。

    // 加入序列版本号
    private static final long serialVersionUID = 1L;
    // 添加新的属性 ,重新编译, 可以反序列化,该属性赋为默认值.
    public int eid;

    String name;
    String address;
    transient int age; // 瞬态

    public Student(String name, String address, int age) {
        this.name = name;
        this.address = address;
        this.age = age;
    }

    public void addressCheck() {
        System.out.println("地址: " + address + ", 姓名: " + name);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) throws IOException {
        Student student = new Student("ziming", "dongda rode", 25);
        // 序列化
        try (
                FileOutputStream fos = new FileOutputStream("itcast/chap21/demo6/student.txt");
                ObjectOutputStream oos = new ObjectOutputStream(fos);
        ) {
            oos.writeObject(student);
            System.out.println("序列化student完成");
        } catch (Exception e) {
            e.printStackTrace();
        }


        // 反序列化
        try (
                FileInputStream fis = new FileInputStream("itcast/chap21/demo6/student.txt");
                ObjectInputStream ois = new ObjectInputStream(fis);
        ) {
            Student stu = (Student) ois.readObject();
            stu.addressCheck();
            System.out.println(stu.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

        Student student1 = new Student("老王", "laow", 20);
        Student student2 = new Student("老张", "laoz", 20);
        Student student3 = new Student("老李", "laol", 20);
        ArrayList list = new ArrayList();
        list.add(student1);
        list.add(student2);
        list.add(student3);
        serializ(list);
        unserializ();
    }
    public static void serializ(ArrayList list) {
        try (
                FileOutputStream fos = new FileOutputStream("itcast/chap21/demo6/student-list.txt");
                ObjectOutputStream oos = new ObjectOutputStream(fos);
        ) {
            oos.writeObject(list);
            System.out.println("序列化student-list完成");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void unserializ() {
        try (
                FileInputStream fis = new FileInputStream("itcast/chap21/demo6/student-list.txt");
                ObjectInputStream ois = new ObjectInputStream(fis);
        ) {
            ArrayList<Student> list = (ArrayList<Student>) ois.readObject();
            for (Student s : list) {
                s.addressCheck();
            }
            System.out.println("反序列化完成");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
