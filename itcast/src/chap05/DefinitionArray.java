package chap05;

import itcast.chap07.Student;

import java.util.ArrayList;

public class DefinitionArray implements Cloneable {
    public static void main(String[] args) {
        // 数组存储的数据类型[] 数组名字 = new 数组存储的数据类型[长度];
        // int[] arr = new int[10];
        // int[] arr1 = new int[]{1, 2, 3};
        // int[] arr2 = {1, 2, 3};
        // ergodic(arr);
        // ergodic(arr1);
        // ergodic(arr2);
        // arr[0] = 6;
        // ergodic(arr);
        // // arr = 10;
        // arr = null;
        // System.out.println(arr);
        // int[] arr3 = { 5, 15, 2000, 10000, 100, 4000};
        // int max = ArrayOperation.findMax(arr3);
        // System.out.println(max);

        // 找出最大
        // int[] ints = randomArray(10, 100);
        // ergodic(ints);
        // int max = ArrayOperation.findMax(ints);
        // System.out.println(max);

        // 数组的反转
        int[] ints = randomArray(10, 100);
        ergodic(ints);
        int[] rev = ArrayOperation.reverse(ints);
        ergodic(rev);
    }

    private static int[] randomArray(int len, int actor) {
        int[] arr4 = new int[len];
        for (int i = 0; i < arr4.length; i++) {
            arr4[i] = (int)(Math.random()*actor);
        }
        return arr4;
    }

    private static void ergodic(int[] arr) {
        for (int i : arr) {
            System.out.printf("%3d", i);
        }
        System.out.println();
    }
    private static void ergodic(byte[] arr) {
        for (int i : arr) {
            System.out.printf("%3d", i);
        }
        System.out.println();
    }

    public static void ergodic(Object[] arr) {
        for (Object i : arr) {
            if (i.getClass() == Student.class) System.out.println(i.toString());
            else System.out.printf("%3d", i);

        }
        System.out.println();
    }

}
