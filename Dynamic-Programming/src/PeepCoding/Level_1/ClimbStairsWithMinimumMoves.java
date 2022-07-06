import java.util.*;
public class ClimbStairsWithMinimumMoves {

	public static void main(String[] args){
		int[] jumps={3,3,0,2,1,2,4,2,0,0};
		int result=0;
		int ans=climbStairWithMinimumMoves(0,10,jumps,result);
		//int ans=climbStariWithJumps(10,jumps);
		System.out.println("Answer "+ans);
	}
	
	public static int climbStairWithMinimumMoves(int stair,int n,
		int[] jumps,int result){
		if (stair > n) return Integer.MAX_VALUE;
		else if (stair == n) return 0;
		int minResult = Integer.MAX_VALUE;
		for (int jump = 1; jump <= jumps[stair]; jump++) {	
			Integer rs1 = climbStairWithMinimumMoves(stair + jump, n, jumps, result);
			if (rs1 != null) {
				minResult = Math.min(rs1, minResult);
			}
			if (minResult != Integer.MAX_VALUE) {
				result = minResult + 1;
			}
		}
		return result;
	}
	
	public static int climbStariWithJumps(int n,int[] jumps) {
		Integer[] dp=new Integer[n+1];
		dp[n]=0;
		for(int stair=n-1;stair >= 0;stair--){
			int minJump=Integer.MAX_VALUE;
			for(int jump=1;jump <=jumps[stair];jump++){
				if(stair+jump <= n){
					if(dp[stair+jump]!=null){
						minJump=Math.min(minJump,dp[stair+jump]);
						dp[stair]=minJump;
					}
				}
			}
			if(minJump!=Integer.MAX_VALUE && dp[stair]!=null){
				dp[stair]=dp[stair]+1;
			}
		}
		return dp[0];
	}
}