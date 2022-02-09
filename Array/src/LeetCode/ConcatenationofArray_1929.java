package LeetCode;

import java.util.*;
public class ConcatenationofArray_1929{

  /* https://leetcode.com/problems/concatenation-of-array/ */
  
  public static void main(String[] args) {
	   
	  int[] nums = {1,2,1};
	  int[] result=getConcatenationII(nums);
	  System.out.println(Arrays.toString(result));
     /*  Output: [1,2,1,1,2,1] */
   }
  
   public static int[] getConcatenation(int[] nums) {
	    int[] result=new int[2*nums.length];
        for(int i=0;i<nums.length;i++) {
			result[i]=nums[i];
			result[i+nums.length]=nums[i];
		}
		return result;
   }
   
   public static int[] getConcatenationII(int[] nums) {
	    int[] result=new int[2*nums.length];
        for(int i=0;i<2*nums.length;i++) {
			result[i]=nums[i%nums.length];
		}
		return result;
   }

} 
