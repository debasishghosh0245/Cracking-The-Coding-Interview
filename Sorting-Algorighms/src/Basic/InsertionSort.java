package Basic;

import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = { 5, 4, 3, 1, 2, 0,-1918 };
        insertionSortRecursion(arr, 0, 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void insertionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                } else {
                    break;
                }
            }
        }
    }

    public static void insertionSortRecursion(int[] arr, int i, int j) {
        if (i == arr.length - 1)  return;
        if (j > 0) {
            if (arr[j] < arr[j - 1]) {
                int temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
            }
            insertionSortRecursion(arr, i, j - 1);
        } else {
            insertionSortRecursion(arr, i + 1, i + 2);
        }
    }

}
