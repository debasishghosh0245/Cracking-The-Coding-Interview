import java.util.*;
public class RottingOranges_994{
	
	public static void main(String[] args){
		//int[][] grid ={{2,1,1},{1,1,0},{0,1,1}};
		int[][] grid ={{2,1,1},{1,1,0},{0,1,1}};
		//int[][] grid={{2,1,1},{0,1,1},{1,0,1}};
		System.out.println("time "+orangesRottingBFS(grid));
	}
	
	public static class Pair{
		int row;
		int col;
		Pair(int row,int col){
			this.row=row;
			this.col=col;
		}
	}
	
	static int[][] directions={{-1,0},{1,0},{0,1},{0,-1}};
	public static int orangesRottingBFS(int[][] grid) {
		Queue<Pair> queue=new ArrayDeque<>();
		int freshOranges=0;
		int ROWS = grid.length, COLS = grid[0].length;
		for(int row=0;row<grid.length;row++){
			for(int col=0;col<grid[0].length;col++){
				if(grid[row][col]==2){
					queue.add(new Pair(row,col));
				}else if(grid[row][col]==1){
					freshOranges++;
				}
			}
		}	
		if(freshOranges==0) return 0;
		int time=-1;
		int size=queue.size();
		while(!queue.isEmpty()){
			size=queue.size();
			while(size-->0) {
				Pair pair=queue.remove();
				for(int[] direction: directions){
					int neighbourRow=pair.row+direction[0];
					int neighbourCol=pair.col+direction[1];
					if(neighbourRow >=0 && neighbourCol >=0
						&& neighbourRow < ROWS 
						&& neighbourCol < COLS
						&& grid[neighbourRow][neighbourCol]==1){
							queue.offer(new Pair(neighbourRow,neighbourCol));
							freshOranges--;
							grid[neighbourCol][neighbourRow]=2;
					}
				}
			}
			time++;
		}
		if(freshOranges==0) return time;
		else return -1;
    }
}