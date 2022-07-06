import java.util.*;
public class AllPathsFromSourceTarget_797{
	
	public static void main(String[] args){
		/* int n=6;
		int[][] edge={{0,1},{0,2},{3,5},{5,4},{4,3}};
		int source=0;
		int destination=5; */
		int[][] graph={{4,3,1},{3,2,4},{3},{4},{}};
		int source = 0; int destination=graph.length-1;
		System.out.println("Hash Path >> "+allPathsSourceTarget(graph,source,destination));
	}
	
	public static List<List<Integer>> allPathsSourceTarget(int[][] graph, 
		int source,int destination) {
		int n=graph.length-1;
		boolean[] visited=new boolean[graph.length];
		List<List<Integer>> result=new ArrayList<List<Integer>>();
		List<Integer> path=new ArrayList<Integer>();
		getAllPahSourceToDestination(graph,source,destination,visited,path,result);
		return result;
    }
		
	public static List<List<Integer>> getAllPahSourceToDestination(int[][] graph,
		int src,int dest,boolean[] visited,List<Integer> path,List<List<Integer>> result){
		if(src==dest) {
			path.add(dest);
			result.add(path);
			return result;
		}
		int[] neighbours=graph[src];
		visited[src]=true;
		for(int neighbour: neighbours){
			if(visited[neighbour]==false){
				path.add(src);
				getAllPahSourceToDestination(graph,neighbour,dest,visited,
				new ArrayList<>(path),result);
				visited[neighbour]=false;
				path.remove(path.size()-1);
			}
		}
		return result;
	}
}