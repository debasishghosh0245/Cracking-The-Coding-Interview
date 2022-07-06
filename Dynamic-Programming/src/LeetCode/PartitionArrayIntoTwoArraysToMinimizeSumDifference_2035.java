public class PartitionArrayIntoTwoArraysToMinimizeSumDifference_2035 {

	public static void main(String[] args){
		int[] nums={3,9,7,3};
		System.out.println(canPartition(nums));
	}

	public static boolean canPartition(int[] nums){
		int total_sum=0;
		for(int i=0;i<nums.length;i++){
			total_sum+=nums[i];
		}
		if(total_sum%2!=0) return false;
		else {
			int sumset_sum=total_sum/2;
			Boolean[][] cache=new Boolean[nums.length][sumset_sum+1];
			return canPartitionMemo(nums,nums.length-1,sumset_sum,cache);
			///return canPartitionRec(nums,nums.length-1,total_sum/2);
		} 
	}

	//Appraoche : Recursive 
	//Time Complexity  :  
	//Space Complexity :
	public static boolean canPartitionRec(int[] nums,int idx,int subsetSum) {
        if(idx==0) {
			if(subsetSum==nums[0]) return true;
			else return false;
		}
		if(subsetSum==0) {
			return true;
		}
		
		boolean take=canPartitionRec(nums,idx-1,subsetSum);
		boolean nontake=false;
		if(subsetSum >= nums[idx]){
			nontake=canPartitionRec(nums,idx-1,subsetSum-nums[idx]);
		}
		return nontake || take;
    }
	
	
	//Appache 2 : Memoizaiton 
	//Time Complexity  :  
	//Space Complexity :
	public static  boolean canPartitionMemo(int[] nums,int idx,int subsetSum,
		Boolean[][] cache) {
        if(idx==0) {
			if(subsetSum==nums[0]) return true;
			else return false;
		}
		else if(subsetSum==0) {
			return true;
		}
		else if(cache[idx][subsetSum]!=null){
			return cache[idx][subsetSum];
		}
		boolean take=canPartitionMemo(nums,idx-1,subsetSum,cache);
		boolean nontake=false;
		if(subsetSum > nums[idx]){
			nontake=canPartitionMemo(nums,idx-1,subsetSum-nums[idx],cache);
		}
		cache[idx][subsetSum]=(nontake||take);
		return nontake || take;
    }
	
	//Approach 3: Dynamic Programming 
	//Time Complexity  :
	//Space Complexity :
	public static boolean canPartitionDP(int[] nums,int subsetSum){
		boolean[][] dp=new boolean[nums.length][subsetSum+1];
		for(int idx=0;idx<nums.length;idx++){
			for(int sum=0;sum <= subsetSum;sum++){
				if(sum==0){
					dp[idx][sum]=true;
				}
				else if(idx==0){
					if(nums[idx]==sum){
						dp[idx][sum]=true;
					}
				}
				else {
					boolean take=dp[idx-1][sum];
					boolean nontake=false;
					if(sum > nums[idx]){
						nontake=dp[idx-1][sum-nums[idx]];
					}
					dp[idx][sum]=(take || nontake);
				}
			}
		}
		
		for(int idx=0;idx<nums.length;idx++){
			for(int sum=0;sum<=subsetSum;sum++){
				System.out.print(dp[idx][sum]+" ");
			}
			System.out.println("");
		}
		
		return dp[nums.length-1][subsetSum];
	}	


}
