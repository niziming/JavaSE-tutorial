package chap03;

public class Main {
    public static void main(String[] args) {
        // 顺序结构
        // 顺序执行，根据编写的顺序，从上到下运行
        System.out.println(1);
        System.out.println(2);
        System.out.println(3);

        // 判断语句
        if (true) {
            System.out.println("if执行");
        }

        // 判断语句2--if...else
        if (false) {
            System.out.println("不执行");
        }else {
            System.out.println("执行");
        }

        // 判断语句3--if..else if...else
        if (false) {

        } else if (false) {

        } else if (false) {

        }else {
            System.out.println("判断语句3--if..else if...else");
        }
        // switch ()
        int[] week = new int[7];
        for (int i = 0; i < week.length; i++) {
            switch (i) {
                case 1:
                    System.out.println("周一");
                    break;
                case 2:
                    System.out.println("周二");
                    break;
                case 3:
                    System.out.println("周三");
                    break;
                default:
                    System.out.println("其他");
                    break;
            }
        }

        // 循环语句1--for
        for (int i = 0; i < 10; i++) {
            System.out.print(i);
        }

        // 循环语句2--while
        int time = 10;
        while (time > 0) {
            System.out.println("循环");
            time--;
        }

        // 100 累加
        int i = count1(100);
        System.out.println(i);


        // 嵌套循环 9*9
        for (int j = 1; j < 10; j++) {
            for (int k = 1; k <= j; k++) {
                System.out.print(j*k);
            }
            System.out.println();
        }
    }

    public static int count1(int max) {
        return max > 1 ? max += count1(max - 1) : max;
    }

    public static String main11() {
        if (true) {
            return "1";
        }
        return "1";
    }
}
