import java.util.*;
public class NegativeWeightCycleDetection{
	
	public static void main(String[] args){
		int[][] adjList={{0,1,-1},{1,2,-4},{2,0,3}};
		int vertices=3;
		System.out.println(bellmanFord(adjList,vertices));
	}
		
	public static boolean bellmanFord(int[][] ajdList,int vertices){
		int[] dist=new int[vertices];
		Arrays.fill(dist,Integer.MAX_VALUE);
		dist[0]=0;
		for(int[] arr: ajdList){
			int u=arr[0];
			int v=arr[1];
			int wt=arr[2];
			if(dist[u]==Integer.MAX_VALUE) {
				continue;
			}
			if(dist[u]+wt < dist[v]){
				dist[v]=dist[u]+wt;
			}	
		}
		
		for(int[] arr: ajdList){
			int u=arr[0];
			int v=arr[1];
			int wt=arr[2];
			if(dist[u]+wt < dist[v]){
				return true;
			}	
		}
		return false;
	}
}