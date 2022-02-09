package LeetCode;

import java.util.*;

public class RunningSumOf1dArray_1480 {

     /* https://leetcode.com/problems/running-sum-of-1d-array/ */
    public static void main(String[] args){
		int[] nums = {1,1,1,1,1};
       /*   Output: [1,3,6,10] */
	    int[] result=runningSum(nums);
		System.out.println(Arrays.toString(result));
	}
	
	 public static int[] runningSum(int[] nums) {
	   int[] result=new int[nums.length];
       result[0]=nums[0];
       for(int i=1;i<nums.length;i++) {
		   result[i]=result[i-1]+nums[i];
	   }	   
	   return result;
	} 
	
    /* 	public static int[] runningSum(int[] nums) {
		int[] result=new int[nums.length];
		for(int i=0;i<nums.length;i++){
			result[i]=calSum(i,nums);
		}
		return result;
    } */
	
	/* public static int calSum(int i ,int[] nums) {
		int sum=0;
		while(i>=0){
			sum+=nums[i--];
			
		}
		return sum;
	} */

}