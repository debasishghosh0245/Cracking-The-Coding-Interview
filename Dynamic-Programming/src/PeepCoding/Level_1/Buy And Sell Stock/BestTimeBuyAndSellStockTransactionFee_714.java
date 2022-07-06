public class BestTimeBuyAndSellStockTransactionFee_714{

	public static void main(String[] args){
		int[] prices={1,3,2,8,4,9}; int fee=2;
		//int[] prices={1,2,3,4,5};
		Integer[][] memo=new Integer[prices.length][2];
		System.out.println(maxProfitTabular(prices,fee));
	}
	
	//Approach1: Recursive 
	public static int maxProfitRec(int[] prices,int day,int buy,int txnfee) {
		if(day >= prices.length) return 0;
		int profit=0;
		if(buy==1){
			int profitWithBuy=-prices[day]+maxProfitRec(prices,day+1,0,txnfee);
			int profitWithNotBuy=0+maxProfitRec(prices,day+1,1,txnfee);
			profit=Math.max(profitWithBuy,profitWithNotBuy);
		}
		else{
			int profitWithSell=prices[day]-txnfee+maxProfitRec(prices,day+1,1,txnfee);
			int profitWithNotSell=0+maxProfitRec(prices,day+1,0,txnfee);
			profit=Math.max(profitWithSell,profitWithNotSell);
		}
		return profit;
    } 
	
	//Approach 2: Memoziation 
	public static int maxProfitMemo(int[] prices,int day,int isBuy,
		int txnfee,Integer[][] memo) {
		if(day >= prices.length) return 0;
		if(memo[day][isBuy]!=null) return memo[day][isBuy];
		int profit=0;
		if(isBuy==1){
			int profitWithBuy=-prices[day]+maxProfitMemo(prices,day+1,0,txnfee,memo);
			int profitWithNotBuy=0+maxProfitMemo(prices,day+1,1,txnfee,memo);
			profit=Math.max(profitWithBuy,profitWithNotBuy);
		}
		else{
			int profitWithSell=prices[day]-txnfee
				+maxProfitMemo(prices,day+1,1,txnfee,memo);
			int profitWithNotSell=0+maxProfitMemo(prices,day+1,0,txnfee,memo);
			profit=Math.max(profitWithSell,profitWithNotSell);
		}
		memo[day][isBuy]=profit;
		return profit;
    } 
	
	//approach 3: Top - Down  
	public static int maxProfitTabular(int[] prices,int fee) {
		int[][][] dp=new int[prices.length+1][2][fee+1];
		for(int day=dp.length-1;day>=0;day--){
			for(int isBuy=0;isBuy<=1;isBuy++){
				for(int txnfee=1;txnfee<=fee;txnfee++){
					if(day==dp.length-1 || txnfee==0){
						dp[day][isBuy][txnfee]=0;
					}else{
						int profit=0;
						if(isBuy==1){
							int profitWithBuy=-prices[day]+dp[day+1][0][txnfee];
							int profitWithNotBuy=0+dp[day+1][1][txnfee];
							profit=Math.max(profitWithBuy,profitWithNotBuy);
						}
						else {
							int profitWithSell=prices[day]-txnfee+dp[day+1][1][txnfee];
							int profitWithNotSell=0+dp[day+1][0][txnfee];
							profit=Math.max(profitWithSell,profitWithNotSell);
						} 
						dp[day][isBuy][txnfee]=profit;
					}
				}
			}
		}
		return dp[0][1][2];
    } 
}