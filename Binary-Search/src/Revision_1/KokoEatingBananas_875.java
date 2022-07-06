import java.util.*;
public class KokoEatingBananas_875{
	
	public static void main(String[] args){
		int[] piles={3,6,7,11};
		int h=8;
		System.out.println("Minimum Eating Speed >> "+minEatingSpeed(piles,h));
	}
	
	public static int minEatingSpeed(int[] piles,int h) {
		int low=1;
		int high=Integer.MIN_VALUE;
		for(int pile:piles){
			high=Math.max(high,pile);
		}
		while(high>low){
			int mid=low+(high-low)/2;
			// Check if middle is a workable speed,and cut the search space by half.
			if(timeSpend(piles,mid)<=h){
				high=mid;
			}else{
				low=mid+1;
			}
		}
		return high;
    }
	
	public static int timeSpend(int[] piles,int speed){
		int totalTime=0;
		for(int i=0;i<piles.length;i++){
			totalTime+=(int)Math.ceil((double)piles[i]/speed);
		}
		return totalTime;
	}
	
}