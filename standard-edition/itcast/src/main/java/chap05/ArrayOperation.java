package chap05;

class ArrayOperation {
    static int findMax(int[] arr) {
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            max = arr[i] > max ? arr[i] : max;
        }
        return max;
    }
    static int[] reverse(int[] arr) {
        int[] arr1 = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arr1[arr1.length - i - 1] = arr[i];
        }
        return arr1;
    }
}
