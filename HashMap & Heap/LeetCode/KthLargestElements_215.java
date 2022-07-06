import java.util.*;
public class KthLargestElements_215 {

	public static void main(String[] args){
		int[] arr={3,2,1,5,6,4};
		kthLargetElement(arr,2);
	}
	
	public static void kthLargetElement(int[] arr,int k){
		PriorityQueue<Integer> queue=new PriorityQueue<>();
		for(int i: arr){
			queue.add(i);
			if(queue.size()>k){
				queue.remove();
			}
		}
		System.out.println(queue.remove());
	}
}