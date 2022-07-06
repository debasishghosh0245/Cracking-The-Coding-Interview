public class Count PartitionsWithGivenDifference{

	public static void main(String[] args){
		int arr[]={2,3,5,6,8,10};
		int diff=10;
		for(int i=0;i<arr.length;i++){
			total_sum+=arr[i];
		}
		if(total_sum % 2!==0) return false;
		else{
			Integer[][] memo=new Integer[arr.length][sum+1];
			//System.out.println(countSubSet(arr,arr.length-1,sum));
			//System.out.println(countSubSetMemo(arr,arr.length-1,sum,memo));
			int subsetSum=(total_sum-diff/2)
			System.out.println(countSubSetDP(arr,sum)); 
		}
	}
	
	//Apprach 1 : Recursive
	//Time Complexity  : O(2^n)
	//Space Complexity : O(n)
	public static int countSubSet(int[] nums,int idx,int sum){
		if(sum==0) return 1;
		if(idx==0){
			if(sum==nums[idx]) return 1;
			else return 0;
		}
		return countSubSet(nums,idx-1,sum)+countSubSet(nums,idx-1,sum-nums[idx]);
	}
	
	//Apprach 2 : Memoization
	//Time Complexity  : O(n)
	//Space Complexity : O(n+n)
	public static int countSubSetMemo(int[] nums,int idx,int sum,Integer[][] memo){
		if(sum==0) return 1;
		if(idx==0){
			if(sum==nums[idx]) return 1;
			else return 0;
		}
		if(memo[idx][sum]!=null) {
			return memo[idx][sum];
		}
		int nontake=countSubSetMemo(nums,idx-1,sum,memo);
		int take=0;
		if(sum >= nums[idx]){
			take=countSubSetMemo(nums,idx-1,sum-nums[idx],memo);
		}
		memo[idx][sum]=nontake+take;
		return nontake+take;
	}
	
	//Apprach 3 : Dynamic Programming 
	//Time Complexity  : O(n)
	//Space Complexity : O(n+n)
	public static int countSubSetDP(int[] nums,int total_sum){
		int[][] dp=new int[nums.length][total_sum+1];
		
		for(int idx=0;idx<nums.length;idx++){
			for(int sum=0;sum<=total_sum;sum++){
				//base case :: start 
				if(sum==0){
					dp[idx][sum]=1;
				}
				else if(idx==0){
					if(sum==nums[0]) {
						dp[idx][sum]=1;
					}
				}
				//base case :: end 
				else {
					int nontake=dp[idx-1][sum];
					int take=0;
					if(sum >= nums[idx]){
						take=dp[idx-1][sum-nums[idx]];
					}
					dp[idx][sum]=nontake+take;
				}
			}
		}
		return dp[nums.length-1][total_sum];
	}
}