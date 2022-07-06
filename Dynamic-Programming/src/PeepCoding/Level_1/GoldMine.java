public class GoldMine {
	
	static int maxGoldMined=0;
	
	public static void main(String[] args){
		int[][] grid={{0,1,4,2,8},{4,3,6,5,0},{1,2,4,1,4}};
		//System.out.println(goldMineDP(grid));
		for(int i=0;i<grid.length;i++){
			goldMineRecursionDFS(grid,0,i,0);
		}
		System.out.println(maxGoldMined);
	}
	
	public static int goldMineDP(int[][] grid) {
		int[][] dp=new int[grid.length][grid[0].length];
		for(int col=grid[0].length-1;col>=0;col--){
			for(int row=grid.length-1;row>=0;row--){
				if(col==grid[0].length-1){
					dp[row][col]=grid[row][col];
				}
				else if(row==0){
					dp[row][col]=grid[row][col]+Math.max(dp[row][col+1],dp[row+1][col+1]);
				}
				else if(row==grid.length-1){
					dp[row][col]=grid[row][col]+Math.max(dp[row][col+1],dp[row-1][col+1]);
				}
				else{
					int max=Math.max(dp[row+1][col+1],dp[row-1][col+1]);
					dp[row][col]=grid[row][col]+Math.max(dp[row][col+1],max);
				}
			}
		}
		//print the grid
		int max=0;
		for(int[] arr : dp){
			max=Math.max(max,arr[0]);
		}
		return max;
	}
	
	static int[][] directions={{0,1},{-1,1},{1,1}};
	public static void goldMineRecursionDFS(int[][] grid,int cost,int row,int col){
		if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length) return;
		cost=cost+grid[row][col];
		if(col==grid[0].length-1){
			maxGoldMined=Math.max(maxGoldMined,cost);
			return;
		}
		for(int[] direction : directions){
			int nbrRow=row+direction[0];
			int nbrCol=col+direction[1];
			goldMineRecursionDFS(grid,cost,nbrRow,nbrCol);
		}
		cost=cost-grid[row][col];
	}
}