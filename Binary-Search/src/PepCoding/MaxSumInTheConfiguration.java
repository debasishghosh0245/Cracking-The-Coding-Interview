public class MaxSumInTheConfiguration {
	
	public static void main(String[] args){
		int[] nums={8,3,1,2};
		System.out.println(max_sum(nums));
	}
	
	public static int max_sum(int nums[]) {
		int sum=0;
		int maxSum=0;		
		int prefix_sum=0;
		for(int i=0;i<nums.length;i++){
			prefix_sum+=i*nums[i];
			maxSum=prefix_sum;
			sum+=nums[i];
		}
		for(int i=0;i<nums.length-1;i++){
			int currentSum=prefix_sum+sum-nums.length*nums[nums.length-i-1];
			maxSum=Math.max(maxSum,currentSum);
			prefix_sum=currentSum;
		}
		return maxSum;
    }
} 