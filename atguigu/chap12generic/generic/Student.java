package atguigu.chap12generic.generic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 使用泛型
 * @param <T>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student<T> {
    private T javase;

    public static void main(String[] args) {
        Student<Integer> student = new Student<>();
        student.setJavase(85);
        System.out.println("student = " + student);
    }
}
