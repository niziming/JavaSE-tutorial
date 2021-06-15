package atguigu.chap12generic.generic;

/**
 * 泛型擦除
 *  * 类似于Object,不等于Object
 */
public class Demo03 {


    public static void main(String[] args) {
        Student student = new Student();
        test(student);
        // Student<Object> student1 = new Student<Object>();
        // test(student1);  // 编译异常
    }

    private static void test(Student<Integer> student) {
        student.setJavase(100);
        System.out.println("student = " + student);
    }
}
