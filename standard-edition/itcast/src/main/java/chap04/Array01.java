package chap04;

public class Array01 {
    // public ArrayList arr = new ArrayList<Integer>(10);
    // public static int [] nums = new int[10];
    // int[] arr2 = {1,2,3,4,5};
    // int a = 5;
    // public static void Main(String[] args) {
    //     int num = nums[0];
    //     System.out.println(num);
    // }
    public static void main(String[] args) {
        int[] arr2 = {1,2,3,4,5};
        System.out.println(arr2[0]);
        change(arr2);
        System.out.println(arr2[0]);
    }

    /**
     *
     * @param arr
     */
    public static void change (int[] arr) {
        arr[0] = 200;
    }
}
