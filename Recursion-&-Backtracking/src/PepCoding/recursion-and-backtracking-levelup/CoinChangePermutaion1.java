import java.util.*;
public class CoinChangePermutaion1 {

	public static void main(String[] args) {
		int[] coins={2,3,5,6,7};
		int amt=12;
		boolean[] place=new boolean[coins.length];
		coinChange(coins,place,0,amt," ");
	}
	
	public static void coinChange(int[] coins,boolean[] place,int amtsf,int tamt,String ans){
		if(amtsf>tamt) { 
			return;
		}
		else if(amtsf==tamt){
			System.out.println(ans+".");
			return;
		}
		for(int i=0;i<coins.length;i++){
			if(place[i]==false ) {
				place[i]=true;
				coinChange(coins,place,amtsf+coins[i],tamt,ans+coins[i]+"-");
				place[i]=false;
			}
		}
    }
}