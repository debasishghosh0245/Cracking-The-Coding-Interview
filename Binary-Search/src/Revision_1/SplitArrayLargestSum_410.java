public class SplitArrayLargestSum_410{
	
	/*Given an array nums which consists of non-negative integers and an integer m, you can split the array into m non-empty continuous subarrays.
	Write an algorithm to minimize the largest sum among these m subarrays. */

	public static void main(String[] args){
		//int[] nums={7,2,5,10,8};
		//int m=2;
		int[] nums={1,4,4};
		int m=3;
		System.out.println(splitArray(nums,m));
	}
	
	public static int splitArray(int[] nums, int m) {
        int low=0; //lowest possible sum
		int high=0; //highest possible sum
		for(int num:nums){
			low=Math.max(num,low);
			high+=num;
		}
		while(low<high){
			int mid=low+(high-low)/2;
			//System.out.println("middle >>  "+mid);
			int subarrayCount=calSubarraysCount(nums,mid);
			//System.out.println("Sub array Count >> "+subarrayCount);
			if(subarrayCount <= m){
				high=mid;
			}else{
				low=mid+1;
			}
		}
		return high;//
    }
	
	public static int calSubarraysCount(int[] nums,int sum){
		int currentSum=0;
		int subArraysCount=0;
		for(int i=0;i<nums.length;i++){
			if(currentSum+nums[i]>sum){
				currentSum=nums[i];
				subArraysCount++; 
			}else{
				currentSum+=nums[i];
			}
		}
		return subArraysCount+1;
	}
}