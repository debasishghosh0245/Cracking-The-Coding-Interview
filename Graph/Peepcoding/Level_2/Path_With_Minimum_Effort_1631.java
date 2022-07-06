import java.util.*;
public class Path_With_Minimum_Effort_1631{

	public static void main(String[] args){
		//int[][] heights ={{1,2,2},{3,8,2},{5,3,5}};
		//int[][] heights ={{1,2,3},{3,8,4},{5,3,5}};
		int[][] heights={{1,2,1,1,1},{1,2,1,2,1},{1,2,1,2,1},{1,2,1,2,1},{1,1,1,2,1}};
		System.out.println(dijkstraSortestPath(heights));
	}
	
	static int[][] directions={{-1,0},{1,0},{0,1},{0,-1}};
	
	public static class Pair implements Comparable<Pair> {
		int row;
		int col;
		int height;
		
		Pair(int row,int col,int height){
			this.row=row;
			this.col=col;
			this.height=height;
		}
		
		public int compareTo(Pair pair){
			return this.height-pair.height;
		}
	}
	
	
	public static int dijkstraSortestPath(int[][] heights){
		PriorityQueue<Pair> minHeap=new PriorityQueue<>();
		minHeap.add(new Pair(0,0,0));
		int result=Integer.MIN_VALUE;
		boolean[][] visited=new boolean[heights.length][heights[0].length];
		while(!minHeap.isEmpty()){
			Pair pair=minHeap.remove();
			System.out.println(pair.height);
			result=Math.max(result,pair.height);
			if(pair.row==heights.length-1 && pair.col==heights[0].length-1) break;
			if(visited[pair.row][pair.col]==true){
				continue;
			}else{
				visited[pair.row][pair.col]=true;
			}
			for(int[] direction:directions){
				int neighbour_row=pair.row+direction[0];
				int neighbour_col=pair.col+direction[1];
				if(neighbour_row < 0 || neighbour_col < 0 || neighbour_row >= heights.length || 	neighbour_col >= heights[0].length || visited[neighbour_row][neighbour_col]==true){
					continue;
				}
				int adsHeight=Math.abs(heights[pair.row][pair.col]-heights[neighbour_row][neighbour_col]);
				minHeap.offer(new Pair(neighbour_row,neighbour_col,adsHeight));
			}
		}
		return result;
	}
}