import java.util.*;
public class UniquePaths_62 {
	
	public static int[][] directions={{0,1},{1,0}};
	public static int cntPath=0;
	
	public static void main(String[] args){
		int m = 3;
		int n = 3 ;
		System.out.println("Unique Paths >> "+uniquePathsRec(0,0,m,n));
		Integer[][] memo=new Integer[m][n];
		System.out.println(uniquePathsMemo(0,0,m,n,memo));
	}
	
	//Approach1: Recurssive Bruteforce 
	//Time Complexity  :O(2^(m+n))
	//Space Complexity :O(m+n)
	public static int uniquePathsRec(int row,int col,int m,int n) {
		if(row < 0 || col <0 || row >= m || col >= n) return 0;
		if(row==m-1 && col==n-1){
			return 1;
		}
		int path=0;
		for(int[] direction: directions){
			int nbrRow=row+direction[0];
			int nbrCol=col+direction[1];			
			path+=uniquePathsRec(nbrRow,nbrCol,m,n);
		}
		return path;
    }
	
	//Apprache : Memoization or Top-Down
	//Time Complexity : O(m
	//Space Complexity :
	public static int uniquePathsMemo(int row,int col,int m,int n,
		Integer[][] memo) {
		if(row < 0 || col <0 || row >= m || col >= n) return 0;
		if(row==m-1 && col==n-1){
			return 1;
		}
		System.out.println("row >> "+row+" col >> "+col);
		if(memo[row][col]!=null){
			return memo[row][col];
		}
		int path=0;
		for(int[] direction: directions){
			int nbrRow=row+direction[0];
			int nbrCol=col+direction[1];			
			path+=uniquePathsMemo(nbrRow,nbrCol,m,n,memo);
			//if(nbrRow < 0 || nbrCol <0 || nbrRow >= m || nbrCol >= n) continue;
			//
		}
		memo[row][col]=path;
		return path;
    }
	
	//Dynamic Programming 
	//Time Complexity  :
	//Space Complexity :
	public static int uniquePaths(int m,int n) {
		int[][] dp=new int[m][n];
		//dp[m-1][n-1]=1;
		for(int row=m-1;row>=0;row--){
			for(int col=n-1;col>=0;col--){
				//for last row
				if(col==n-1){
					dp[row][col]=1;
				}
				else if(row==m-1){
					dp[row][col]=1;
				}
				else{
					dp[row][col]=dp[row+1][col]+dp[row][col+1];
				}
			}
		}
		for(int row=0;row<m;row++){
			System.out.println(Arrays.toString(dp[row]));
		}
		return dp[0][0];
    }
}