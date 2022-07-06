import java.util.*;
public class MultiSolverGraph {

	private static int smallestWeight=Integer.MAX_VALUE;
	private static String smallestPath="";
	private static String lpath;
	private static Integer lpathwt=Integer.MIN_VALUE;
	private static String cpath;
	private static Integer cpathwt = Integer.MAX_VALUE;
    private static String fpath;
    private static Integer fpathwt = Integer.MIN_VALUE;
	private static PriorityQueue<Integer> minHeap=new PriorityQueue<>();

	public static void main(String[] args){
		int vertices=7;
		int[][] edges={{0,1,10},{1,2,10},{2,3,10},
		{0,3,40},{3,4,2},{4,5,3},{5,6,3},{4,6,8},{2,5,5}};
		ArrayList<Edge>[] graph=new ArrayList[vertices];
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
		boolean[] visited=new boolean[vertices];
		printAllPath(0,6,graph,visited,"",0,30);
		System.out.println("Smallest Path >> "+smallestPath+"@"+smallestWeight);
		System.out.println("Largest Path >> "+lpathwt+"@"+lpath);
		System.out.println("Just Larger Path than 30 "+cpath+"@"+cpathwt);
		System.out.println("Just Smaller Path than  30 "+fpath+"@"+fpathwt);
		System.out.println("k th largest Weight >> "+minHeap.peek());
	}
	
	public static class Edge {
		int source;
		int neighbour;
		int weight;
		Edge(){}
		Edge(int source,int neighbour,int weight){
			this.source=source;
			this.neighbour=neighbour;
			this.weight=weight;
		}
		public String toString(){
			return this.source+" "+this.neighbour+" "+this.weight;
		}
	}
	public static void printAllPath(int source,int dest,
		ArrayList<Edge>[] graph,boolean[] visited,String pathsofar,int weightsofar,int criteria){
		if(source==dest) {
			if(weightsofar < smallestWeight ){
				smallestWeight=weightsofar;
				smallestPath=pathsofar+dest;
			}
			if(lpathwt < weightsofar) {
				lpathwt=weightsofar;
				lpath=pathsofar+dest;
			}
			if(weightsofar > criteria && weightsofar < cpathwt){
				cpathwt=weightsofar;
				cpath=pathsofar;
			}
			if(weightsofar < criteria && weightsofar > fpathwt){
				fpathwt=weightsofar;
				fpath=pathsofar;
			}
			minHeap.add(weightsofar);
			if(minHeap.size()>4){
				minHeap.remove();
			}
			return;
		}
		ArrayList<Edge> neighbours=graph[source];
		for(Edge edge: neighbours){
			if(visited[edge.neighbour]==false){
				visited[edge.source]=true;
				printAllPath(edge.neighbour,dest,graph,visited,pathsofar+edge.source,
				weightsofar+edge.weight,criteria);
				visited[edge.source]=false;
			}
		}
	}
}