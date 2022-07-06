import java.util.*;
public class MinCostToConnectAllPoints_1584 {

	public static void main(String[] args){
		//int[][] points={{0,0},{2,2},{3,10},{5,2},{7,0}};
		int[][] points ={{3,12},{-2,5},{-4,1}};
		List<Edge>[] graph=constructGraph(points);
		System.out.println("Cost >>"+minCostConnectPoints(graph,points));
	}

	public static class Edge {
		int srcVertex;
		int nbrVertex;
		int weight;
		
		Edge(int srcVertex,int nbrVertex, int weight){
			this.srcVertex=srcVertex;
			this.nbrVertex=nbrVertex;
			this.weight=weight;
		}
		/* public String toString(){
			return " source >> "+this.srcVertex+" neighbour >>  "+this.nbrVertex+" weight >> "+this.weight;
		} */
	}
	
	public static List<Edge>[] constructGraph(int[][] points){
		int vertices=points.length;
		List<Edge>[] graph=new ArrayList[vertices];
		for(int i=0;i<vertices;i++){
			graph[i]=new ArrayList<>();
		}
		
		for(int i=0;i<points.length-1;i++){
			for(int j=i+1;j<points.length;j++){
				int weight=Math.abs(points[i][0]-points[j][0])+
					Math.abs(points[i][1]-points[j][1]);
				graph[i].add(new Edge(i,j,weight));
				graph[j].add(new Edge(j,i,weight));	
			}
		}
		
		// for(int i=0;i<vertices;i++){
			// System.out.println(graph[i]);
		// }
		return graph;
	}


	public static class Pair implements Comparable<Pair>{
		int srcVertex;
		int nbrVertex;
		int weight;
		
		Pair(int srcVertex,int nbrVertex,int weight){
			this.srcVertex=srcVertex;
			this.nbrVertex=nbrVertex;
			this.weight=weight;
		}
		
		public int compareTo(Pair pair){
			return this.weight-pair.weight;
		}
	}

	
	public static int minCostConnectPoints(List<Edge>[] graph,int[][] points) {
		boolean[] visited=new boolean[graph.length]; 
		PriorityQueue<Pair> queue=new PriorityQueue<>();
		int cost=0;
		queue.add(new Pair(0,0,0));
		while(!queue.isEmpty()){
			Pair pair=queue.remove();
			if(visited[pair.srcVertex]){ 
				continue;
			}
			else {
				visited[pair.srcVertex]=true;
			}
			// System.out.println("Source "+pair.srcVertex+" accuired >> "+pair.nbrVertex
			// +" weight >> "+pair.weight);
			cost+=pair.weight;
			List<Edge> edges=graph[pair.srcVertex];
			for(Edge edge:edges){
				if(visited[edge.nbrVertex]==false){
					int weight=Math.abs(points[edge.srcVertex][0]-points[edge.nbrVertex][0])+
					Math.abs(points[edge.srcVertex][1]-points[edge.nbrVertex][1]);
					queue.add(new Pair(edge.nbrVertex,pair.srcVertex,weight));
				}
			}
		}
		return cost;
    }
}