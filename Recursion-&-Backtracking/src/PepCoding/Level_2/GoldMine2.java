import java.util.*;
public class GoldMine2{
	
	public static int[][] directions={{1,0},{-1,0},{0,1},{0,-1}};
	public static int maxGold=0;
	public static void main(String[] args){
		//int[][] grid={{0,6,0},{5,8,7},{0,9,0}};
		//int[][] grid={{1,0,7},{2,0,6},{3,4,5},{0,3,0},{9,0,20}};
		//int[][] grid={{34,0,1,0,0,0},{0,0,2,0,1,0},{5,4,3,7,4,2},{0,0,5,0,1,4},{0,0,5,0,2,3}};
		int[][] grid={{0,1,4,2,8,2},{4,3,6,5,0,4},{1,2,4,1,4,6},
		{2,0,7,3,2,2},{3,1,5,9,2,4},{2,7,0,8,5,1}};
		boolean [][] visited=new boolean[grid.length][grid[0].length];
		for(int row=0;row<grid.length;row++){
			for(int col=0;col<grid[0].length;col++){
					if(visited[row][col]==false && grid[row][col]!=0){
						dfs(grid,row,col,0,visited);
				}
			}
		}
		System.out.println("Maximum Gold "+maxGold);
	}
		
	public static void dfs(int[][] grid,int row,int col,int gold,boolean[][] visited){
		if(row < 0 || col < 0 || row >= grid.length 
		| col >= grid[0].length || visited[row][col]==true 
			|| grid[row][col]==0){
			return;
		}
		visited[row][col]=true;
		gold+=grid[row][col];
		maxGold=Math.max(maxGold,gold);
		for(int[] direction: directions){
			int nbrRow=row+direction[0];
			int nbrCol=col+direction[1];
			dfs(grid,nbrRow,nbrCol,gold,visited);
		}
		visited[row][col]=false;
	}

}