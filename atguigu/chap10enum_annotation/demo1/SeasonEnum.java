package atguigu.chap10enum_annotation.demo1;

import java.util.Arrays;
// 使用enum定义枚举类
public enum SeasonEnum {
    SPRING("春天","春风又绿江南岸"),
    SUMMER("夏天","映日荷花别样红"),
    AUTUMN("秋天","秋水共长天一色"),
    WINTER("冬天","窗含西岭千秋雪");

    private final String seasonName;
    private final String seasonDesc;
    private SeasonEnum (String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }
    public String getSeasonName() {
        return seasonName;
    }
    public String getSeasonDesc() {
        return seasonDesc;
    }

    @Override
    public String toString() {
        return "SeasonEnum{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }

    public static void main(String[] args) {
        SeasonEnum summer = SeasonEnum.SUMMER;
        System.out.println(summer.getSeasonName());
        System.out.println(SUMMER.getSeasonDesc());
        SeasonEnum spring = SeasonEnum.valueOf("SPRING");
        System.out.println(spring.getSeasonName());
        System.out.println(spring.getSeasonDesc());
        SeasonEnum[] values = SeasonEnum.values();
        System.out.println(Arrays.toString(values));
    }
}
