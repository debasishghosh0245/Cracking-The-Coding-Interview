public class ColoringABorder_1034 {
	
	public static void main(String[] args){
		int[][] grid={{1,2,2},{2,3,2}};
		int row=0; int col=1; 
		int color=3;
		//boolean[][] visited=new boolean[grid.length][grid[0].length];
		colorBoarderDFS(grid,row,col,grid[row][col]);
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[0].length;j++) {
				if(grid[i][j] < 0 ) {
				   grid[i][j]=color;	
				}
			}
		}
		for(int i=0;i<grid.length;i++){
			for(int j=0;j<grid[0].length;j++){
				System.out.print(grid[i][j]);
			}
			System.out.println(" ");
		}
	}
	
	public static void colorBoarderDFS(int[][] grid,
		int row,int col,int currCell){
		if(row<0 || col<0 || row >=grid.length ||
		col >= grid[row].length 
		|| grid[row][col]!=currCell) return;
		//visited[row][col]=true;
		grid[row][col]=-currCell;
		colorBoarderDFS(grid,row+1,col,currCell);
		colorBoarderDFS(grid,row-1,col,currCell);
		colorBoarderDFS(grid,row,col+1,currCell);
		colorBoarderDFS(grid,row,col-1,currCell);
		
		//uncolord the unbouned cell
		if(row > 0 && row < grid.length-1 && col > 0 && col < grid[row].length-1 
			&& currCell==Math.abs(grid[row+1][col]) 
			&& currCell==Math.abs(grid[row-1][col]) 
			&& currCell==Math.abs(grid[row][col+1])
			&& currCell==Math.abs(grid[row][col-1])){
				grid[row][col]=currCell;
		}
	}
}