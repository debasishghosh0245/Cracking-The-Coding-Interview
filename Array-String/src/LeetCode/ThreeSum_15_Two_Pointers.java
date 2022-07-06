import java.util.*;
public class ThreeSum_15_Two_Pointers {
    
    public static void main(String[] args) {
        //int[] nums = {-1,0,1,2,-1,-4};
        int[] nums={-1,0,1,2,-1,-4,-2,-3,3,0,4};
	    List<List<Integer>> output=threeSum(nums);
        System.out.println(output.toString());
    }
	public static List<List<Integer>> threeSum(int[] nums) {
         Arrays.sort(nums);
         List<List<Integer>> result=new ArrayList<List<Integer>>();
         for(int i=0;i<nums.length && nums[i]<=0; ++i) {
             if (i == 0 || nums[i - 1] != nums[i]) {
                 twoSum(nums,nums[i],i,result);
             }
         }
         return result;
    }
    public static void twoSum(int[] nums,int target,int i,List<List<Integer>> result) {
        int low=i+1; int high=nums.length-1;    
        while(low<high) {
            int sum=nums[low]+nums[high]+nums[i];
            if(sum==0){
               List<Integer> newList=new ArrayList<>();
               result.add(Arrays.asList(nums[i],nums[low++],nums[high--]));
               while(low<high && nums[low] ==nums[low-1] ){
                   low++;
               }
            }
            else if(sum>0){
                high--;
            }
            else {
               low++;
            }
        }
    }
}