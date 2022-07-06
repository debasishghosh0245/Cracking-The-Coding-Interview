import java.util.*;
public class CoinChange2_518{

	public static void main(String[] args){
		//int amount = 2;
		//int[] coins ={3}; 
		int[] coins={2,5,10,1};
		int amount=27;
		//int amount=500;
		//int[] coins={3,5,7,8,9,10,11};		
		/* Integer[][] memo=new Integer[coins.length][amount+1];
		System.out.println("result >> "+minCoinChangeMemo(coins,coins.length-1,amount,memo)); */
		
		System.out.println(minCoinChangeDP(coins,amount));
	}
	
	//Approach 1 : Recursion
	//Time Complexity  :
	//Space Complexity :
	public static int minCoinChangeRec(int[] coins,int idx,int amount) {
		if(idx == 0){
			if(amount%coins[0]==0){
				return amount/coins[0];
			}else{
				return (int)1e9;
			}
		}
		if(amount==0){
			return 0;
		}
		int result1=minCoinChangeRec(coins,idx-1,amount);
		int result2=(int)1e9;
		if(amount >= coins[idx]){
			result2=1+minCoinChangeRec(coins,idx,amount-coins[idx]);
		}
		//System.out.println(result1);
		//System.out.println(result2);
		int min=Math.min(result1,result2);
		return min;
	}
	
	//Approach 2 : Recursion & Backtracking
	//Time Complexity  :
	//Space Complexity :
	public static int minCoinChangeMemo(int[] coins,int idx,int amount,Integer[][] memo) {
		if(idx == 0){
			if(amount%coins[0]==0){
				return amount/coins[0];
			}else{
				return (int)1e9;
			}
		}
		if(amount==0){
			return 0;
		}
		if(memo[idx][amount]!=null) return memo[idx][amount];
		int result1=minCoinChangeMemo(coins,idx-1,amount,memo);
		int result2=(int)1e9;
		if(amount >= coins[idx]){
			result2=1+minCoinChangeMemo(coins,idx,amount-coins[idx],memo);
		}
		int min=Math.min(result1,result2);
		memo[idx][amount]=min;
		return min;
	}
	
	//Appraoch 3 : Tabular 
	//Time Complexity :
	//Space Complexity :
	public static int minCoinChangeDP(int[] coins,int amount) {
		int[][] dp=new int[coins.length][amount+1];
		for(int coinsIdx=0;coinsIdx<coins.length;coinsIdx++){
			for(int amt=0;amt<=amount;amt++){
				if(amt==0){
					dp[coinsIdx][amt]=0;
				}
				else if(coinsIdx==0){
					if(amt%coins[0]==0){
						dp[coinsIdx][amt]=amt/coins[0];
					}else{
						dp[coinsIdx][amt]=(int)1e9;
					}
				}
				else{	
					int result1=dp[coinsIdx-1][amt];
					int result2=(int)1e9;
					if(amt >= coins[coinsIdx]){
						result2=1+dp[coinsIdx][amt-coins[coinsIdx]];
					}
					int min=Math.min(result1,result2);
					dp[coinsIdx][amt]=min;
				}
			}
		}
		
		for(int coinsIdx=0;coinsIdx<coins.length;coinsIdx++){
			for(int amt=0;amt<=amount;amt++){
				System.out.print(dp[coinsIdx][amt]+" ");
			}
			System.out.println();
		}
		return dp[coins.length-1][amount];
	}
	
}