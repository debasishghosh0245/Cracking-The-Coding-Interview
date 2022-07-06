import java.util.*;
public class TwoSumLessThanK_1099{
    
	public static void main(String[] args) {
		/* int[] nums ={34,23,1,24,75,33,54,8};
        int	k=60; */
		int[] nums={10,20,30}; int k = 15;
		System.out.println(twoSumLessThanK(nums,k));
	} 
	 
	 
	public static int twoSumLessThanK(int[] nums, int k) {
		Arrays.sort(nums);
        int low=0; int high=nums.length-1;
		int max=-1;
		while(low<=high) {
			if(nums[low]+nums[high] < k) {
				max=Math.max(max,nums[low]+nums[high]);
				low++;
			}
			else{
				high--;
			}
		}
		return max;
    }
}