public class NumberOfIslands_200 {
	
	public static void main(String[] args){
		/* int[][] matrix={{0,0,1,1,1,1,1,1},{0,0,1,1,1,1,1,1},{1,1,1,1,1,1,1,0},
		{1,1,0,0,0,1,1,0},{1,1,1,1,0,1,1,0},{1,1,1,1,0,1,1,0},{1,1,1,1,1,1,1,0},
		{1,1,1,1,1,1,1,0}}; */
		int[][] matrix={{1,1,0,0,0},{1,1,0,0,0},
		{0,0,1,0,0},{0,0,0,1,1}};
		int count=0;
		boolean[][] visited=new boolean[matrix.length][matrix[0].length];
		for(int i=0;i<matrix.length;i++){
			for(int j=0;j<matrix[i].length;j++){
				if(matrix[i][j]==1 && visited[i][j]==false){
					countNumberOfIsland(matrix,i,j,visited);
					count++;
				}
			}
		}
		System.out.println("Number Of IsLand "+count);
	}

	public static void countNumberOfIsland(int[][] matrix,int i,int j,boolean[][] visited){
		if(i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length  ||
		matrix[i][j]==0 || visited[i][j]==true) return;
		visited[i][j]=true;
		countNumberOfIsland(matrix,i+1,j,visited);
		countNumberOfIsland(matrix,i-1,j,visited);
		countNumberOfIsland(matrix,i,j+1,visited);
		countNumberOfIsland(matrix,i,j-1,visited);
	}
	
}