public class ClimbStairsDP{

	public static void main(String[] args){
		int n=100;
		int[] cache=new int[n+1];
		System.out.println(countPath(n));
	}
	
	public static int numberOfStep(int n,int[] cache){
		if(n<0) return 0;
		else if(n==0) return 1;
		else if(cache[n]>0) return cache[n];
		System.out.println("Hello World "+n);
		int res1=numberOfStep(n-1,cache);
		int res2=numberOfStep(n-2,cache);
		int res3=numberOfStep(n-3,cache);
		int result=res1+res2+res3;;
		cache[n]=res1+res2+res3;
		return result;
	}
	
	public static int countPath(int n){
		int[] dp=new int[n+1];
		dp[0]=1;
		for(int i=1;i<=n;i++){
			if(i==1){
				dp[i]=dp[i-1];
			}
			else if(i==2){
				dp[i]=dp[i-2];
			}else{
				dp[i]=dp[i-1]+dp[i-2]+dp[i-3];
			}
		}
		return dp[n];
	}

}