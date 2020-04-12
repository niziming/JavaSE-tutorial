package itcast.day25;

public enum ColorToString {
    RED("红色",1),GREEN("绿色",2),WHITE("白色",3),YELLOW("黄色",4);

    private String name;
    private int index;

    private ColorToString (String name, int index) {
        this.name = name;
        this.index = index;
    }

    @Override
    public String toString() {
        return "ColorToString{" +
                "name='" + name + '\'' +
                ", index=" + index +
                '}';
    }

    public static void main(String[] args) {
        ColorToString red = ColorToString.RED;
        System.out.println(red);
        System.out.println(red.index + red.name);
    }
}
