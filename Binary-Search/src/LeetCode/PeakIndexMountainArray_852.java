package LeetCode;

// https://leetcode.com/problems/peak-index-in-a-mountain-array/

public class PeakIndexMountainArray_852 {
    public static void main(String[] args) {
        int[] arr={24,69,100,99,79,78,67,36,26,19};
        int peek=peakIndexInMountainArray(arr);
        System.out.println("Peek "+peek);
    }
    

    public static int peakIndexInMountainArray(int[] arr) {
        int left=0;
        int right=arr.length-1;
        while(left!=right) {
            int mid=left+(right-left)/2;
            if(arr[mid]>arr[mid+1])  right=mid;
            if(arr[mid] < arr[mid+1])  left=mid+1;
        }
      return left;   
    }
}
