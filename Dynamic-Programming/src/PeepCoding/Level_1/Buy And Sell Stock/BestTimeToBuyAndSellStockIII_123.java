public class BestTimeToBuyAndSellStockIII_123{

	public static void main(String[] args){
		int[] prices ={3,3,5,0,0,3,1,4};
		Integer[][][] memo=new Integer[prices.length][2][3];
		System.out.println(maxProfitTabular(prices));
	}
	
	//Approach 1: recursive 
	public static int maxProfit(int[] prices,int day,int buy,int txn) {
		if(day >= prices.length || txn==0) return 0;
		int profit=0;
		if(buy==1){
			int profitWithBuy=-prices[day]+maxProfit(prices,day+1,0,txn);
			int profitWithNotBuy=0+maxProfit(prices,day+1,1,txn);
			profit=Math.max(profitWithBuy,profitWithNotBuy);
		}
		else{
			int profitWithSell=prices[day]+maxProfit(prices,day+1,1,txn-1);
			int profitWithNotSell=0+maxProfit(prices,day+1,0,txn);
			profit=Math.max(profitWithSell,profitWithNotSell);
		}
		return profit;
    } 
	
	//Approach 2: Memoziation 
	public static int maxProfitMemo(int[] prices,int day,int isBuy,
		int txn,Integer[][][] memo) {
		if(day >= prices.length || txn==0) return 0;
		if(memo[day][isBuy][txn]!=null) return memo[day][isBuy][txn];
		int profit=0;
		if(isBuy==1){
			int profitWithBuy=-prices[day]+maxProfitMemo(prices,day+1,0,
			txn,memo);
			int profitWithNotBuy=0+maxProfitMemo(prices,day+1,1,
			txn,memo);
			profit=Math.max(profitWithBuy,profitWithNotBuy);
		}
		else{
			int profitWithSell=prices[day]+maxProfitMemo(prices,day+1,1,
			txn-1,memo);
			int profitWithNotSell=0+maxProfitMemo(prices,day+1,0,
			txn,memo);
			profit=Math.max(profitWithSell,profitWithNotSell);
		}
		memo[day][isBuy][txn]=profit;
		return profit;
    } 
	
	//Approach 3: Top - Down  
	public static int maxProfitTabular(int[] prices) {
		int[][][] dp=new int[prices.length][2][2];
		for(int day=prices.length-1;day>=0;day--){
			for(int isBuy=0;isBuy<=1;isBuy++){
				for(int txn=0;txn<2;txn++){
					if(day==prices.length-1 || txn==0){
						dp[day][1][txn]=0;
					}else{
						int profit=0;
						if(isBuy==1){
							int profitWithBuy=-prices[day]+dp[day+1][0][txn];
							int profitWithNotBuy=0+dp[day+1][1][txn];
							profit=Math.max(profitWithBuy,profitWithNotBuy);
						}
						else {
							int profitWithSell=prices[day]+dp[day+1][1][txn];
							int profitWithNotSell=0+dp[day+1][0][txn-1];
							profit=Math.max(profitWithSell,profitWithNotSell);
						}
						dp[day][isBuy][txn]=profit;
					}
				}
			}
		}
		return dp[0][1][1];
    } 
}