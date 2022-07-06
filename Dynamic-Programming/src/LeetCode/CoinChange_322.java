public class CoinChange_322{
	
	public static void main(String[] args){
		int amount = 5;
		int[] coins ={1,2,5}; 
		//int amount=500;
		//int[] coins={3,5,7,8,9,10,11};		
		//Integer[][] memo=new Integer[coins.length][amount+1];
		System.out.println("Ans >> "+coinChangeDP(coins,amount));
	}
	
	//Approach 1 : Recursion
	//Time Complexity  :
	//Space Complexity :
	public static int coinChangeCombinationRec(int[] coins,int idx,int amount) {
		if(idx < 0){
			if(amount==0) return 1;
			else return 0;
		}
		if(amount==0){
			return 1;
		}
		int result1=coinChangeCombinationRec(coins,idx-1,amount);
		int result2=0;
		if(amount >= coins[idx]){
			result2=coinChangeCombinationRec(coins,idx,amount-coins[idx]);
		}
		int total=result1+result2;
		return total;
	}
	
	//Approach 2 : Recursion & Backtracking
	//Time Complexity  :
	//Space Complexity :
	public static int coinChangeCombinationMemo(int[] coins,int idx,int amount,Integer[][] memo) {
		if(idx < 0){
			if(amount==0) return 1;
			else return 0;
		}
		if(amount==0){
			return 1;
		}
		if(memo[idx][amount]!=null){
			return memo[idx][amount];
		}
		
		int result1=coinChangeCombinationMemo(coins,idx-1,amount,memo);
		int result2=0;
		if(amount >= coins[idx]){
			result2=coinChangeCombinationMemo(coins,idx,amount-coins[idx],memo);
		}
		int total=result1+result2;
		memo[idx][amount]=total;
		return total;
	}
	
	//Approach 2 :  Tablular 
	//Time Complexity  :
	//Space Complexity :
	public static int coinChangeDP(int[] coins,int amount) {
		int[][] dp=new int[coins.length][amount+1];
		for(int coinsIdx=0;coinsIdx<dp.length;coinsIdx++){
			for(int amt=0;amt<=amount;amt++){
				//for base cases
				if(amt==0) {
					dp[coinsIdx][amt]=1;
				}
				if(coinsIdx==0){
					if(amt%coins[coinsIdx]==0){
						dp[coinsIdx][amt]=1;
					}
				}
				else{
					int result1=dp[coinsIdx-1][amt];
					int result2=0;
					if(amt >= coins[coinsIdx]){
						result2=dp[coinsIdx][amt-coins[coinsIdx]];
					}
					dp[coinsIdx][amt]=result1+result2;
				}
			}
		}
		for(int coinsIdx=0;coinsIdx<coins.length;coinsIdx++){
			for(int amt=0;amt<=amount;amt++){
				System.out.print(dp[coinsIdx][amt]);
			}
			System.out.println("");
		}
		return dp[coins.length-1][amount];
	}
}