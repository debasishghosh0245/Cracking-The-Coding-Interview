import java.util.*;
public class ConnectingCitiesWithMinimumCost_1135{

	public static void main(String[] args){
		 int n = 3;
		int[][] connections ={{1,2,5},{1,3,6},{2,3,1}}; 
		/* int n = 4;
		int[][] connections={{1,2,3},{3,4,4}}; */
		List<Edge>[] graph=constructGraph(connections,n);
		System.out.println(minmumCost(graph));
	}
	
	public static class Edge {
		int src;
		int nbr;
		int weight;
		Edge(int src,int nbr,int weight){
			this.src=src;
			this.nbr=nbr;
			this.weight=weight;
		}
		public String toString(){
			return " Source >> "+this.src+" neighbour >> "+this.nbr+" Weight >> "+this.weight;
		}
	}
	
	public static List<Edge>[] constructGraph(int[][] connections,int n){
		List<Edge>[] graph=new ArrayList[n];
		for(int i=0;i<n;i++){
			graph[i]=new ArrayList<>();
		}
		for(int[] connection: connections){
			int v1=connection[0]-1;
			int v2=connection[1]-1;
			int weight=connection[2];
			graph[v1].add(new Edge(v1,v2,weight));
			graph[v2].add(new Edge(v2,v1,weight));
		}
		for(int i=0;i<n;i++){
			System.out.println(graph[i]);
		}
		return graph;
	}
	
	public static class Pair implements Comparable<Pair>{
		int src;
		int nbr;
		int weight;
		Pair(int src,int nbr,int weight){
			this.src=src;
			this.nbr=nbr;
			this.weight=weight;
		}
		
		public int compareTo(Pair pair){
			return this.weight-pair.weight;
		}
	}
	
	public static int minmumCost(List<Edge>[] graph){
		PriorityQueue<Pair> queue=new PriorityQueue<>();
		queue.offer(new Pair(0,0,0));
		int cost=0;
		boolean[] visited=new boolean[graph.length];
		while(!queue.isEmpty()){
			Pair pair=queue.remove();
			if(visited[pair.src]==true){
				continue;
			}
			else{
				visited[pair.src]=true;
			}
			cost+=pair.weight;
			List<Edge> edges=graph[pair.src];
			for(Edge edge:edges){
				if(visited[edge.nbr]==false){
					queue.add(new Pair(edge.nbr,pair.src,edge.weight));
				}
			}
		}
		for(boolean vvertex: visited){
			if(vvertex==false) return -1;
		}
		System.out.println("total cost "+cost);
		return cost;
	}
}