import java.util.*;
public class OptimizeWaterDistributionVillage_1168{

	public static void main(String[] args){
		/* int n=3; 
		int[] wells={1,2,2};
		int[][] pipes={{1,2,1},{2,3,1}}; */
		int n = 2;
		int[] wells ={1,1};
		int[][] pipes ={{1,2,1},{1,2,2}};
		List<Edge>[] graph=constructGraph(pipes,n,wells);
		System.out.println(minCostToSupplyWater(graph));
	}
	
	
	public static class Edge implements Comparable<Edge>{
		int src;
		int nbr;
		int weight;
		Edge(int src,int nbr,int weight){
			this.src=src;
			this.nbr=nbr;
			this.weight=weight;
		}
		public String toString(){
			return " source >> "+this.src+" neighbour >> "+this.nbr+" weight >> "+this.weight;
		}
		public int compareTo(Edge edge){
			return this.weight-edge.weight;
		}	
	}
	
	public static List<Edge>[] constructGraph(int[][] pipes,int n,int[] wells){
		List<Edge>[] graph=new ArrayList[n+1];
		for(int i=0;i<=n;i++){
			graph[i]=new ArrayList<>();
		}
		
		for(int[] pipe:pipes){
			int v1=pipe[0];
			int v2=pipe[1];
			int weight=pipe[2];
			graph[v1].add(new Edge(v1,v2,weight));
			graph[v2].add(new Edge(v2,v1,weight));
		}
		
		for(int i=1;i<=wells.length;i++){
			graph[0].add(new Edge(0,i,wells[i-1]));
			graph[i].add(new Edge(i,0,wells[i-1]));	
		}
		/* for(int i=0;i<=n;i++){
			System.out.println(graph[i]);
		} */
		return graph;
	}

	public static int minCostToSupplyWater(List<Edge>[] graph) {
        PriorityQueue<Edge> queue=new PriorityQueue<>();
		queue.offer(new Edge(0,0,0));
		int minCost=0;
		boolean[] visited=new boolean[graph.length];
		while(!queue.isEmpty()){
			Edge rm=queue.remove();
			if(visited[rm.src]==true){
				continue;
			}else{
				visited[rm.src]=true;
			}
			minCost+=rm.weight;
			List<Edge> edges=graph[rm.src];
			for(Edge edge:edges){
				if(visited[edge.nbr]==false){
					queue.add(new Edge(edge.nbr,rm.src,edge.weight));
				}
			}
		}
		return minCost;
    }
}