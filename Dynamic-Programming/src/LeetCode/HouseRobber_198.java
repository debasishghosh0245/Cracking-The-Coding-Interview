import java.util.*;
public class HouseRobber_198{
	
	public static void main(String[] args){
		//int[] nums={2,7,9,3,1};
		//int[] nums={1,2,3,1};
		int[] nums={1,2};
		Integer[] cache=new Integer[nums.length];
		System.out.println("Maximum Robbed >> "+maximumRobDP(nums));
	}
	
	//Solution : 2
	//Memoization
	public static int maximumRobMemo(int[] nums,int idx,Integer[] cache){
		if(idx==0){
			return nums[0];
		}
		else if(idx < 0 ) {
			return 0;
		}
		else if(cache[idx]!=null) {
			return cache[idx];
		}
		System.out.println("Cost "+idx);
		int take=nums[idx]+maximumRobMemo(nums,idx-2,cache);
		int nontake=maximumRobMemo(nums,idx-1,cache);
		int cost=Math.max(take,nontake);
		cache[idx]=cost;
		return cost;
	}
	
	//Solution: 1
	//Appraoche1 : Recursive
	public static int maximumRobRec(int[] nums,int idx){
		if(idx==0){
			return nums[0];
		}
		else if(idx < 0 ) {
			return 0;
		}
		System.out.println("Cost "+idx);
		int take=nums[idx]+maximumRobRec(nums,idx-2);
		int nontake=maximumRobRec(nums,idx-1);
		int cost=Math.max(take,nontake);
		return cost;
	}
	
	//Approach 3 : Dynamic Programming 
	public static int maximumRobDP(int[] nums){
		int[] dp=new int[nums.length];
		dp[0]=nums[0];
		for(int i=1;i<dp.length;i++){
			int take=nums[i];
			if(i-2 >=0 && i < nums.length){
				take=nums[i]+dp[i-2];
			}
			int nontake=dp[i-1];
			dp[i]=Math.max(take,nontake);
		}
		System.out.println(Arrays.toString(dp));
		return dp[dp.length-1];
	}
}