public class CoinChangeCombinations1 {

	public static void main(String[] args) {
		int[] coins={2,3,5,6,7};
		int amt=12;
		coinChange(coins,0,0,amt," ");
		
		
	}
	
	public static void coinChange(int[] coins,int idx,int amtsf,int amt,String ansf){
		if(idx==coins.length) {
			if(amtsf==amt){
				System.out.println(ansf+"");
			}
			return;
		}
		
		coinChange(coins,idx+1,amtsf+coins[idx],amt,ansf+coins[idx]+"-");
		coinChange(coins,idx+1,amtsf,amt,ansf);
    }

}