package itcast.chap09.demo2;

/*
 * 定义测试类
 */
public class TeacherTest {
    public static void main(String[] args) {
        Teacher teacher = new Teacher();
        teacher.printName();

        teacher.name = "ziming";

        teacher.printName();

        teacher.work();
    }
}
