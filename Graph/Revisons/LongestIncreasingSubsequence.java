public class LongestIncreasingSubsequence{
	
	public static void main(String[] args){
		//int[] nums={10,9,2,5,3,7,101,18}; 
		//int[] nums={0,1,0,3,2,3};
		//int[] nums={4,10,4,3,8,9};
		//int[] nums={1,3,2};
		int[] nums={52,9,11,56,23,59,18,91,28,41,1,30,14};
		Integer[][] memo=new Integer[nums.length][nums.length+1];
		//System.out.println(lisMemoiation(nums,nums.length-1,memo));
		System.out.println(lisTabulation(nums));
	}
	
	//Approach 1 : recurseive 
	public static int lisRecursive(int[] nums,int idx,int prevIdx){
		if(idx >= nums.length) {
			return 0;
		}
		int take=0;
		int nottake=0;
		if(prevIdx==-1 || nums[idx] > nums[prevIdx]){
			take=1+lisRecursive(nums,idx+1,idx);
		}
		nottake=lisRecursive(nums,idx+1,prevIdx);
		return Math.max(take,nottake);
	}
	
	//approach 2: memoization 
	public static int lisMemoiation(int[] nums,int idx,int prevIdx,Integer[][] memo){
		if(idx >= nums.length) {
			return 0;
		}
		if(memo[idx][prevIdx+1]!=null) return memo[idx][prevIdx+1];
		int take=0;
		int nottake=0;
		if(prevIdx==-1 || nums[idx] > nums[prevIdx]){
			take=1+lisMemoiation(nums,idx+1,idx,memo);
		}
		nottake=lisMemoiation(nums,idx+1,prevIdx,memo);
		memo[idx][prevIdx+1]=Math.max(take,nottake);
		return Math.max(take,nottake);
	}
	
	//Approach 1: Tabbulation 
	public static int lisTabulation(int[] nums){
		int[][] dp=new int[nums.length+1][nums.length+1];
		for(int idx=nums.length-1;idx>=0;idx--){
			for(int lastIdx=nums.length;lastIdx>=0;lastIdx--){
				if(idx >= nums.length) {
					return 0;
				}
				int take=0;
				int nottake=0;
				if(lastIdx==nums.length || nums[idx] > nums[lastIdx]){
					take=1+dp[idx+1][idx];
				}
				nottake=dp[idx+1][lastIdx];
				dp[idx][lastIdx]=Math.max(take,nottake);
			}
		}
		for(int row=0;row<dp.length;row++){
			for(int col=0;col<dp[row].length;col++){
				System.out.print(dp[row][col]);
			}
			System.out.println();
		}
		return 0;
	}
	
	public static int lisTabulation_space(int[] nums){
		int current=0;
		int previous=0;
		for(int idx=0;idx<nums.length;idx++){
			if(idx == 0 ) {
				current=1;
			}else{
				int take=0;
				int nottake=0;
				if(nums[idx] > nums[idx-1]){
					take=1+previous;
				}
				nottake=previous;
				current=Math.max(take,nottake);
				previous=current;
			}
		}
		return current;
	}

}