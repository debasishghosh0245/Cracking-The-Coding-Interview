package Fundamentals;

public class CeilingOfANumber {
    public static void main(String[] args) {
        int[] arr={2,3,5,9,14,16,18};
        int index=celingOfANumber(arr,15,0,arr.length-1);
        System.out.println(arr[index]);
    }
    public static int celingOfANumber(int[] arr,int target,int left, int right) {
        if(left>right) return left;
        int mid=(right+(left-right)/2);
        if(arr[mid]==target) return mid;
        return target>arr[mid] ? celingOfANumber(arr, target, mid+1, right): celingOfANumber(arr, target, left, mid-1);
    }
}
