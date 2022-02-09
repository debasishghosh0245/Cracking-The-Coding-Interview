package Basic;

import java.util.*;

public class QuickSort {
    public static void main(String[] args) {
        // int[] arr = { 5, 4, 3, 2, 1 };
        int[] arr = {50, 25,92,16,76,30,43,54,19};
        int leftIndex = 0;
        int rightIndex = arr.length - 1;
        sort(arr, leftIndex, rightIndex);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr, int leftIndex, int rightIndex) {
        int pivotIndex = 0;
        if (rightIndex > leftIndex) {
            pivotIndex = partition(arr, leftIndex, rightIndex);
            sort(arr, leftIndex, pivotIndex - 1);
            sort(arr, pivotIndex + 1, rightIndex);
        }
    }

    public static int partition(int[] arr, int leftIndex, int rightIndex) {
        int pivotIndex = leftIndex;
        while (rightIndex > leftIndex) {
            while (arr[pivotIndex] >= arr[leftIndex] && leftIndex < arr.length - 1) {
                leftIndex++;
            }
            while (arr[pivotIndex] < arr[rightIndex]) {
                rightIndex--;
            }
            if (rightIndex > leftIndex) {
                swap(leftIndex, rightIndex, arr);
            }
        }
        swap(pivotIndex, rightIndex, arr);
        return rightIndex;
    }

    public static void swap(int a, int b, int[] arr) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}
