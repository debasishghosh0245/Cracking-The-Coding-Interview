import java.util.*;
public class   {

	static int[][] directions={{1,-1},{1,0},{1,1}};
	static int result=Integer.MAX_VALUE;
	
	public static void main(String[] args){
		int[][] matrix ={{2,1,3},{6,5,4},{7,8,9}};
		//minFallingPathDijkstra(matrix,0,1);
		minimumFallingPath(matrix);
		System.out.println("Result >> "+result); 
		//System.out.println("Result >>"+minFallingPathSum(matrix));
	}
	
	// Approach 1 : DP 
	public static int minFallingPathSum(int[][] matrix) {
		int result=Integer.MAX_VALUE;
        int[][] dp=new int[matrix.length][matrix[0].length]; 
		for(int row=matrix.length-1;row>=0;row--){
			for(int col=matrix[0].length-1;col>=0;col--){
				int min=Integer.MAX_VALUE;
				//for the down most row
				if(row==matrix.length-1) {
					dp[row][col]=matrix[row][col];
				}	
				//for the right most column
				else if(col==matrix[0].length-1) {
					min=Math.min(dp[row+1][col],min);
					min=Math.min(min,dp[row+1][col-1]);
					dp[row][col]=min+matrix[row][col];
				}
				//for the left most column 
				else if(col==0){
					min=Math.min(dp[row+1][col],min);
					min=Math.min(min,dp[row+1][col+1]);
					dp[row][col]=min+matrix[row][col];
				}
				// for others
				else{
					min=Math.min(dp[row+1][col],min);
					min=Math.min(min,dp[row+1][col+1]);
					min=Math.min(min,dp[row+1][col-1]);
					dp[row][col]=min+matrix[row][col];
				}
			}
		}
		for(int i=0;i<matrix[0].length;i++){
			result=Math.min(dp[0][i],result);
		}
		return result;
    }

	//Approach 2 : DFS + Memoziation
	public static void minimumFallingPath(int[][] matrix){
		Integer[][] cache=new Integer[matrix.length][matrix[0].length];
		for(int col=0;col<matrix[0].length;col++){
			dfs(matrix,0,1,1,cache);
		}
	}
	
	public static void dfs(int[][] matrix,int row,int col,
		int sum,Integer[][] cache){
		if(row < 0 || row >= matrix.length || 
		col < 0 || col >=matrix[0].length) return;
		else if(row==matrix.length-1){
			result=Math.min(sum,result);
			return;
		}
		if(cache[row][col]!=null){
			sum=cache[row][col];
			return;
		}else{
			cache[row][col]=sum;
		}
		System.out.println("row >> "+row+" col>> "+col);
		for(int[] direction: directions){
			int nbrRow=row+direction[0];
			int nbrCol=col+direction[1];
			if(nbrRow < 0 || nbrRow >= matrix.length || nbrCol < 0 
				|| nbrCol >=matrix[0].length) {
				continue;
			}
			sum=sum+matrix[nbrRow][nbrCol];
			dfs(matrix,nbrRow,nbrCol,sum,cache);
			sum=sum-matrix[nbrRow][nbrCol];
		}
	}


	public static class Pair implements Comparable<Pair>{
		int row;
		int col;
		int weight;
		Pair(int row,int col,int weight){
			this.row=row;
			this.col=col;
			this.weight=weight;
		}
		public int compareTo(Pair pair){
			return this.weight-pair.weight;
		}
		
		public String toString(){
			return "row "+this.row+" col "+this.col+" weight "+this.weight;
		}
	}
	
	//Apprach 3 : Dijkstra Alog  ( Greedy not make sense )
	public static void minFallingPathDijkstra(int[][] matrix,int srcRow,int srcCol){
		PriorityQueue<Pair> maxHeap=new PriorityQueue<>(Collections.reverseOrder());
		maxHeap.add(new Pair(srcRow,srcCol,matrix[srcRow][srcCol]));
		while(!maxHeap.isEmpty()){
			Pair pair=maxHeap.poll();	
			System.out.println(" row "+pair.row+" col "+pair.col+" Weight >> "+pair.weight);
			if (pair.row==matrix.length-1) {
				//base case 
			}			
			for(int[] direction : directions){
				int nbrRow=pair.row+direction[0];
				int nbrCol=pair.col+direction[1];
				if(nbrRow < 0 || nbrRow >= matrix.length || nbrCol < 0 
				|| nbrCol >=matrix[0].length) {
					continue;
				}
				int weight=pair.weight+matrix[nbrRow][nbrCol];
				maxHeap.add(new Pair(nbrRow,nbrCol,weight));
			}
		}
		System.out.println(maxHeap);
	}
	
}