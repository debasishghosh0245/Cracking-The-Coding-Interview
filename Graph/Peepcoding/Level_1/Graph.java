import java.util.*;
import java.io.*;
public class Graph{

	public static void main(String[] args) throws Exception {
		int vertices=7;
		ArrayList<Edge>[] graph=new ArrayList[vertices];
		for(int i=0;i<vertices;i++){
			graph[i]=new ArrayList<>();
		}
		int[][] edges={{0,1,10},{1,2,10},{2,3,10},{0,3,10},{3,4,10},
		{4,5,10},{5,6,10},{4,6,10}};
		for(int i=0;i<edges.length;i++){
			int v1=edges[i][0];
			int v2=edges[i][1];
			int weight=edges[i][2];
			graph[v1].add(new Edge(v1,v2,weight));
			graph[v2].add(new Edge(v2,v1,weight));
		}
		int src = 0;
		int dest = 6;
		boolean[] visited=new boolean[vertices];
		System.out.println(hashPath(0,6,graph,visited));
	}
	
	public static class Edge{
		int source;
		int neighbour;
		int weight;
		public Edge(){}
		public Edge(int source,int neighbour,int weight){
			this.source=source;
			this.neighbour=neighbour;
			this.weight=weight;
		}
		public String toString(){
			return "source >> "+this.source+" neighbour >> "+this.neighbour+" wight>>  "+this.weight;
		}
	}
	
	public static boolean hashPath(int source,int dest,ArrayList<Edge>[] graph,
		boolean[] visited){
		if(source==dest) return true;
		ArrayList<Edge> neighbours=graph[source];
		visited[source]=true;
		for(Edge edge: neighbours){
			if(visited[edge.neighbour]==false){
				boolean result=hashPath(edge.neighbour,dest,graph,visited);
				if(result==true) return true;
			}
		}
		return false;
	}
}