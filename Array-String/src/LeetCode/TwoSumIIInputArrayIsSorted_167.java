package LeetCode;

import java.util.*;
public class  TwoSumIIInputArrayIsSorted_167{

   public static void main(String[] args) {
	   int[] numbers = {2,7,11,15};
       int target=9;
	   int[] result=twoSum(numbers,target);
	   System.out.println(Arrays.toString(result));
   }
   
   public static int[] twoSum(int[] numbers, int target) {        
      int left=0;
      int right=numbers.length-1;
      while(left<right) {
            if(numbers[left]+numbers[right]==target) {
               return new int[] {left,right}; 
            }else if(numbers[left]+numbers[right]>target) {
               right--;
            }else{
              left++;
            }  
      }
      return new int[] {left,right};
    }

}