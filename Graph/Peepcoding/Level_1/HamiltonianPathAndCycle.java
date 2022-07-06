import java.util.*;
public class HamiltonianPathAndCycle{

	public static void main(String[] args){
		int vertices=7;
		int source=0;
		int[][] adjMatrix={{0,1,10},{1,2,10},{2,3,10},{0,3,10},
		{3,4,10},{4,5,10},{5,6,10},{4,6,10},{2,5,10}};
		List<Edge>[] graph=constructGraph(adjMatrix,vertices);
		HashSet<Integer> visited=new HashSet<>();
		allPath(graph,source,visited,""+source,0);
	}
	
	public static void allPath(List<Edge>[] graph,int source,
		HashSet<Integer> visited,String pathSoFar,int orginalSrc){
		if(visited.size()==graph.length-1){
			//System.out.println("Path So Far >>"+pathSoFar);
			List<Edge> edges=graph[source];
			boolean isCycle=false;
			for(Edge edge:edges){
				if(orginalSrc==edge.neighbour){
					isCycle=true;
					break;
				}
			}
			if(isCycle){
				System.out.println(pathSoFar+"*");
			}else{
				System.out.println(pathSoFar+".");
			}
			return;
		}
		List<Edge> edges=graph[source];
		for(Edge edge:edges){
			visited.add(edge.source);
			if(!visited.contains(edge.neighbour)){
				allPath(graph,edge.neighbour,visited,
						pathSoFar+edge.neighbour,orginalSrc);
			}
			visited.remove(edge.source);
		}
	}
	
	public static List<Edge>[] constructGraph(int[][] adjMatrix,int vertices){
		List<Edge>[] graph=new ArrayList[vertices];
		for(int i=0;i<vertices;i++){
			graph[i]=new ArrayList<>();
		}
		for(int i=0;i<adjMatrix.length;i++){
			int v1=adjMatrix[i][0];
			int v2=adjMatrix[i][1];
			int weight=adjMatrix[i][2];
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
		public String toString(){
			return this.source+" "+this.neighbour+" "+this.weight;
		}
	}
	
	
}