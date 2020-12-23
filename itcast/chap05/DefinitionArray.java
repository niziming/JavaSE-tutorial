package itcast.chap05;

public class DefinitionArray {
    public static void main(String[] args) {
        // 数组存储的数据类型[] 数组名字 = new 数组存储的数据类型[长度];
        int[] arr = new int[10];
        int[] arr1 = new int[]{1, 2, 3};
        int[] arr2 = {1, 2, 3};
        ergodic(arr);
        ergodic(arr1);
        ergodic(arr2);
        arr[0] = 6;
        ergodic(arr);
    }

    private static void ergodic(int[] arr) {
        for (int i : arr) {
            System.out.print(i);
        }
        System.out.println();
    }

}
