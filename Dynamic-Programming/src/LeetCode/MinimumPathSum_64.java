public class MinimumPathSum_64{
	
	public static int[][] directions={{1,0},{0,1}};
	public static int minCost=Integer.MAX_VALUE;
	public static void main(String[] args){
		int[][] maze={{1,3,1},{1,5,1},{4,2,1}};
		//int[][] maze={{0,1,4},{4,3,6},{1,2,4}};
		//int[][] maze ={{1,2,3},{4,5,6}};
		Integer[][] cache=new Integer[maze.length][maze[0].length];
		//minCostInMaze(maze,maze[0][0],0,0,"",cache);
		System.out.println("Min Cost >> "+minCostInMazeMemo(maze,0,0,cache));
	}
	
	//Appraoch 1: Recurssive
	//Time Complexity  : O( 2 ^ (m*n))
	//Space Complexity : O((m-1)+(n-1)
	public static int minCostInMazeRec(int[][] maze,int row,int col){
		if(row < 0 || col < 0 || row >= maze.length 
			|| col >= maze[0].length){
			return Integer.MAX_VALUE;
		} 
		if(row==maze.length-1 && col==maze[0].length-1){
			return maze[maze.length-1][maze[0].length-1];
		}
		int minCost=Integer.MAX_VALUE;
		for(int[] direction: directions){
			int nextRow=row+direction[0];
			int nextCol=col+direction[1];
			int cost=minCostInMazeRec(maze,nextRow,nextCol);
			minCost=Math.min(cost,minCost);
		}
		minCost+=maze[row][col];
		return minCost;
	}
	
	//Approach 2 : Memoization 
	//Time Complexity  : O((m*n))
	//Space Complexity : O((m-1)+(n-1)+(m*n))
	public static int minCostInMazeMemo(int[][] maze,int row,int col,Integer[][] cache){
		if(row < 0 || col < 0 || row >= maze.length 
			|| col >= maze[0].length){
			return Integer.MAX_VALUE;
		} 
		
		if(row==maze.length-1 && col==maze[0].length-1){
			return maze[maze.length-1][maze[0].length-1];
		}
		
		if(cache[row][col]!=null) return cache[row][col];
		
		int minCost=Integer.MAX_VALUE;
		for(int[] direction: directions){
			int nextRow=row+direction[0];
			int nextCol=col+direction[1];
			int cost=minCostInMazeMemo(maze,nextRow,nextCol,cache);
			minCost=Math.min(cost,minCost);
		}
		minCost+=maze[row][col];
		cache[row][col]=minCost;
		return minCost;
	}
	
	
	//Apprache 3 :Dynamic Programming
	//Time Complexity  : O((m*n))
	//Space Complexity : O((m*n))
	public static int minCostInMaze(int[][] maze){
		int[][] dp=new int[maze.length][maze[0].length];
		for(int row=maze.length-1; row >=0 ;row--){
			for(int col=maze[0].length-1; col >=0 ; col--){
				if(row==maze.length-1 && col==maze[0].length-1){
					dp[row][col]=maze[row][col];
				}else if(row==maze.length-1){
					dp[row][col]=maze[row][col]+dp[row][col+1];
				}
				else if(col==maze[0].length-1){
					dp[row][col]=maze[row][col]+dp[row+1][col];
				}
				else{
					dp[row][col]=Math.min(dp[row][col+1],dp[row+1][col])+maze[row][col];
				}
			}
		}
		return dp[0][0];
	}
}