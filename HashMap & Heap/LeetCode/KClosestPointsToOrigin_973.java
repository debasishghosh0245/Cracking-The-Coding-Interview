import java.util.*;
public class KClosestPointsToOrigin_973{
	
	public static int[][] kClosest(int[][] points, int k) {
		PriorityQueue<Pair> maxPQ=new PriorityQueue<>();
		for(int i=0;i<points.length;i++){
			int dist=squaredDistance(points[i]);
			Pair pair=new Pair(points[i],dist);
			maxPQ.offer(pair);
			while(maxPQ.size()>k){
				maxPQ.remove();
			}
		}
		
		int[][] answer = new int[k][2];
        for (int i = 0; i < k; i++) {
            Pair entry = maxPQ.poll();
            //System.out.println(Arrays.toString(entry.point));
			answer[i]=entry.point;
        }
        return answer;
    }
	
	public static class Pair implements Comparable<Pair>{
		int[] point;
		int dist;
		Pair(int[] point,int dist){
			this.point=point;
			this.dist=dist;
		}
		public int compareTo(Pair pair){
			return pair.dist-this.dist;
		}
	}
	
	public static int squaredDistance(int[] point){
		int dist=point[0]*point[0]+point[1]*point[1];
		return dist;
	}

	public static void main(String[] args){
		/* int[][] points={{3,3},{5,-1},{-2,4}};
		int k = 2; */
		int[][] points={{1,3},{-2,2}};
		int k = 1;
		int[][] result=kClosest(points,k);
		System.out.println(Arrays.toString(result[0]));
	}


}