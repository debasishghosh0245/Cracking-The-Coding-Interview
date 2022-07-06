public class CoinChangeCombinations1{

	public static void main(String[] args){
		int[] coins={5,2,3,6,7};
		int target=12;
		coinChagneCombination(coins,0,target,0,"");
	}
	
	public static void coinChagneCombination(int[] coins,int idx,int target,
		int currentSum,String ansf){
		if(idx > coins.length-1){
			if(target==currentSum){
				System.out.println(ansf);
			}
			return;
		}
		coinChagneCombination(coins,idx+1,target,currentSum+coins[idx],
		ansf+coins[idx]);
		coinChagneCombination(coins,idx+1,target,currentSum,ansf);
	}

}