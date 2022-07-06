import java.util.*;
public class ZeroOneKnapsack {
	
	public static void main(String[] args){
		int[] val={15,14,10,45,30};
		int[] weights={2,5,1,3,4};
		int maxWieght=7;
		Integer[][] memo=new Integer[weights.length][maxWieght+1];
		System.out.println(zeroOneKnapsaceMemo(weights,weights.length-1,val,maxWieght,memo));
	}
	
	//Recursive 
	public static int zeroOneKnapsace(int[] weight,int idx,int[] val,int maxWieght){
		if(idx == 0 && weight[0] <= maxWieght){
			return val[idx];
		}
		else if(idx == 0 && weight[0] > maxWieght) {
			return 0;
		}
		int result1=zeroOneKnapsace(weight,idx-1,val,maxWieght);
		int result2=Integer.MIN_VALUE;
		if(maxWieght-weight[idx] >= 0){
			result2=val[idx]+zeroOneKnapsace(weight,idx-1,val,maxWieght-weight[idx]);
		}
		System.out.println(result1+" -- "+result2);
		return Math.max(result1,result2);
	}
	
	//Memoization
	public static int zeroOneKnapsaceMemo(int[] weight,int idx,int[] val,int maxWieght,
		Integer[][] cache){
		if(idx == 0 && weight[0] <= maxWieght){
			return val[idx];
		}
		else if(idx == 0 && weight[0] > maxWieght) {
			return 0;
		}
		if(cache[idx][maxWieght]!=null){
			return cache[idx][maxWieght];
		}
		
		int result1=zeroOneKnapsaceMemo(weight,idx-1,val,maxWieght,cache);
		int result2=Integer.MIN_VALUE;
		if(maxWieght-weight[idx] >= 0){
			result2=val[idx]+zeroOneKnapsaceMemo(weight,idx-1,val,maxWieght-weight[idx],cache);
		}
		cache[idx][maxWieght]=Math.max(result1,result2);
		//System.out.println(result1+" -- "+result2);
		return Math.max(result1,result2);
	}
	
	//Dynamic Programming 
	public static int zeroOneKnapsaceDP(int[] arr,int[] val,int wt){
		int[][] dp=new int[arr.length][wt+1];
		for(int row=0; row < arr.length; row++){
			for(int col=0;col<=wt;col++){
				if(row==0 && arr[0] <= col){
					dp[row][col]=val[row];
				}
				else if(row== 0 && arr[0] > col) {
					dp[row][col]=0;
				}
				else {
					int result1=dp[row-1][col];
					int result2=Integer.MIN_VALUE;
					if(col-arr[row] >= 0){
						result2=val[row]+dp[row-1][col-arr[row]];
					}
					dp[row][col]=Math.max(result1,result2);
				}
			}
		}
		//print the array
		for(int row=0;row < arr.length; row++){
			System.out.println(Arrays.toString(dp[row]));
		}
		return dp[arr.length-1][wt];
	}
}