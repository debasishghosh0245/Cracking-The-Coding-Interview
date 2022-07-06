import java.util.*;

public class SortArray {

    public static void main(String[] args) {
        int[] arr = {10, 2, 5, 3, 20};
        sort(arr, 0);
        System.out.println(Arrays.toString(arr));
    }

    public static int[] sort(int[] arr, int idx) {
        int[] output = Arrays.copyOfRange(arr, 1, arr.length);
        System.out.println(Arrays.toString(output));
        return null;
    }
}