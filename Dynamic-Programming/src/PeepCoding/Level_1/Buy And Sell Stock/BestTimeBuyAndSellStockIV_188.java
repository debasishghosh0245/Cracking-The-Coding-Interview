public class BestTimeBuyAndSellStockIV_188{

	public static void main(String[] args){
		int[] prices ={2,4,1};
		int k=2;
		Integer[][][] memo=new Integer[prices.length+1][2][k+1];
		System.out.println(maxProfitMemo(prices,0,1,k,memo));
	}
	
	//approach 1: recursive 
	public static int maxProfitRec(int[] prices,int day,int buy,int txn) {
		if(day >= prices.length || txn==0) return 0;
		int profit=0;
		if(buy==1){
			int profitWithBuy=-prices[day]+maxProfitRec(prices,day+1,0,txn);
			int profitWithNotBuy=0+maxProfitRec(prices,day+1,1,txn);
			profit=Math.max(profitWithBuy,profitWithNotBuy);
		}
		else{
			int profitWithSell=prices[day]+maxProfitRec(prices,day+1,1,txn-1);
			int profitWithNotSell=0+maxProfitRec(prices,day+1,0,txn);
			profit=Math.max(profitWithSell,profitWithNotSell);
		}
		return profit;
    } 
	
	//approach 2: memoziation 
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
		int[][] dp=new int[prices.length][2];
		for(int day=prices.length-1;day>=0;day--){
			for(int isBuy=0;isBuy<=1;isBuy++){
				if(day==prices.length-1){
					dp[day][1]=0;
				}else{
					int profit=0;
					if(isBuy==1){
						int profitWithBuy=-prices[day]+dp[day+1][0];
						int profitWithNotBuy=0+dp[day+1][1];
						profit=Math.max(profitWithBuy,profitWithNotBuy);
					}
					else {
						int profitWithSell=prices[day]+dp[day+1][1];
						int profitWithNotSell=0+dp[day+1][0];
						profit=Math.max(profitWithSell,profitWithNotSell);
					}
					dp[day][isBuy]=profit;
				}
			}
		}
		
		//print the final dp
		for(int row=0; row < dp.length;row++) {
			for(int col=0;col < dp[row].length; col++){
				System.out.print(dp[row][col]+" ");
			}
			System.out.println("");
		}
		return dp[0][1];
    } 
}