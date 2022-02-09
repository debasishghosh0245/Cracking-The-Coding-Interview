package Leetcode;

import java.util.Arrays;

public class FindDuplicateNumber_287 {
    public static void main(String[] args) {
       int[] nums = {1,3,4,2,2};
       int duplicateNumber=findDuplicate(nums);
       System.out.println(duplicateNumber);
    }
    public static int findDuplicate(int[] nums) {
        cyclicSort(nums);
        System.out.println(Arrays.toString(nums));
        for(int i=0;i<nums.length;i++){
            if(nums[i]-1!=i){
                return nums[i];
            }
        }
        return 0;
    }

    public static void cyclicSort(int[] arr) {
        int i=0;
        while(i<arr.length){
            int correctIndex=arr[i]-1;
            if(arr[i]!=arr[correctIndex]) {
                int temp=arr[i];
                arr[i]=arr[correctIndex];
                arr[correctIndex]=temp;
            }else{
                i++;
            }
        }
        
    }
}
