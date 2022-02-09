import java.util.*;
public class ThreeSumClosest_16 {

    public static void main(String[] args) {
       int[] nums ={0,1,2};
       int target=3;
       System.out.println(threeSumClosest(nums,target));
    }
    
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closestSum=nums[0]+nums[1]+nums[nums.length-1];
        for(int i=0;i<nums.length-2;i++) {
             closestSum=twoSum(nums,target,i,closestSum);
        }
        return closestSum;
    }
    
    public static int twoSum(int[] nums,int target,int i,int closestSum) {
        int low=i+1; int high=nums.length-1;
        int runningSum=0;
        while(low<high) {
            runningSum=nums[i]+nums[low]+nums[high];
            if(Math.abs(runningSum-target)<Math.abs(closestSum-target)){
               closestSum=runningSum;   
            }
            if(runningSum<target) {
                low++;
            }
            else {
                high--;
            }
            
        }
        return closestSum;
    }

}
 
