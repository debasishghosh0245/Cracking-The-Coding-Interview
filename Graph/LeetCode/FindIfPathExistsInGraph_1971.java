import java.util.*;
public class FindIfPathExistsInGraph_1971{
	
	public static void main(String[] args){
		/* int n=6;
		int[][] edge={{0,1},{0,2},{3,5},{5,4},{4,3}};
		int source=0;
		int destination=5; */
		int n=3;
		int[][] edge={{0,1},{1,2},{2,0}};
		int source = 0; int destination=2;
		System.out.println("Hash Path >> "+validPath(n,edge,source,destination));
	}
	
	public static boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<Edge>[] graph=new ArrayList[n];
		for(int i=0;i<n;i++){
			 graph[i]=new ArrayList<Edge>();
		}
		for(int i=0;i<edges.length;i++){
			int v1=edges[i][0];
			int v2=edges[i][1];
			graph[v1].add(new Edge(v1,v2));
			graph[v2].add(new Edge(v2,v1));
		}
		boolean[] visited=new boolean[n];
		return hashPah(graph,source,destination,visited);
    }
	
	
	public static boolean hashPah(ArrayList<Edge>[] graph,int src,int dest,boolean[] visited){
		if(src==dest) return true;
		ArrayList<Edge> edgesList=graph[src];
		visited[src]=true;
		for(Edge edge: edgesList){
			if(visited[edge.neighbour]==false)
				if(hashPah(graph,edge.neighbour,dest,visited)) return true;
			}
		return false;
	}
	
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

}