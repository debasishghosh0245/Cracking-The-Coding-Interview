package LeetCode;

import java.util.*;
public class FourSum_18{
     
    public static void main(String[] args) {
        int[] nums={-2,-1,-1,1,1,2,2}; int target=0;
        List<List<Integer>> output=fourSum(nums,target);
        System.out.println(output);
    } 
    
    public static List<List<Integer>> fourSum(int[] nums,int target) {
        Arrays.sort(nums);
        List<List<Integer>> list=new ArrayList<List<Integer>>();
        for(int i=0;i<nums.length;i++) {
            if(i==0 || nums[i]!=nums[i-1]){
                for(int j=i+1;j<nums.length;j++) {
                    if(j==i+1 || nums[j]!=nums[j-1]){
                       towSum(nums,target,i,j,list); 
                    }
                }
            }
        }
        return list;
    }
    
    public static void towSum(int[] nums,int target,int i,int start,List<List<Integer>> list ) {
        int low=start+1;
        int high=nums.length-1;
        while(low<high) {
           int sum=nums[low]+nums[high]+nums[start]+nums[i];
           if(sum==target) {
               list.add(Arrays.asList(nums[i],nums[start],nums[low++],nums[high--])); 
               while(low<high && nums[low]==nums[low-1]){
                   low++;
               }
               while(low<high && nums[high]==nums[high+1]){
                   high--;
               }
           }
           else if(sum>target) {
               high--;
           }else{
               low++;
           }
        }  
    }
}