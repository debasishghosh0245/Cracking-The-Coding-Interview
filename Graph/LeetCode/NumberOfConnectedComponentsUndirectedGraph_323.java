import java.util.*;
public class NumberOfConnectedComponentsUndirectedGraph_323{
	
	//Time Complixity: O(E+V)
	//Space Complixity: O(E+V)
	public static void main(String[] args){
		int n =5;
		int[][] edges={{0,1},{1,2},{2,3},{3,4}};
		List<Edge>[] graph=constructGraph(edges,n);
		int count=0;
		//Space Complitity: O(V)
		boolean[] visited=new boolean[n];
		for(int i=0;i<n;i++){
			if(visited[i]==false){
				getConnectComponentCount(graph,i,visited);
				count++;
			}
		}
		System.out.println(count);
	}
	
	//Time Complexity: O(v);
	//Space Complicity: O(v);
	public static void getConnectComponentCount(List<Edge>[] graph,int source,
		boolean[] visited){
		List<Edge> edges=graph[source];
		visited[source]=true;
		for(Edge edge:edges){
			if(visited[edge.neighbour]==false){
				getConnectComponentCount(graph,edge.neighbour,visited);
			}
		}
	}
	
	//Time Complexity : O(E)
	//Space Complexity : O(E)
	public static List<Edge>[] constructGraph(int[][] edges,int vertices){
		List<Edge>[] graph=new ArrayList[vertices];
		for(int i=0;i<vertices;i++){
			graph[i]=new ArrayList<>();
		}
		for(int i=0;i<edges.length;i++){
			int v1=edges[i][0];
			int v2=edges[i][1];
		
			graph[v1].add(new Edge(v1,v2));
			graph[v2].add(new Edge(v2,v1));
		}
		return graph;
	}
	
	
	public static class Edge{
		int source;
		int neighbour;
		
		public Edge(int sourc,int neighbour){
			this.source=sourc;
			this.neighbour=neighbour;
		}
		
		public String toString(){
			return "source >> "+this.source+" neighbour >> "+this.neighbour;
		}
	}

}