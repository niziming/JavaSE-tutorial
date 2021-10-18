package chap14;

import java.util.HashSet;

public class HashSetDemo1 {
    public static void main(String[] args) {
        HashSet<Student> hs = new HashSet<>();
        Student stu = new Student("于谦", 43);
        hs.add(stu);
        hs.add(new Student("郭德纲", 44));
        hs.add(new Student("于谦", 43));
        hs.add(new Student("过去了", 23));
        for (Student s : hs) {
            System.out.println(s);
        }
    }
}
