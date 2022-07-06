import java.util.*;
public class TheMazeII_505{
	
	static int[][] directions={{1,0},{-1,0},{0,1},{0,-1}};
	
	public static void main(String[] args){
		int[][] maze={{0,0,0,0,0},{0,0,0,0,0},{0,0,0,1,0},{1,1,0,1,1},{0,0,0,0,0}};
		int[] start={0,4};
		int[] dest={4,4};
		int result=shortestDistance(maze,start[0],start[1],dest[0],dest[1]);
		System.out.println(result);
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
			return "row >> "+row+" col >> "+col;
		}
	}
	
	public static int shortestDistance(int[][] maze,int srcRow,int srcCol,
		int destRow,int destCol){
		boolean[][] visited=new boolean[maze.length][maze[0].length];
		PriorityQueue<Pair> minHeap=new PriorityQueue<>();
		minHeap.add(new Pair(srcRow,srcCol,0));
		visited[srcRow][srcCol]=true;
		while(!minHeap.isEmpty()){
			Pair pair=minHeap.poll();
			if(pair.row==destRow && pair.col==destCol) return pair.weight;
			for(int[] direction: directions){
				int nbrRow=pair.row;
				int nbrCol=pair.col;
				int weight=pair.weight;
				while (nbrRow+direction[0] >=0 
					&& nbrCol+direction[1] >=0 
					&& nbrRow+direction[0] < maze.length 
					&& nbrCol+direction[1] < maze[0].length 
					&& maze[nbrRow+direction[0]][nbrCol+direction[1]]==0){
						nbrRow+=direction[0];
						nbrCol+=direction[1];
						weight++;
				}
				if(visited[nbrRow][nbrCol]==false){
					minHeap.offer(new Pair(nbrRow,nbrCol,weight));
					visited[nbrRow][nbrCol]=true;
				}
			}
		}	
		return -1;
	}
}