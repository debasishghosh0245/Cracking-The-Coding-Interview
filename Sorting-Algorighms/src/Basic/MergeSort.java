package Basic;

import java.util.*;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = { 5, 3, 4, 1, 2 };
        mergeSort(arr,0,arr.length);
       // System.out.println(Arrays.toString(arr));
    }

    public static int[] mergeSort(int[] arr) {
        if (arr.length == 1)
            return arr;
        int mid = arr.length / 2;
        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));
        return merge(left, right);
    }

    private static int[] merge(int[] first, int[] second) {
        int[] mergedArr = new int[first.length + second.length];
        int leftIndex = 0;
        int rightIndex = 0;
        int mergedArrIndex = 0;
        while (leftIndex < first.length && rightIndex < second.length) {
            if (first[leftIndex] > second[rightIndex]) {
                mergedArr[mergedArrIndex] = second[rightIndex];
                rightIndex++;
            } else {
                mergedArr[mergedArrIndex] = first[leftIndex];
                leftIndex++;
            }
            mergedArrIndex++;
        }
        while (leftIndex < first.length) {
            mergedArr[mergedArrIndex] = first[leftIndex];
            leftIndex++;
            mergedArrIndex++;
        }
        while (rightIndex < second.length) {
            mergedArr[mergedArrIndex] = second[rightIndex];
            rightIndex++;
            mergedArrIndex++;
        }
        return mergedArr;
    }

    public static void mergeSort(int[] arr, int left, int right) {
        if (right-left <= 1)
            return;
        int mid = (left + right) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid, right);
        merge(left,right,arr);
    }


    private static void merge(int left, int right,int[] arr) {
       for(int i=left;i<right;i++) {
           System.out.println(arr[i]);
       }
       System.out.println(" ");

    }

}
