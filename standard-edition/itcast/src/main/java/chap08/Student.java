package chap08;

public class Student {
    String name;
    int age;
    // 学生ID
    private int sid;

    // 类变量
    // 当 static 修饰成员变量时，该变量称为类变量。该类的每个对象都共享同一个类变量的值。任何对象都可以更改
    // 该类变量的值，但也可以在不创建该类的对象的情况下对类变量进行操作。
    public static int numberOfStudent = 0;

    // 静态代码块 ：定义在成员位置，使用static修饰的代码块{ }。
    // 位置：类中方法外。
    // 执行：随着类的加载而执行且执行一次，优先于 main方法和构造方法的执行。
    // 作用：给类变量进行初始化赋值
    // 格式：
    static {
        // 执行语句
        System.out.println("hello");
        // 其主要目的还是想在不创建对象的情况下，去调用方法。
        numberOfStudent = 10;
    }

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
        // 通过 numberOfStudent 给学生分配学号
        this.sid = ++numberOfStudent;
    }

    // 静态方法
    // 当 static 修饰成员方法时，该方法称为类方法 。静态方法在声明中有 static ，建议使用类名来调用，而不需要
    // 创建类的对象。调用方式非常简单。
    public static void showStus() {
        System.out.println(numberOfStudent);
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
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", name='" + name +
                ", age=" + age +
                '}';
    }
}
