package LeetCode;

import java.util.*;

public class ShuffleTheArray_1470 {
	
	/* https://leetcode.com/problems/shuffle-the-array/ */
	
	public static void main(String[] args) {
		
		/* int[] nums = {2,5,1,3,4,7}; int n = 3; */
		 int[] nums={1,2,3,4,4,3,2,1}; int n=4;
        /* Output: [2,3,5,4,1,7]  */
		int[] result=shuffle(nums,n);
		System.out.println(Arrays.toString(result));
	}
	
	public static int[] shuffle(int[] nums,int n) {
		int[] result=new int[nums.length];
		int i=0;
		int j=(nums.length-1)/2+1;
		for(int r=0;r<nums.length;r++){
			if(r%2==0) {
				result[r]=nums[i++];
			}else{
				result[r]=nums[j++];
			}
		}
        return result;
    }
	
	
}