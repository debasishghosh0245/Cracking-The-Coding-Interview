package Basic;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = { 10,6,8,9,2,3 };
        bubbleSortRecursive(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

    }

    public static void bubbleSort(int[] arr) {
        boolean swapped = false;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j] < arr[j - 1]) {
                    swapped = true;
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
                if (swapped == false) {
                    break;
                }
            }
        }
    }

    public static void bubbleSortRecursive(int[] arr, int j, int i) {
        if (i == 0)
            return;
        if (i > j) {
            if (arr[j] > arr[j + 1]) {
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
            bubbleSortRecursive(arr, j + 1, i);
        }else{
            bubbleSortRecursive(arr, 0, i - 1);
        }
    }
}
