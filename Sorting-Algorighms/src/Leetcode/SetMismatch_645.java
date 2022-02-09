package Leetcode;
import java.util.*;
public class SetMismatch_645 {

    public static void main(String[] args) {
        //int[] nums = { 2, 4, 2, 1 };
        int[] nums = {1,1};
        int[] list=findErrorNums(nums);
        System.out.println(Arrays.toString(list));
    }

    public static int[] findErrorNums(int[] nums) {
        int[] arr=new int[2];
        cyclicSort(nums);
        System.out.println(Arrays.toString(nums));
        for(int i=0;i<nums.length;i++) {
           if(i!=nums[i]-1){
               arr[1]=i+1;
               arr[0]=nums[i];
           }
        }
        return arr;
    }

    public static void cyclicSort(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int correctIndex = nums[i] - 1;
            if (nums[correctIndex] != nums[i]) {
                   int temp=nums[i];
                   nums[i]=nums[correctIndex];
                   nums[correctIndex]=temp;

            } else {
                i++;
            }
        }
    }
}
