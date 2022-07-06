public class UniquePathsII_63{
	
	public static void main(String[] args){
		//int[][] obstacleGrid={{0,0,0},{0,1,0},{0,0,0}};
		//int[][] obstacleGrid={{0,1},{0,0}};
		//int[][] obstacleGrid={{0,0},{0,1}};
		int[][] obstacleGrid={{0,0},{1,1},{0,0}};
		Integer[][] memo=new Integer[obstacleGrid.length][obstacleGrid[0].length];
		System.out.println("Unique Paths >> "+uniquePathsMemo(obstacleGrid,0,0,memo));
	}
	
	private static int[][] directions={{0,1},{1,0}};
	
	//Appraoch1 :Recursion 
	//Time Complexity :
	//Space Complexity :
	private static int uniquePathsRec(int[][] grid,int row,int col){
		if(row < 0 || col < 0  || row >=grid.length || col >=grid[0].length
		|| grid[row][col]==1) return 0;
		if(row==grid.length-1 && col==grid[0].length-1){
			return 1;
		}
		int path=0;
		for(int[] direction: directions){
			int nbrRow=row+direction[0];
			int nbrCol=col+direction[1];			
			path+=uniquePathsRec(grid,nbrRow,nbrCol);
		}
		return path;
	}
	
	//Apprache : Memoization or Top-Down
	//Time Complexity  : 
	//Space Complexity :
	public static int uniquePathsMemo(int[][] grid,int row,int col,Integer[][] memo) {
		if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length 
		|| grid[row][col]==1) return 0;
		if(row==grid.length-1 && col==grid[0].length-1){
			return 1;
		}
		//System.out.println("row >> "+row+" col >> "+col);
		if(memo[row][col]!=null){
			return memo[row][col];
		}
		int path=0;
		for(int[] direction: directions){
			int nextRow=row+direction[0];
			int nextCol=col+direction[1];			
			path+=uniquePathsMemo(grid,nextRow,nextCol,memo);
		}
		memo[row][col]=path;
		return path;
    }
	
	//Approache 3 : DP
	public static int uniquePaths(int[][] grid) {
		int[][] dp=new int[grid.length][grid[0].length];
		for(int row=dp.length-1;row>=0;row--){
			for(int col=dp[row].length-1;col>=0;col--){
				// for the bottom cell
				if(row==dp.length-1 && col==dp[row].length-1){
					if(grid[row][col]==1){
						return 0;
					}else{
						dp[row][col]=1;
					}
				}
				// for the bottom row
				else if(row==dp.length-1) {
					if(grid[row][col]==0){
						dp[row][col]=dp[row][col+1];
					}else {
						dp[row][col]=0;
					}
				}
				// for right most column 
				else if(col==dp[row].length-1) {
					if(grid[row][col]==0){
						dp[row][col]=dp[row+1][col];
					}else {
						dp[row][col]=0;
					}
				}
				//for rest one 
				else {
					if(grid[row][col]==1){
						dp[row][col]=0;
					}else{
						dp[row][col]=dp[row+1][col]+dp[row][col+1];
					}
				}
			}
		}
		return dp[0][0];
    }
}