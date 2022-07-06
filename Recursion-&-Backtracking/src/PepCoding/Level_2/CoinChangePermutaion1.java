import java.util.*;
public class CoinChangePermutaion1 {

	public static void main(String[] args) {
		int[] coins={5,2,3};
		int[] boxes=new int[coins.length];
		int target=8;
		coinChagnePermutaions(coins,0,boxes,target,0);
	}
	
	public static void coinChagnePermutaions(int[] coins,int coinIdx,int[] boxes,
		int target,int currentSum){
		if(currentSum==target){
			for(int i=0;i<boxes.length;i++){
			System.out.print(boxes[i]);
			}
			System.out.println("");
			return;
		}
		
		
		for(int i=0;i<coins.length;i++){
			if(boxes[i]==0){
					boxes[i]=coins[coinIdx];
					coinChagnePermutaions(coins,coinIdx+1,boxes,target,
					currentSum+coins[coinIdx]);
					boxes[i]=0;
			}
		}	
	}
}