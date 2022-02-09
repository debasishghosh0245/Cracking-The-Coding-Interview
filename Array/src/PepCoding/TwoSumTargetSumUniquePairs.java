import java.util.*;
public class TwoSumTargetSumUniquePairs {
     
    public static void main(String[] args) {
        int[] nums={2, 2, 4, 4};
        int target=6;
        List<List<Integer>> list=twoSum(nums,target);
        System.out.println(list);
    }
    
    public static List<List<Integer>> twoSum(int[] nums, int target) {
        Arrays.sort(nums);
        int left=0;
        int right=nums.length-1;
        List<List<Integer>> list=new ArrayList<List<Integer>>();
        while(left<right) {
            if(nums[left]+nums[right]==target) {
		        list.add(Arrays.asList(nums[left++],nums[right--])); 
                while(left<right && nums[left]==nums[left-1]) {
                    left++;
                } 
                while(left<right && nums[right]==nums[right+1]) {
                    right--;
                }
	        }else if(nums[left]+nums[right]>target) {
		        right--;
	        }else{
		        left++;
	        } 
        }
        return list;
    }
    
    
    
}
