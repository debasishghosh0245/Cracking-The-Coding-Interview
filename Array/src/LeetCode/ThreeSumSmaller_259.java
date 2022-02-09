import java.util.*;
public class ThreeSumSmaller_259 {

    public static void main(String[] args) {
       int[] nums ={-2,0,1,3};
       int target = 2;
       System.out.println(threeSumClosest(nums,target));
    }
    
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result=0;
        for(int i=0;i<nums.length;i++) {
             result+=twoSum(nums,target-nums[i],i);
        }
        return result;
    }
    
    public static int twoSum(int[] nums,int target,int i) {
        int low=i+1;int high=nums.length-1;
        int result=0;
        int sum=0;
        while(low< high) {
            sum=nums[low]+nums[high];
            if(sum < target) {
                result+=high-low;
                low++;
            }
            else {
                 high--;
            }
        }
        return result;
    }

}
 
