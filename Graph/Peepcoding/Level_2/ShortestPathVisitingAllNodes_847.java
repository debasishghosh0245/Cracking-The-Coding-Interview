import java.util.*;
public class ShortestPathVisitingAllNodes_847{

	public static void main(String[] args){
		int[][] graph={{1,2,3},{0},{0},{0}};
		shortestPathLength(graph);
	}
	
	public static class Pair{
		int vertex;
		String pathSoFar;
		
		Pair(int vertex,String pathSoFar){
			this.vertex=vertex;
			this.pathSoFar=pathSoFar;
		}
	}
	
	
	public static void shortestPathLength(int[][] graph) {
        //int vertices=graph.length-1;
		int src=0;
		//int dest=graph.length-1;
		boolean[] visited=new boolean[graph.length];
		Stack<Pair> stack=new Stack<>();
		stack.add(new Pair(src,"0"));
		while(!stack.isEmpty()){
			Pair pair=stack.pop();	
			//System.out.println("Queue >> "+queue);
			if(visited[pair.vertex]==true){
				continue;
			}
			else{
				visited[pair.vertex]=true;
			}
			System.out.println(pair.vertex+"@"+pair.pathSoFar);
			for(int nbrVertex : graph[pair.vertex]){
				if(visited[nbrVertex]==false){
					stack.push(new Pair(nbrVertex,pair.pathSoFar+nbrVertex));
				}
			}
		}
    }
}