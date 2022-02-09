package LeetCode;

import java.util.*;
public class CreateTargetArrayInTheGivenOrder_1389{

       public static void main(String[] args) {
		   int[] nums = {0,1,2,3,4};
		   int[] index = {0,1,2,2,1};
		   int[] result=createTargetArray(nums,index);
		   System.out.println(Arrays.toString(result));
	   }
	   
	   public static int[] createTargetArray(int[] nums, int[] index) {
		   int[] result=new int[index.length];
		   for(int i=0;i<index.length;i++) {
			   result[index[i]]=nums[i];
		   }
		   return result;
        
       }


}