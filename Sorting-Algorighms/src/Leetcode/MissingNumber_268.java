package Leetcode;

import java.util.Arrays;

public class MissingNumber_268 {
    public static void main(String[] args) {
        int[] arr = { 9,0,1,4,5,6,7};
        // int[] arr={0,1};
        System.out.println(missingNumber(arr));
    }

    public static int missingNumber(int[] nums) {
        cyclicSort(nums);
        System.out.println(Arrays.toString(nums));
        for(int i=0;i<nums.length;i++){
            if(i!=nums[i]) {
                return i;
            }
        }
        return nums.length;
    }

    public static void cyclicSort(int[] arr) {
        int i=0;
        while(i<arr.length) {
            int correct=arr[i];
            if(arr[i] < arr.length && arr[i]!=arr[arr[i]]){
               int temp=arr[i];
               arr[i]=arr[correct];
               arr[correct]=temp;
            }else{
                i++;
            }
        }
    }

}
