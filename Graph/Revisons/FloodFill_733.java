import java.util.*;
public class FloodFill_733{

	public static void main(String[] abc){
		/* int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
		int sr=1; int sc=1; int color=2;   */
		
		/* int[][] image={{0,0,0},{0,0,0}};
		int sr=0; int sc=0; int color=2;  */
		
		/* int[][] image={{0,0,0},{0,1,0}};
		int sr=1;int sc=1;int color=2; */
		
		boolean[][] visited=new boolean[image.length][image[0].length];
		int[][] result=floodFill_recursive(image,sr,sc,color,image[sr][sc],visited);
		
		for(int[] arr: result){
			System.out.println(Arrays.toString(arr));
		}
		
	}
	
	static int[][] directions={{1,0},{-1,0},{0,1},{0,-1}};
	
	public static int[][] floodFill_recursive(int[][] matrix,int row,int col,int color,
		int strPixel,boolean[][] visited){
		
		if(row < 0 || col < 0 || row >= matrix.length || col >= matrix[row].length) return matrix;
		matrix[row][col]=color;
		visited[row][col]=true;
		
		for(int[] direction: directions){
			
			int next_row=row+direction[0];
			int next_col=col+direction[1];
			
			if(next_row < 0 || next_col < 0 || next_row >= matrix.length 
			|| next_col >= matrix[row].length || matrix[next_row][next_col]!=strPixel 
			|| visited[next_row][next_col]==true) continue;

			floodFill_recursive(matrix,next_row,next_col,color,strPixel,visited);
		}
		
		return matrix;
	}
}