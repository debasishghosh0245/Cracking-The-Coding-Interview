public class NumberOfEnclaves_1020{

	public static void main(String[] args){
		int[][] grid ={{0,0,0,0},{1,0,1,0},{0,1,1,0},{0,0,0,0}};
		boolean[][] visited=new boolean[grid.length][grid[0].length];
		int result=0;
		//top broder
		for(int row=0;row<grid.length;row++){
			for(int col=0;col<grid[0].length;col++){
				if(row*col==0 || row==grid.length-1 || col==grid.length-1){
					if(grid[row][col]==1){
						numEnclavesDFS(grid,visited,row,col);
					}
				}
			}
		}
		
		for(int i=0;i<grid.length;i++){
			for(int j=0;j<grid[i].length;j++){
				if(grid[i][j]==1) {
					result++;
				}
			}
		}
		System.out.println("Result >> "+result);
	}
	
	public static void numEnclavesDFS(int[][] grid,boolean[][] visited,
		int row,int col) {
		if(row < 0 ||  col < 0 || row >= grid.length 
		|| col >=grid[row].length || visited[row][col]==true 
		|| grid[row][col]==0) return;
		visited[row][col]=true;
		grid[row][col]=0;
		numEnclavesDFS(grid,visited,row+1,col);
		numEnclavesDFS(grid,visited,row-1,col);
		numEnclavesDFS(grid,visited,row,col+1);
		numEnclavesDFS(grid,visited,row,col-1);
    }

}