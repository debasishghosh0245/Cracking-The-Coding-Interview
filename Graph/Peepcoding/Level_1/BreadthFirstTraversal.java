import java.util.*;
public class BreadthFirstTraversal {

	public static void main(String[] args){
		int vertices=7;
		int[][] adjMatrix={{0,1,10},{1,2,10},{2,3,10},{0,3,10},
		{3,4,10},{4,5,10},{5,6,10},
		{4,6,10}};
		List<Edge>[] graph=constructGraph(adjMatrix,vertices);
		printPath(graph,vertices,2);
	}

	public static class Pair {
		int vertices;
		String pathsofar;
		Pair(int vertices,String pathsofar){
			 this.vertices=vertices;
			 this.pathsofar=pathsofar;
		}
	}

	public static void printPath(List<Edge>[] graph,int vertices,
		int source){
		Queue<Pair> queue=new ArrayDeque<>();
		queue.offer(new Pair(source,source+""));
		boolean[] visited=new boolean[vertices];
		while(!queue.isEmpty()){
			Pair pair=queue.remove();
			if(visited[pair.vertices]==true) continue;
			visited[pair.vertices]=true;
			System.out.println(pair.vertices+"@"+pair.pathsofar);
			List<Edge> edges=graph[pair.vertices];
			for(Edge edge:edges){
				if(visited[edge.neighbour]==false){
					queue.add(new Pair(edge.neighbour,pair.pathsofar+edge.neighbour));
				}
			}
		}	
	}
	
	public static List<Edge>[] constructGraph(int[][] edges,int vertices){
		List<Edge>[] graph=new ArrayList[vertices];
		//Initialized the graph
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
		Edge(int source,int neighbour,int weight){
			this.source=source;
			this.neighbour=neighbour;
			this.weight=weight;
		}
		
		public String toString(int source,int neighbour,int weight){
			return this.source+" "+this.neighbour+" "+this.weight;
		}
	}
}