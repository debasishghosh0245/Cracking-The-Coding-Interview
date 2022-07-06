package Basic;

import java.util.*;

public class CyclicSort {
    public static void main(String[] args) {
        int[] arr = { 5, 4, 3, 1, 2 };
        cycleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void cycleSort(int[] arr) {
        int i = 0;
        int arrValue = arr[i] - 1;
        while (arr[0] - 1 != i) {
            int temp = arr[0];
            arr[i] = arr[arrValue];
            arr[arrValue] = temp;
        }
    }

}
