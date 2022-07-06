package LeetCode;

import java.util.*;

public class SplitArrayLargestSum_410 {

      public static void main(String[] args) {
            /* int[] nums = {1,2,3,4,5}; int m = 2; */
            /* int[] nums = {1,4,4}; int m = 3; */
//            int[] nums = { 7,2,5,10,8}; int m = 2;
             int[] nums={2,16,14,15}; int m=2;

          System.out.println("Minimize the Largest sum " +splitArray(nums,m));
      }
          
       public static int splitArray(int[] nums, int m) {
         int high=0;
         int low=0;
         for(int num: nums) {
             high+=num;
             low=Math.max(low,num);
         }
         System.out.println("high >> "+high);
         System.out.println("Low >> " +low);
         while(low<=high) {
             int mid=low+(high-low)/2;
             if(isPossible(nums,m,mid)) {
                 high=mid-1;
             }else{
                 low=mid+1;
             }
         }
          return low;
       }
       
       public static boolean isPossible(int[] nums, int m, int target) {
           int sum=0;
           for(int i=0;i<nums.length;i++) {
               sum+=nums[i];
               if(sum>target) {
                   m--;sum=0;i--;
               }
           }
          return m >=1; 
       }
}