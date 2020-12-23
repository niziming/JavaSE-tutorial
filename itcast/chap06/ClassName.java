package itcast.chap06;

public class ClassName {
    // 成员变量
    String name;
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // 成员方法
    protected void study() {
        System.out.println(name + "好好学习, 天天向上");
    }

    public void eat() {
        System.out.println(name + "饿了要吃饭");
    }

    @Override
    public String toString() {
        return "ClassName{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
