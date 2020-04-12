package itcast.day08;

public class KeyWords {
    int id;
    static String name = "zhang";

    public static int numberOfStudent = 0;
    public KeyWords() {
        this.id = ++numberOfStudent;
    }
    public static void showNum () {
        System.out.println("num" + numberOfStudent);
    }
    @Override
    public String toString() {
        return "KeyWords{" +
                "id=" + id +
                '}';
    }
}
