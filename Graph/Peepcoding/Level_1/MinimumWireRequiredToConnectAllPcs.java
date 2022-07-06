import java.util.*;
public class MinimumWireRequiredToConnectAllPcs{
	
	public static void main(String[] args){
		int[][] adjMatrix={{0,1,10},{1,2,10},{2,3,10},
			{0,3,40},{3,4,2},{4,5,3},{5,6,3},{4,6,8}}; 
		//int[][] adjMatrix={{0,1,10},{1,2,10},{2,3,10},{0,3,10},
		//{3,4,10},{4,5,10},{5,6,10},{4,6,10}};
		int vertices=7;
		List<Edge>[] graph=constructGraph(adjMatrix,vertices);
		printShortestPath(graph,0,vertices);
	}
	
	public static class Pair implements Comparable<Pair>{
		int vertex;
		int aVertex;
		int weight;
		
		Pair(int vertex,int aVertex,
			int weight){
			this.vertex=vertex;
			this.aVertex=aVertex;
			this.weight=weight;
		}
		public int compareTo(Pair pair){
			return this.weight-pair.weight;
		}
	}
	
	public static void printShortestPath(List<Edge>[] graph,
		int source,int vertices){
		PriorityQueue<Pair> queue=new PriorityQueue<>();
		queue.add(new Pair(0,-1,0));
		boolean[] visited=new boolean[vertices];
		while(!queue.isEmpty()){
			Pair remove=queue.remove();
			if(visited[remove.vertex]==true){
				continue;
			} 
			else{
				visited[remove.vertex]=true;
			}
			if(remove.aVertex!=-1){
				System.out.println("["+remove.vertex+"-"+remove.aVertex+"@"+remove.weight+"]");
			}
			List<Edge> edges=graph[remove.vertex];
			for(Edge edge:edges){
				if(visited[edge.neighbour]==false){
					queue.add(new Pair(edge.neighbour,remove.vertex,edge.weight));
				}
			}			
		}
	}

	public static List<Edge>[] constructGraph(int[][] edges,int vertices){
		List<Edge>[] graph=new ArrayList[vertices];
		for(int i=0;i<vertices;i++){
			graph[i]=new ArrayList<Edge>();
		}
		for(int i=0;i<edges.length;i++){
			int v1=edges[i][0];
			int v2=edges[i][1];
			int weight=edges[i][2];
			graph[v1].add(new Edge(v1,v2,weight));
			graph[v2].add(new Edge(v2,v1,weight));
		}
		return graph;
	}
	
	
	public static class Edge{
		int source;
		int neighbour;
		int weight;
		Edge(int source,int neighbour,
			int weight){
			this.source=source;
			this.neighbour=neighbour;
			this.weight=weight;
		}
		public String toString(){
			return this.source+" "+this.neighbour+" "+this.weight;
		}
	}
}