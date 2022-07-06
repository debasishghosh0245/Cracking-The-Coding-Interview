import java.util.*;
public class BellmanFord{
	
	public static void main(String[] args){
		int[][] adjList={{1,2,5},{1,3,2},{3,4,1},{1,4,6},{3,5,5}};
		int vertices=5;
		bellmanFord(adjList,vertices);
	}
		
	public static void  bellmanFord(int[][] ajdList,int vertices){
		int[] dist=new int[vertices];
		Arrays.fill(dist,Integer.MAX_VALUE);
		dist[0]=0;
		System.out.println(Arrays.toString(dist));
		for(int[] arr: ajdList){
			int u=arr[0]-1;
			int v=arr[1]-1;
			int wt=arr[2];
			if(dist[u]==Integer.MAX_VALUE) {
					continue;
			}
			if(dist[u]+wt < dist[v]){
				dist[v]=dist[u]+wt;
			}	
		}
		
		for (int i = 1; i < dist.length; i++) {
			if (dist[i] == Integer.MAX_VALUE)	{
				System.out.print( "1000000000" + " " );
			}
			else {
				System.out.print(dist[i] + " " );
			}
        }
	}
	}	
}