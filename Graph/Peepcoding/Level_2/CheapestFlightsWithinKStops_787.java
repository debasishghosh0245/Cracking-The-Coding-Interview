import java.util.*;
public class CheapestFlightsWithinKStops_787 {

	public static void main(String[] args) {
		int n = 4;
		int[][] flights = { { 0, 1, 1 }, { 0, 2, 5 }, { 1, 2, 1 }, { 2, 3, 1 } };
		int src = 0;
		int dest = 3;
		int k = 1;
		/*
		 * int n = 3; int[][] flights ={{0,1,100},{1,2,100},{0,2,500}}; int src =0; int
		 * dest =2; int k =1;
		 */
		List<Edge>[] adjList = constructAdjList(flights, n);
		System.out.println(cheapestPriceDijkstra(adjList, src, dest, k, n));
		// System.out.println(bellManFordFindChepesFlight(flights,n,k,src,dest));
	}

	public static class Edge {
		int src;
		int nbr;
		int weight;

		Edge(int src, int nbr, int weight) {
			this.src = src;
			this.nbr = nbr;
			this.weight = weight;
		}

		Edge(int src, int weight) {
			this.src = src;
			this.weight = weight;
		}

	}

	public static class Pair implements Comparable<Pair> {
		int src;
		int weight;
		int stop;

		Pair(int src, int weight, int stop) {
			this.src = src;
			this.weight = weight;
			this.stop = stop;
		}

		public int compareTo(Pair pair) {
			return this.weight - pair.weight;
		}
	}

	public static List<Edge>[] constructAdjList(int[][] flights, int n) {
		List<Edge>[] adjList = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			adjList[i] = new ArrayList<>();
		}
		for (int[] flight : flights) {
			int src = flight[0];
			int nbr = flight[1];
			int weight = flight[2];
			adjList[src].add(new Edge(src, nbr, weight));
		}
		return adjList;
	}

	public static int cheapestPriceDijkstra(List<Edge>[] adjList, int src, int dest, int k, int n) {
		PriorityQueue<Pair> queue = new PriorityQueue<>();
		boolean[] visited = new boolean[n];
		int price = 0;
		queue.offer(new Pair(src, price, k + 1));
		while (!queue.isEmpty()) {
			Pair pair = queue.poll();

			if (pair.src == dest)
				return pair.weight;
			if (pair.stop == 0)
				continue;
			price += pair.weight;

			if (visited[pair.src] == true) {
				continue;
			} else {
				visited[pair.src] = true;
			}
			List<Edge> edges = adjList[pair.src];
			for (Edge edge : edges) {
				if (visited[edge.nbr] == false) {
					int newPrice = edge.weight + pair.weight;
					queue.offer(new Pair(edge.nbr, newPrice, pair.stop - 1));
				}
			}
		}
		return -1;
	}

	public static int bellManFordFindChepesFlight(int[][] flights, int n, int k, int src, int dest) {
		// int[] dist=new int[n];
		int[] previous = new int[n];
		int[] current = new int[n];
		Arrays.fill(previous, Integer.MAX_VALUE);
		Arrays.fill(current, Integer.MAX_VALUE);
		previous[src] = 0;
		current[src] = 0;
		for (int iterations = 0; iterations < k + 1; iterations++) {
			for (int[] flight : flights) {
				int u = flight[0];
				int v = flight[1];
				int wt = flight[2];
				System.out.println("previouse >> " + previous[u] + " u >>" + u);
				if (previous[u] == Integer.MAX_VALUE) {
					continue;
				} else {
					current[v] = Math.min(current[v], previous[u] + wt);
				}
			}
			previous = current.clone();
		}

		System.out.println("print dist >> " + Arrays.toString(previous));
		if (previous[dest] == Integer.MAX_VALUE)
			return -1;
		return previous[dest];
	}

}