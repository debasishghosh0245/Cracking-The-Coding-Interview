import java.util.*;
public class IsGraphCyclic{

	public static void main(String[] args){
		 int[][] adjMatrix={{0,1,10},{1,2,10},{2,3,10},
		{3,4,10},{4,5,10},{5,6,10}}; 
		//int[][] adjMatrix={{0,1,10},{1,2,10},{2,3,10},{0,3,10},
		//{3,4,10},{4,5,10},{5,6,10},{4,6,10}};
		int vertices=7;
		List<Edge>[] graph=constructGraph(adjMatrix,vertices);
		boolean[] visited=new boolean[vertices];
		for(int i=0;i<vertices;i++){
			if(visited[i]==false){
				boolean isCycle=isCycle(graph,0,vertices,visited);
				if(isCycle==true){
					System.out.println("true");
					return;
				} 
			}
		}
		System.out.println("false");
	}
	
	public static class Pair{
		int source;
		String pathsofar;
		
		Pair(int source,String pathsofar){
			this.source=source;
			this.pathsofar=pathsofar;
		}
	}
	
	public static boolean isCycle(List<Edge>[] graph,int soruce,int vertices,
		boolean[] visited){
		Queue<Pair> queue=new ArrayDeque<>();
		queue.add(new Pair(0,""));
		while(!queue.isEmpty()){
			Pair pair=queue.remove();
			if(visited[pair.source]==true){
				return true;
			} 
			else{
				visited[pair.source]=true;
			}
			System.out.println(pair.source+"@"+pair.pathsofar);
			List<Edge> edges=graph[pair.source];
			for(Edge edge:edges){
				if(visited[edge.neighbour]==false){
					queue.add(new Pair(edge.neighbour,pair.pathsofar+edge.neighbour));
				}
			}			
		}
		return false;
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
		
		for(int i=0;i<vertices;i++){
			System.out.println(graph[i]);
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