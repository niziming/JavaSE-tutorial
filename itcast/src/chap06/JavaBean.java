package chap06;

// JavaBean 是 Java语言编写类的一种标准规范。符合 JavaBean 的类，要求类必须是具体的和公共的，并且具有无
// 参数的构造方法，提供用来操作成员变量的 set 和 get 方法。
public class JavaBean {
    //成员变量
    private String name;
    private int age;
    //构造方法
    //无参构造方法【必须】
    public JavaBean(){}
    //有参构造方法【建议】
    public JavaBean(String name, int age){
        this.name = name;
        this.age = age;
    }
    //成员方法   
    //getXxx()
    //setXxx()

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

    // 测试用
    @Override
    public String toString() {
        return "JavaBean{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
