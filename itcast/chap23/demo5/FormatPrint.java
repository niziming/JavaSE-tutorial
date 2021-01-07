package itcast.chap23.demo5;

import java.util.function.Consumer;

public class FormatPrint {
    public static <E> void printInfo(E e, Consumer... c) {
        switch (c.length) {
            case 1:
                c[0].accept(e);
                break;
            case 2:
                c[0].andThen(c[1]).accept(e);
                break;
            default:
                System.out.println("参数不符合要求");
                break;
        }
    }
    public static void main(String[] args) {
        String[] array = { "迪丽热巴,女", "古力娜扎,女", "马尔扎哈,男" };
        printInfo(
                array,
                c1 -> {
                    System.out.printf("姓名: %1$-10s, 性别: %2$-5s %n", array[0].split(",")[0], array[0].split(",")[1]);
                },
                c2 -> {
                    System.out.printf("姓名: %1$-10s, 性别: %2$-5s %n", array[1].split(",")[1], array[0].split(",")[1]);
                }
                );
    }
}
