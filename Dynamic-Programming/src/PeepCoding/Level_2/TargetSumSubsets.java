import java.util.*;
public class TargetSumSubsets{
	
	public static void main(String[] args){
		int[] arr={4,2,7,1,3};
		int target=10;
		//Boolean[][] cache=new Integer[arr.length][target];
		System.out.println(subSetSumRecur(arr,arr.length-1,target));
	}
	
	//Approache 1 : Recurive
	//Time Complexity  :
	//Space Complexity :
	public static boolean subSetSumRecur(int[] arr,int idx,int sum){
		if(idx==0){
			if(sum==0) return true;
			else return false;
		}
		else if(sum==0) return true;
		boolean nonPicked=subSetSumRecur(arr,idx-1,sum);
		boolean pickeed=subSetSumRecur(arr,idx-1,sum-arr[idx]);
		if(nonPicked || pickeed ) return true;
		else return false;
	}
	
	//Approache 2 : Meomoziation 
	//Time Complexity :
	//Space Complexity: 
	public static boolean subSetSumMemo(int[] arr,int idx,int sum){
		if(idx==0){
			if(sum==0) return true;
			else return false;
		}
		else if(sum==0) return true;
		//if(memo[idx][sum]!=null) return memo[idx][sum];
		boolean nonPicked=subSetSumMemo(arr,idx-1,sum);
		boolean pickeed=subSetSumMemo(arr,idx-1,sum-arr[idx]);
		if(nonPicked && pickeed ){
			//memo[idx][sum]=true;
			return true;
		}
		else{
			//memo[idx][sum]=false;
			return false;
		}
	}
	
	//Approach 3 : Dynamic Programming 
	//Time Complexity  : 
	//Space Complexity : 
	public static boolean subSetSumDP(int[] arr,int target){
		boolean[][] dp=new boolean[arr.length][target];
		//base case
		for(int idx=0;idx<arr.length;idx++){
			for(int sum=0;sum<target;sum++){
				if(sum==0) {
					dp[idx][sum]=true;
				}
				else if(idx==0){
					if(sum==dp[idx][sum]){
						dp[idx][sum]=true;
					}
				}
				else{
					boolean nonPicked=dp[idx-1][sum];
					boolean pickeed=dp[idx-1][sum-arr[idx]];
					dp[idx][sum]=(nonPicked || pickeed);
				}
				
			}
		}
		for(int idx=0;idx<arr.length;idx++){
			for(int sum=0;sum<target;sum++){
				System.out.println(dp[idx][sum]);
			}
		}
		return false;
	}
	
	
	
}