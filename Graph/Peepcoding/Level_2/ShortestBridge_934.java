import java.util.*;
public class ShortestBridge_934 {

	public static void main(String[] args){
		//int[][] grid ={{0,1,0},{0,0,0},{0,0,1}};
		int[][] grid={{1,1,1,1,1},{1,0,0,0,1},{1,0,1,0,1},{1,0,0,0,1},{1,1,1,1,1}};
		boolean[][] visited=new boolean[grid.length][grid[0].length];
		Queue<Pair> queue=new ArrayDeque<>();
		boolean found=false;
		for(int i=0;i<grid.length;i++){
			for(int j=0;j<grid[i].length;j++){
				if (found) {
					break;
				}
				if(grid[i][j]==1 && visited[i][j]==false){
					found=true;
					findOneConnectedLandDFS(grid,queue,i,j,visited);
				}
			}
		}
		System.out.println(shortestBridgeBSF(grid,queue,visited));
		for(int i=0;i<grid.length;i++){
			for(int j=0;j<grid[i].length;j++){
				System.out.print(grid[i][j]);
			}
			System.out.println("");
		}
	}
	
	private static class Pair{
		int row;
		int col;
		Pair(int row,int col){
			this.row=row;
			this.col=col;
		}
		
		public String toString(){
			return " row "+this.row+" col "+this.col;
		}
	}
	
	private static int[][] directions={{-1,0},{1,0},{0,-1},{0,1}};
	// 1. dfs to find an island, mark it in `visited`
	private static void findOneConnectedLandDFS(int[][] grid,Queue queue,int row,int col,boolean[][] visited){
		if(row < 0 || col < 0 || row >= grid.length 
				|| col >= grid[row].length 
				|| visited[row][col]==true 
				|| grid[row][col]==0){
				return;
		}
		visited[row][col]=true;
		queue.offer(new Pair(row,col));
		for(int[] direction:directions){
			int neighbourRow=row+direction[0];
			int neighbourCol=col+direction[1];
			findOneConnectedLandDFS(grid,queue,neighbourRow,neighbourCol,visited);
		}
	}
	
	// 2. bfs to expand this island
	public static int shortestBridgeBSF(int[][] grid,Queue<Pair> queue,boolean[][] visited){
		int size=0;
		int level=1;
		while(!queue.isEmpty()){
			size=queue.size();
			while(size-->0){
				Pair pair=queue.remove();
				for(int[] direction : directions){
					int neighbourRow=pair.row+direction[0];
					int neighbourCol=pair.col+direction[1];
					if(neighbourRow < 0 || neighbourCol < 0 || neighbourRow >= grid.length 
						|| neighbourCol >= grid[neighbourRow].length 
						|| visited[neighbourRow][neighbourCol]==true){
						continue;
					}else{
						if(grid[neighbourRow][neighbourCol]==1) return level-1;
						grid[neighbourRow][neighbourCol]=level;
						visited[neighbourRow][neighbourCol]=true;
						queue.offer(new Pair(neighbourRow,neighbourCol));
					}
				}	
			}
			level++;
		}
		return -1;
	}

}