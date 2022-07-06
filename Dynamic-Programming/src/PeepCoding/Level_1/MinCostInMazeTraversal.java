public class MinCostInMazeTraversal{

	public static int[][] directions={{1,0},{0,1}};
	public static void main(String[] args){
		int[][] maze={{0,1,4},{4,3,6},{1,2,4}};
		System.out.println(minCostInMaze(maze));
	}
		
	public static void minCostInMaze(int[][] maze,int cost,int row,
		int col,String path){
		if(row==maze.length-1 && col==maze[0].length-1){
			System.out.println("Cost >>" +cost+" path >> "+path);
		}
		for(int[] direction: directions){
			int nbrRow=row+direction[0];
			int nbrCol=col+direction[1];
			if(nbrRow < 0 || nbrCol < 0 || nbrRow >= maze.length 
				|| nbrCol >= maze[0].length){
				continue;
			} 
			cost+=maze[nbrRow][nbrCol];
			minCostInMaze(maze,cost,nbrRow,nbrCol,path+maze[nbrRow][nbrCol]);
			cost-=maze[nbrRow][nbrCol];
		}
	}
	
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