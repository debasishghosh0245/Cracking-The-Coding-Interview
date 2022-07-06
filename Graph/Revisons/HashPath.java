import java.util.*;
public class HashPath{

	public static void main(String[] args){
		int[][] matrix={{0,1,0},{1,2,10},{2,3,10},{0,3,10},{3,4,10},{4,5,10},{5,6,10},{4,6,10}};
		int vertices=8;
		List<List<Edge>> adjList=constructGraph(vertices,matrix);
		boolean[] visited=new boolean[vertices];
		System.out.println(hashPah_Iterative(adjList,0,100));
		System.out.println("Hello Word");
	}

 	public static class Edge {
		int src;
		int nbr;
		int wt;
		Edge(int source,int neighbour){
			this.src=source;
			this.nbr=neighbour;
		}
		Edge(int source,int neighbour,int weight){
			this.src=source;
			this.nbr=neighbour;
			this.wt=weight;
		}
		public String toString(){
			return "Source >> "+this.src+" nieghbour >> "+this.nbr+" weight "+this.wt;
		}
	}

	public static List<List<Edge>> constructGraph(int vertices,int[][] matrix){
		List<List<Edge>> adjacency_list=new ArrayList<>(vertices);
		for(int i=0;i<vertices;i++){
			adjacency_list.add(new ArrayList<>());
		}
		for(int[] edges: matrix){
			int src=edges[0];
			int nbr=edges[1];
			adjacency_list.get(src).add(new Edge(src,nbr));
			adjacency_list.get(nbr).add(new Edge(nbr,src));
		}
		for(List<Edge>  edge: adjacency_list){
			System.out.println(edge);
		}
		return adjacency_list;
	}

	public static boolean hashPah(List<List<Edge>> adjacency_list,int src,int dest,
		boolean[] visited){
		if(src==dest) return true;
		List<Edge> edges=adjacency_list.get(src);
		visited[src]=true;
		for(Edge edge: edges){
			if(visited[edge.nbr]==false){
				return hashPah(adjacency_list,edge.nbr,dest,visited);
			}
		}
		return false;
	}

	public static boolean hashPah_Iterative(List<List<Edge>> adjacency_list,int src,int dest){
		Stack<Integer> stack=new Stack<Integer>();
		boolean[] visited=new boolean[adjacency_list.size()];
		stack.push(src);
		while(!stack.isEmpty()){
			int node=stack.pop();
			//removed vertex is the destination then return true
			if(node==dest) return true;
			//if the node is already visited continue
			if(visited[node]==true) continue;
			List<Edge> edges=adjacency_list.get(node);
			//mark this node as visited
			visited[node]=true;
			for(Edge edge: edges){
				stack.push(edge.nbr);
			}
		}
		return false;
	}

}
