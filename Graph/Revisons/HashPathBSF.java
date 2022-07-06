import java.util.*;
public class HashPathBSF {

	public static void main(String[] args) {
		int[][] matrix={{0,1,10},{1,2,10},{2,3,10},{0,3,10},
		{3,4,10},{4,5,10},{5,6,10},{4,6,10}};
		int src=0;
		int dest=6;
		int vertices=8;
		List<List<Edge>> adjacency_list=constructGraph(matrix,vertices);
		System.out.println(hashPath(adjacency_list,src,dest));
	}

	public static class Edge {
		int src;
		int nbr;
		int weight;
		Edge(int src,int nbr){
			this.src=src;
			this.nbr=nbr;
		}
		public String toString(){
			return " soruce >> "+this.src+" neighbour >> "+this.nbr+" weight >> "+this.weight;
		}
	}

	public static List<List<Edge>> constructGraph(int[][] matrix,int vertices){
		List<List<Edge>> adjacency_list=new ArrayList<>();
		for(int i=0;i<vertices;i++){
			adjacency_list.add(new ArrayList<>());
		}
		for(int[] edges : matrix){
			int src=edges[0];
			int nbr=edges[1];
			int wt=edges[2];
			adjacency_list.get(src).add(new Edge(src,nbr));
			adjacency_list.get(nbr).add(new Edge(nbr,src));

		}
		for(List<Edge> list: adjacency_list){
			System.out.println(list);
		}
		return adjacency_list;
	}

	public static boolean hashPath(List<List<Edge>> adjacency_list,int src,int dest){
		Queue<Integer> queue=new ArrayDeque<>();
		queue.add(src);
		boolean[] visited=new boolean[adjacency_list.size()];
		while(!queue.isEmpty()) {
			int removed_vertex=queue.remove();
			if(removed_vertex==dest) return true;
			visited[removed_vertex]=true;
			List<Edge> edges=adjacency_list.get(removed_vertex);
			for(Edge edge: edges) {
				if(visited[edge.nbr]==false){
					 queue.add(edge.nbr);
				}
			}
		}
		return false;
	}
}
