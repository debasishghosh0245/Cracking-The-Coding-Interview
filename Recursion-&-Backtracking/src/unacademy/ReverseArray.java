package unacademy;

public class ReverseArray {
    public static void main(String[] args) {
        int[] arr = { 5, 2, 3, 4, 1, 6,9,10 };
        int[] rArr = reverseArray(arr, 0);
        for (int i : rArr) {
            System.out.println(i);
        }
    }

    public static int[] reverseArray(int[] arr, int index) {
        int length = arr.length;
        if(index>length/2) return arr;
        swapNumber(arr,index);
        reverseArray(arr, index+1);
        return arr;
    }

    public static void swapNumber(int[] arr, int index) {
        int length = arr.length;
        int temp = arr[index];
        arr[index] = arr[length-index-1];
        arr[length-index-1] = temp;
    }
}
