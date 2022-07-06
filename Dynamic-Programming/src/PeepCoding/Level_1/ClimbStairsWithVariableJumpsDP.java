public class ClimbStairsWithVariableJumpsDP {

	public static void main(String[] args){
		int[] jumps={3,3,0,2,1,2,4,2,0,0};
		int ans=climbStariWithJumps(10,jumps);
		System.out.println("Answer "+ans);
	}
	
	public static int climbStairWithJumps(int stair,int n,int[] jumps,
		int result){
		if(stair>n) return 0;
		else if(stair==n) return 1;
		for(int jump=1;jump<=jumps[stair];jump++){
			int rs1=climbStairWithJumps(stair+jump,n,jumps,0);
			result+=rs1;
		}
		return result;
	}
	
	public static int climbStariWithJumps(int n,int[] jumps){
		int[] dp=new int[n+1];
		dp[n]=1;
		for(int stair=n-1; stair >= 0; stair--){
			for(int jump=1;jump <= jumps[stair];jump++){
				if(stair+jump <= n){
					dp[stair]+=dp[stair+jump];
					//System.out.println(dp[stair]);
				}
			}
		}
		return dp[0];
	}
}