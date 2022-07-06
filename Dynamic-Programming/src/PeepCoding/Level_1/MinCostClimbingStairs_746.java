import java.util.*;
public class MinCostClimbingStairs_746{

	public static void main(String[] args){
		int[] cost={1,100,1,1,1,100,1,1,100,1};
		//int[] cost={10,15,20};
		int[] cache=new int[cost.length+1];
		System.out.println(minCostClimbingStairsMemo(cost,cost.length,cache));
	}
	
	public static int minCost(int[] cost){
		int[] dp=new int[cost.length+1];
		dp[cost.length]=0;
		for(int i=cost.length-1;i>=0;i--){
			int minCost=Integer.MAX_VALUE;
			for(int jump=1;jump <= 2 && (i+jump)<dp.length ; jump++){
				minCost=Math.min(minCost,dp[i+jump]);
			}
			if(minCost!=Integer.MAX_VALUE){
				dp[i]=minCost+cost[i];
			}else{
				dp[i]=cost[i];
			}
			
		}
		return Math.min(dp[0],dp[1]);
	}
	
	
	public static int minCostClimbingStairsRec(int[] cost,int n) {
		if (n <= 1) {
            return 0;
        }
		int result1=cost[n-1]+minCostClimbingStairsRec(cost,n-1);
		int result2=cost[n-2]+minCostClimbingStairsRec(cost,n-2);
		int result=Math.min(result1,result2);
		System.out.println(result);
		return result;
	}
	
	public static int minCostClimbingStairsMemo(int[] cost,int n,int[] cache) {
	
		if (n <= 1) {
            return 0;
        }
		else if(cache[n]>0) return cache[n];
		
		int result1=cost[n-1]+minCostClimbingStairsMemo(cost,n-1,cache);
		int result2=cost[n-2]+minCostClimbingStairsMemo(cost,n-2,cache);
		int result=Math.min(result1,result2);
		cache[n]=result;
		return result;
	}
}
