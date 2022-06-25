package l.尚硅谷_宋红康_第10章_枚举类与注解.demo1;
// 当需要定义一组常量时，强烈建议使用枚举类
public enum week {
    SUNDAY,
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY;
    week (int i, String day) {}
    week() {}
    static week getWeekDayByValue (int i) {
        week[] values = week.values();
        for (week value : values) {
            if (value.ordinal() == i) {
                return value;
            }
        }
        return null;
    }
    public static void main(String[] args) {
        week weekDayByValue = week.getWeekDayByValue(0);
        week weekDayByValue1 = week.getWeekDayByValue(1);
        System.out.println(weekDayByValue.toString());
        System.out.println(weekDayByValue);
        System.out.println(weekDayByValue1.toString());
    }
}
