public class OrderOfCompilation{

	public static void main(String[] args){
		int[][] grid={{0,1},{1,2},{2,3},{0,3},{4,5},{5,6},
		{4,6}};
		int vertices=7;
		boolean[] visited=new boolean[vertices];
		Stack<Integer> stack=new Stack<Integer>();
		List<Edge>[] adjList=constructAdjList(grid,vertices);
		for(int i=0;i<vertices;i++){
		    if(visited[i]==false){
				 dfs(adjList,i,visited,stack);	
			}
		}
		while(!stack.isEmpty()){
			System.out.print(stack.pop());
		}
	}
	
	public static class Edge{
		int src;
		int nbr;
		Edge(int src,int nbr){
			this.src=src;
			this.nbr=nbr;
		}
		public String toString(){
			return " source >> "+this.src+" neighbour >> "+this.nbr;
		}
	}
	
	public static List<Edge>[] constructAdjList(int[][] grid, int vertices){
		List<Edge>[] adjList=new ArrayList[vertices];
		//initialization
		for(int i=0;i<vertices;i++){
			adjList[i]=new ArrayList<>();
		}
		for(int[] arr:grid){
			int src=arr[0];
			int dest=arr[1];
			adjList[src].add(new Edge(src,dest));
		}
		
		return adjList;
	}

	public static void dfs(List<Edge>[] graph,int src,boolean[] visited,Stack<Integer> stack){
		visited[src]=true;
		List<Edge> edges=graph[src];
		for(Edge edge:edges){
			if(visited[edge.nbr]==false){
				dfs(graph,edge.nbr,visited,stack);
			}
		}
		stack.push(src);
	}
	
	


}