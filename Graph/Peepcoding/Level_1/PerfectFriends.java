import java.util.*;
public class PerfectFriends {

	public static class Edge{
		int source;
		int neighbour;
		Edge(int source,int neighbour){
			this.source=source;
			this.neighbour=neighbour;
		}	
		
		public String toString(){
			return this.source+" "+this.neighbour;
		}
	}
	
	
	public static List<Edge>[] constructGraph(int[][] edges, 
		int vertices){
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
	
	public static void getConnectedComponents(List<Edge>[] graph,int source,boolean[] visited,
		List<Integer> component){
		visited[source]=true;
		component.add(source);
		List<Edge> edges=graph[source];
		for(Edge edge:edges){
			if(visited[edge.neighbour]==false){
				getConnectedComponents(graph,edge.neighbour,visited,component);
			}
		}
	}
		
	public static void main(String[] args){
		int vertices=7;
		int[][] edges={{0,1},{2,3},{4,5},{5,6},{4,6}};
		List<Edge>[] graph=constructGraph(edges,vertices);
		boolean[] visited=new boolean[vertices];
		List<List<Integer>> components=new ArrayList<>();;
		for(int i=0;i<vertices;i++){
			if(visited[i]==false){
				List<Integer> component=new ArrayList<Integer>();
				getConnectedComponents(graph,i,visited,component);
				components.add(component);
			}
		}
		int size=0;
		for(int i=0;i<components.size();i++){
			for(int j=i+1;j<components.size();j++){
				size+=components.get(i).size()*components.get(j).size();
			}
		}
		System.out.println("Size >>"+size);
	}

}