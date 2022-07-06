import java.util.*;
public class SlidingWindowMaximum_239 {
	
	public static void main(String[] args){
		/* int[] nums ={1,3,-1,-3,5,3,6,7}; int k = 3; */
		/* int[] nums ={7,2,4}; int k = 2; */
		int[] nums={1,3,1,2,0,5}; int k=3;
		System.out.println(Arrays.toString(maxSlidingWindow(nums,k)));
	}
	
	public  static int[] maxSlidingWindow(int[] nums, int k) {
		int[] result=new int[nums.length-k+1];
		int r=0;
		Deque<Integer> queue=new ArrayDeque<>();
		for(int i=0;i<k;i++){
			while(!queue.isEmpty() && nums[i]>nums[queue.peekLast()]){
				queue.pollLast();
			}
			queue.add(i);
		}
		result[r++]=nums[queue.peek()];
	
		for(int i=k;i<nums.length;i++){
			while(!queue.isEmpty() && queue.peek()==i-k){
				queue.pollFirst();
			}
			while(!queue.isEmpty() && nums[i]>nums[queue.peekLast()]){
				queue.pollLast();
			}
			queue.offer(i);
			result[r++]=nums[queue.peek()];
		}
		return result;
	}
}


