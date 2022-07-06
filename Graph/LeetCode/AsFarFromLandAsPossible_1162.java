import java.util.*;
public class AsFarFromLandAsPossible_1162{
	
	public static void main(String[] args){
		//int[][] grid={{1,0,1},{0,0,0},{1,0,1}};
		int[][] grid={{1,0,0},{0,0,0},{0,0,0}};
		boolean[][] visited=new boolean[grid.length][grid[0].length];
		maxDistanceDFS(grid,0,0,1,visited);
		/* int maxdist=maxDistanceBFS(grid);
		System.out.println("Max idst >> "+maxdist); */
		
		for(int i=0;i<grid.length;i++){
			for(int j=0;j<grid[i].length;j++){
				System.out.print(grid[i][j]);
			}
			System.out.println(" ");
		} 
		
	}
	
	public static class Pair{
		int row=0;
		int col=0;
		int dist=0;
		Pair(int row,int col,int dist){
			this.row=row;
			this.col=col;
			this.dist=dist;
		}
		
		public String toString(){
			return " row "+this.row+" col "+this.col+" dist "+this.dist;
		}
		
	}
	
	static int[][] distances={{-1,0},{1,0},{0,1},{0,-1}};
	public static int maxDistanceBFS(int[][] grid) {
		int maximumDist=0;
		int water=0;
		Queue<Pair> queue=new ArrayDeque<>();
		for(int i=0;i<grid.length;i++){
			for(int j=0;j<grid[i].length;j++){
				if(grid[i][j]==1){
					queue.offer(new Pair(i,j,0));
				}else{
					water++;
				}
			}
		}
		if(water==0) return -1;
        if(queue.isEmpty()) return -1;
		int level=0;
		while(!queue.isEmpty()){
			level=queue.size();
			while(level-->0){
				Pair pair=queue.poll();
				for(int[] distance: distances){
					int neighbourRow=pair.row+distance[0];
					int neighbourCol=pair.col+distance[1];
					if(neighbourRow < 0 || neighbourCol < 0 
					|| neighbourRow >= grid.length || neighbourCol >= grid[0].length
					|| grid[neighbourRow][neighbourCol]!=0){
						continue;
					}
					else{
						int currdist=pair.dist+1;
						maximumDist=Math.max(currdist,maximumDist);
						grid[neighbourRow][neighbourCol]=currdist;
						queue.add(new Pair(neighbourRow,neighbourCol,currdist));
					}
				}
			}
		}
		return maximumDist;
	}
	
	
	public static void maxDistanceDFS(int[][] grid,int row,int col,int dist,boolean[][] visited){
		if(row < 0 || col < 0 || row >= grid.length || col >= grid[row].length 
		|| visited[row][col]==true ) return;
		grid[row][col]=dist;
		visited[row][col]=true;
		for(int[] distance : distances){
			int neighbourRow=row+distance[0];
			int neighbourCol=col+distance[1];
			maxDistanceDFS(grid,neighbourRow,neighbourCol,dist+1,visited);
		}
		
	}
	
}