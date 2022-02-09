import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaximum {

  public static void main(String[] args) {
	  
	 int[] arr={1,3,-1,-3,5,3,6,7};
	 int k=3;
	 int[] result= maximumSlidingWindow(arr,k);
	 
  }
  
  public static void slidingWindowMaximum(int[] arr,int k) {
	  for(int i=0;i<arr.length-4;i++) {
		  int max=arr[i];
		  for(int j=i;j<=i+k;j++){
			 max=Math.max(max,arr[j]);
		  }
		 System.out.println(max); 
	  }  
  }
  
  public static int[] maximumSlidingWindow(int[] arr, int k) {
	  if (arr == null || k <= 0) {
		  return new int[0];
	  }
	  int n = arr.length;
	  int[] r = new int[n-k+1];
	  int ri = 0;
	  // store index
	  Deque<Integer> q = new ArrayDeque<>();
	  for (int i = 0; i < arr.length; i++) {
		  // remove numbers out of range k
		  while (!q.isEmpty() && q.peek() < i - k + 1) {
			  q.poll();
		  }
		  // remove smaller numbers in k range as they are useless
		  while (!q.isEmpty() && arr[q.peekLast()] < arr[i]) {
			  q.pollLast();
		  }
		  // q contains index... r contains content
		  q.offer(i);
		  if (i >= k - 1) {
			  r[ri++] = arr[q.peek()];
		  }
	  }
	  return r;
  }
}