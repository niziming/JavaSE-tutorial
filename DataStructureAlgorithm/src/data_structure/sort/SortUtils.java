package data_structure.sort;

public class SortUtils {
  public static void bubbleSort(int[] arr) {
    int temp;
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr.length; j++) {
        if(arr[j] > arr[i]) {
          temp = arr[j];
          arr[j] = arr[i];
          arr[i] = temp;
        }
      }
    }
  }

  public static void main(String[] args) {
    int[] arr = {1, 3, 2, 4, 5, 10, 9};
    bubbleSort(arr);
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
  }
}
