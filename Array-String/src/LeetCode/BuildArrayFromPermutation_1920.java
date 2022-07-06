package LeetCode;

import java.util.*;

public class BuildArrayFromPermutation_1920 {

      /*  https://leetcode.com/problems/build-array-from-permutation/ */
	   
	   public static void main(String[] args) {
		  int nums[] = {0,2,1,5,3,4};
		  int[] arr=buildArray(nums);
		  System.out.println(Arrays.toString(arr));
	   }
	   
	   public static int[] buildArray(int[] nums) {
		   int[] result=new int[nums.length];
		   for(int i=0;i<nums.length;i++) {
			   result[i]=nums[nums[i]]; 
		   }
		   return result;
       }
}