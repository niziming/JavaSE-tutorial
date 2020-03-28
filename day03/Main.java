package day03;

public class Main {
    public static void main(String[] args) {
        int [] week = new int[7];
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
    }
}
