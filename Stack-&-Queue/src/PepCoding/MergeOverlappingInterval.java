import java.util.*;
public class MergeOverlappingInterval{
	
	public static void main(String[] args){
		int[][] times={{22,28},{1,8},{25,27},{14,19},{27,30},{5,12}};
		//sorting 2D array 
		Arrays.sort(times,new Comparator<int[]>(){
			public int compare(int[] a,int[] b){
				return Integer.compare(a[0],b[0]);
			}
		});
		System.out.println(times);
		mergeOverlappingIntervals(times);
	}
	
	public static class Pair{
		int startTime;
		int endTime;
		Pair(int startTime,int endTime){
			this.startTime=startTime;
			this.endTime=endTime;
		}
		public String toString(){
			return "Start Time >> "+this.startTime+" End Time "+this.endTime;
		}
	}

	public static void mergeOverlappingIntervals(int[][] arr) {
		Stack<Pair> stack=new Stack<>();
        for(int i=0;i<arr.length;i++){
			if(!stack.isEmpty() && arr[i][0] > stack.peek().startTime 
				&& arr[i][0] < stack.peek().endTime){
				int startTime=Math.min(stack.peek().startTime,arr[i][0]);
				int endTime=Math.max(stack.peek().endTime,arr[i][1]);
				stack.pop();
				Pair pair=new Pair(startTime,endTime);
				stack.push(pair);
			}else{
				Pair pair=new Pair(arr[i][0],arr[i][1]);
				stack.push(pair);
			}
		}
		for(Pair pair:stack){
			System.out.println(pair.startTime+""+pair.endTime);
		}
    }
}