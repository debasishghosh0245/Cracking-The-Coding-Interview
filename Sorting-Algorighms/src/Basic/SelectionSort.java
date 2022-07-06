package Basic;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = { 10, 9, 8, 7, 6, 1, 3, 0 };
        selectionSort(arr,arr.length-1,0,arr[0],0);
        System.out.println(Arrays.toString(arr));
    }

    public static void selectionSort(int[] arr) {
         for (int j = 0; j < arr.length; j++) {
            int max = arr[0];
            int maxIndex = 0;
            for (int i = 0; i < arr.length - j; i++) {
                if (arr[i] > max) {
                    max = arr[i];
                    maxIndex = i;
                }
            }
            int temp = arr[arr.length - 1 - j];
            arr[arr.length - 1 - j] = arr[maxIndex];
            arr[maxIndex] = temp;
        }
    }

    public static void selectionSort(int[] arr,int i,int j,int max,int maxIndex) {
        if(i==0) return;
        if(j<i) {
            if (arr[j] > max) {
                max = arr[j];
                maxIndex = j;
            }
            int temp = arr[i];
            arr[i] = arr[maxIndex];
            arr[maxIndex] = temp;
            selectionSort(arr,i,j+1,max,maxIndex);
        }
        selectionSort(arr,i-1,0,arr[0],0);
    }
}
