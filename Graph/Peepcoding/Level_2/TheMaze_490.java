public class TheMaze_490{
	
	public static void main(String[] args){
		/* int[][] maze={{0,0,1,0,0},{0,0,0,0,0},{0,0,0,1,0},{1,1,0,1,1},{0,0,0,0,0}};
		int[] start={0,4};
		int[] destination={4,4}; */
		/* int[][] maze={{0,0,1,0,0},{0,0,0,0,0},{0,0,0,1,0},{1,1,0,1,1},{0,0,0,0,0}};
		int[] start={0,4};
		int[] destination={3,2}; */
		/* int[][] maze={{0,0,0,0,0},{1,1,0,0,1},{0,0,0,0,0},{0,1,0,0,1},{0,1,0,0,0}};
		int[] start={4,3};
		int[] destination={0,1}; */
		int[][] maze={{0,0,1,0,0},{0,0,0,0,0},{0,0,0,1,0},{1,1,0,1,1},{0,0,0,0,0}};
		int[] start={0,4};
		int[] destination={4,4};
		boolean[][] visited=new boolean[maze.length][maze[0].length];
		System.out.println(dfs(maze,start[0],start[1],destination,visited));
	}
	
	public static int[][] destinations={{1,0},{-1,0},{0,1},{0,-1}};
	
	public static boolean dfs(int[][] maze,int row,int col,
		int[] dest,boolean[][] visited){
		if(visited[row][col]==true) return false;
		if(row==dest[0] && col==dest[1]){
			return true;
		}
		visited[row][col]=true;
		for(int[] destination:destinations){
			int neighbour_row=row;
			int neighbour_col=col;
			while(neighbour_row+destination[0] >=0 && neighbour_col+destination[1] >=0 
			&& neighbour_row+destination[0] < maze.length 
			&& neighbour_col+destination[1] < maze[0].length 
			&& maze[neighbour_row+destination[0]][neighbour_col+destination[1]]!=1){
				neighbour_row+=destination[0];
				neighbour_col+=destination[1];
			}
			boolean result=dfs(maze,neighbour_row,neighbour_col,dest,visited);
			if(result==true) return true;
		}
		return false;
	}

}