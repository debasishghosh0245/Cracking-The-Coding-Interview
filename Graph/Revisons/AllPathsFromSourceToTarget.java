import java.util.*;
public class AllPathsFromSourceToTarget{
	
	public static void main(String[] args){
		int[][] matrix={{0,1,0},{1,2,10},{2,3,10},{0,3,10},{3,4,10},
		{4,5,10},{5,6,10},{4,6,10}};
		int vertices=8;
		List<List<Edge>> adjList=constructGraph(vertices,matrix);
		//boolean[] visited=new boolean[vertices];
		//List<List<Integer>> paths=new ArrayList<>();
		System.out.println(allPathsRecursive(adjList,0,6));
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
			return " source >> "+this.src+" nieghbour >> "+this.nbr+" weight "+this.wt;
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
			//int wt=edges[2];
			adjacency_list.get(src).add(new Edge(src,nbr));
			adjacency_list.get(nbr).add(new Edge(nbr,src));
		}
		for(List<Edge>  edge: adjacency_list){
			System.out.println(edge);
		}
		return adjacency_list;
	}
	
	public static List<List<Integer>> allPath(List<List<Edge>> adjacency_list,
		int src, int dest, boolean[] visited,List<Integer> pathSoFar,List<List<Integer>> paths){
		if(src==dest) {
			paths.add(new ArrayList<>(pathSoFar));
			return paths;
		} 
		List<Edge> edges=adjacency_list.get(src);
		pathSoFar.add(src);
		visited[src]=true;
		for(Edge edge: edges){
			if(visited[edge.nbr]==false){
				allPath(adjacency_list,edge.nbr,dest,visited,pathSoFar,paths);

			}
		}
		pathSoFar.remove(pathSoFar.size()-1);
		visited[src]=false;
		return paths;
	}
	
	public static List<List<Integer>> allPathsRecursive(List<List<Edge>> adjacency_list,int src,int dest){
		Stack<List<Integer>> stack=new Stack<>();
		boolean[] visited=new boolean[adjacency_list.size()];
		List<List<Integer>> paths=new ArrayList<>();
		List<Integer> path=new ArrayList<>();
		path.add(src);
		stack.push(path);
		
		while(!stack.isEmpty()){
			List<Integer> current_path=stack.pop();
			int last_vertex=current_path.get(current_path.size()-1);
			if(last_vertex==dest) {
				paths.add(current_path);
			}
			List<Edge> edges=adjacency_list.get(last_vertex);
			for(Edge edge: edges){
				List<Integer> temp_path=new ArrayList<>(current_path);
				temp_path.add(edge.nbr);
				stack.push(temp_path);
			}
		}
		return paths;
	}
	
}