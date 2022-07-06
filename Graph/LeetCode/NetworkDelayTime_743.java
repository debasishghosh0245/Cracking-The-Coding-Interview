import java.util.*;
public class NetworkDelayTime_743{

	public static void main(String[] args){
		/* int[][] times ={{2,1,1},{2,3,1},{3,4,1}};
		int n=4;
		int k=2; */
		int[][] times={{1,2,1}};
		int n = 2;
		int k = 1;
		List<Edge>[] graph=constructGraph(times,n);
		System.out.println("Time >> "+networkDelayTime(graph,n,k));
	}
	
	public static class Edge implements Comparable<Edge>{
		int src;
		int nbr;
		int weight;
		
		Edge(int src,int weight){
			this.src=src;	
			this.weight=weight;			
		}
		
		Edge(int src,int nbr,int weight){
			this.src=src;	
			this.nbr=nbr;
			this.weight=weight;			
		}
		
		public int compareTo(Edge edge){
			return this.weight-edge.weight;
		}
		
		public String toString(){
			return this.src+" "+this.nbr+" "+this.weight;
		}
	}
	
	public static  List<Edge>[] constructGraph(int[][] times,int n){
		int vertices=n;
		List<Edge>[] graph=new ArrayList[vertices];
		for(int i=0;i<vertices;i++){
			graph[i]=new ArrayList<>();
		}
		
		for(int[] time: times){
			int src=time[0]-1;
			int nbr=time[1]-1;
			int weight=time[2];
			graph[src].add(new Edge(src,nbr,weight));
		}
		
		for(int i=0;i<vertices;i++){
			System.out.println(graph[i]);
		}
		return graph;
	}
	
	public static int networkDelayTime(List<Edge>[] graph, int n, int k) {
        PriorityQueue<Edge> queue=new PriorityQueue<>();
		queue.add(new Edge(k-1,0));
		int totalTime=0;
		boolean[] visited=new boolean[n];
		while(!queue.isEmpty()){
			Edge rmEdge=queue.remove();
			if(visited[rmEdge.src]==true){
				continue;
			}else{
				visited[rmEdge.src]=true;
			}
			totalTime=Math.max(totalTime,rmEdge.weight);
			//System.out.println("Source >> "+rmEdge.src+" Weight >> "+rmEdge.weight);
			List<Edge> edges=graph[rmEdge.src];
			for(Edge edge:edges){
				if(visited[edge.nbr]==false){
					int weight=rmEdge.weight+edge.weight;
					queue.add(new Edge(edge.nbr,weight));
				}
			}
		}
		for(boolean v:visited){
			if(v==false) return -1;
		}
		return totalTime;
	}

}