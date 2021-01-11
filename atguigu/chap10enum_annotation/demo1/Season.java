package atguigu.chap10enum_annotation.demo1;

//自定义枚举类
public class Season {
    private final String SEASONNAME;
    private final String SEASONDESC;
    private Season (String seasonName, String seasonDesc) {
        this.SEASONNAME = seasonName;
        this.SEASONDESC = seasonDesc;
    }

    public static final Season SPRING = new Season("春天", "春暖花开");
    public static final Season SUMMER = new Season("夏天", "夏日炎炎");
    public static final Season AUTUMN = new Season("秋天", "秋高气爽");
    public static final Season WINTER = new Season("冬天", "白雪皑皑");

    public static void main(String[] args) {
        Season spring = Season.SPRING;
    }
}
