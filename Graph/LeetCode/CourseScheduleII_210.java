import java.util.*;
public class CourseScheduleII_210 {
	
	public static void main(String[] args){
		int numCourses = 4;
		int[][] prerequisites ={{1,0},{2,0},{3,1},{3,2}};
		int[] indegree=new int[numCourses];
		List<Edge>[]  graph=constructGraph(numCourses,prerequisites,indegree);
		System.out.println(scheduleCourse(graph,indegree));
	}

	public static class Edge {
		int srcVertex;
		int nbrVertex;
		Edge(int srcVertex,int nbrVertex){
			this.srcVertex=srcVertex;
			this.nbrVertex=nbrVertex;
		}
		public String toString(){
			return " srcVertex >> "+this.srcVertex+" neighbour >> "+this.nbrVertex;
		}
	}

	public static List<Edge>[] constructGraph(int numCourses,
		int[][] prerequisites,int[] indegree){
		List<Edge>[] graph=new ArrayList[numCourses];
		for(int i=0;i<numCourses;i++){
			graph[i]=new ArrayList<>();
		}
		for(int[] pre : prerequisites){
			 int srcVertex=pre[1];
			 int nbrVertex=pre[0];
			 indegree[pre[0]]++;
			 graph[srcVertex].add(new Edge(srcVertex,nbrVertex));
		}
		return graph;
	}
	
	
	public static boolean scheduleCourse(List<Edge>[] graph,int[] indegree){
		Queue<Integer> queue=new LinkedList<>();
    	for(int i=0;i<indegree.length;i++){
			if(indegree[i]==0){
				queue.offer(i);
			}
		}
		int index=0;
		while(!queue.isEmpty()){
			int course=queue.remove();
			List<Edge> edges=graph[course];
			for(Edge edge:edges){
				indegree[edge.nbrVertex]--;
				if(indegree[edge.nbrVertex]==0){
					queue.add(edge.nbrVertex);
				}
			}
		}
		for (int in : indegree) {
            if (in != 0) {
                return false;
            }
        }
		return true;
	}
	
}