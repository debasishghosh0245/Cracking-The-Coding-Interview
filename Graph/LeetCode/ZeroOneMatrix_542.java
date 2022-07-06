import java.util.*;
public class ZeroOneMatrix_542 {
	
	public static void main(String[] args){
		//int[][] matrix={{0,0,0},{0,1,0},{1,1,1}};
		int[][] matrix = {{0,0,0},{0,1,0},{0,0,0}};
		updateMatrixBFS(matrix);
		for(int row=0;row<matrix.length;row++){
			for(int col=0;col<matrix[row].length;col++){
				System.out.print(matrix[row][col]);
			}
			System.out.println("");
		}
		
	}
	
	public static class Pair{
		int row;
		int col;
		Pair(int row,int col){
			this.row=row;
			this.col=col;
		}
	}
	
	static int[][] directions={{1,0},{-1,0},{0,1},{0,-1}};
	public static void updateMatrixBFS(int[][] matrix){
		Queue<Pair> queue=new ArrayDeque<>();
		for(int row=0;row<matrix.length;row++){
			for(int col=0;col<matrix[row].length;col++){
				if(matrix[row][col]==1){
					matrix[row][col]=-1;
				}else{
					queue.offer(new Pair(row,col));
				}
			}
		}
		
		int level=1;
		int size=queue.size();
		while(!queue.isEmpty()){
			size=queue.size();
			while(size-->0){
				Pair pair=queue.poll();
				for(int[] direction : directions){
					int neighbourRow=pair.row+direction[0];
					int neighbourCol=pair.col+direction[1];
					if(neighbourRow < 0 || neighbourCol < 0 || neighbourRow >= matrix.length 
					|| neighbourCol >= matrix[0].length 
					|| matrix[neighbourRow][neighbourCol]!=-1){
						continue;
					}else{
						matrix[neighbourRow][neighbourCol]=level;
						queue.offer(new Pair(neighbourRow,neighbourCol));
					}
				}
			}
			level++;
		}
	}
}