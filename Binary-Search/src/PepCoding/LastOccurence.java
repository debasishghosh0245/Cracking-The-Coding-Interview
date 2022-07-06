package Fundamentals;

public class LastOccurence {
    public static void main(String[] args) {
        int[] arr= { 1, 2, 5, 5, 5, 10, 10 };
        int key = 5;
        int index= searchLastOccurence(arr, key,0,arr.length-1);
        System.out.println("Last Occurence >> "+index);
    }
    public static int searchLastOccurence(int[] nums, int key,int left,int right) {
        if(nums == null || nums.length == 0)  return -1;
        if(left>=right) return left;
        int mid=(left+(right-left)/2);
        if(nums[mid]==key)  return searchLastOccurence(nums, key, mid+1, right);
        return key>nums[mid] ? searchLastOccurence(nums,key,mid+1,right):searchLastOccurence(nums,key,left,mid-1);
    }
}
