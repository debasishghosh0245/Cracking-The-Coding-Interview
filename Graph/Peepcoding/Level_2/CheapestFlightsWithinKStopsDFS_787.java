import java.util.*;
public class CheapestFlightsWithinKStopsDFS_787 {

	static int cheapest_price=Integer.MAX_VALUE;
			
	public static void main(String[] args) {
		int n=5;
		int[][] flights={{0,1,5},{1,2,5},{0,3,2},{3,1,2},{1,4,1},{4,2,1}};
		int src=0;
		int dest=2;
		int k=2;
		/* int n = 4;
		int[][] flights={{0,1,1},{0,2,5},{1,2,1},{2,3,1}};
		int src=0;
		int dest=3;
		int k=1; */
		List<Edge>[] adjList = constructAdjList(flights,n);
		boolean[] visited=new boolean[n];
		int price=0;
		cheapestPriceDFS(adjList,src,dest,k+1,price,visited);
		System.out.println("Price >> "+cheapest_price);
	}

	public static class Edge {
		int src;
		int nbr;
		int weight;
		Edge(int src, int nbr, int weight) {
			this.src = src;
			this.nbr = nbr;
			this.weight = weight;
		}
		Edge(int src, int weight) {
			this.src = src;
			this.weight = weight;
		}
		
		public String toString(){
			return "src >> "+this.src+" nbr >>  "+this.nbr+" weight >> "+this.weight;
		}
	}

	public static List<Edge>[] constructAdjList(int[][] flights, int n) {
		List<Edge>[] adjList = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			adjList[i] = new ArrayList<>();
		}
		for (int[] flight : flights) {
			int src = flight[0];
			int nbr = flight[1];
			int weight = flight[2];
			adjList[src].add(new Edge(src, nbr, weight));
		}
		for (int i = 0; i < n; i++) {
			System.out.println(adjList[i]);
		}
		return adjList;
	}

	public static void cheapestPriceDFS(List<Edge>[] adjList,int src,int dest,int k,
		int price,boolean[] visited) {
		if(src==dest){
			cheapest_price=Math.min(price,cheapest_price);
			return ;
		} 
		visited[src]=true;
		List<Edge> edges=adjList[src];
		for(Edge edge:edges){
			if(k>0 && visited[edge.nbr]==false){
				cheapestPriceDFS(adjList,edge.nbr,dest,k-1,price+edge.weight,visited);
			}
		}
		visited[src]=false;
	}
	
}