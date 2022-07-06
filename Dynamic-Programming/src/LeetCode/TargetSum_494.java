public class TargetSum_494{
	
	public static void main(String args[]){
		int[] nums ={1,1,1};
		int target=1;
		Integer[][] memo=new Integer[nums.length][target+1];
		System.out.println("Ans >> "+findTheTargetSubArrayMemo(nums,nums.length-1,0,target,memo));
	}
	
	public static int findTheTargetSubArray(int[] nums,int idx,int sum,int target){
		if(idx < 0){
			if(sum==target) 
				return 1;
			else 
				return 0;
		}
		return findTheTargetSubArray(nums,idx-1,sum-nums[idx],target)
		+findTheTargetSubArray(nums,idx-1,sum+nums[idx],target);
	}
	
	public static int findTheTargetSubArrayMemo(int[] nums,int idx,int sum,
	int target,Integer[][] memo){
		if(idx < 0){
			if(sum==target) 
				return 1;
			else 
				return 0;
		}
		if(memo[idx][sum]!=null) return memo[idx][sum];
		int result=findTheTargetSubArrayMemo(nums,idx-1,sum-nums[idx],target,memo)
		+findTheTargetSubArrayMemo(nums,idx-1,sum+nums[idx],target,memo);
		memo[idx][sum]=result;
		return result;
	}

}