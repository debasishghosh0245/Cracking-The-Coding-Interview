import java.util.*;
public class KLargestElements {

	public static void main(String[] args){
		int[] arr={3,2,1,5,6,4};
		kLargetElement(arr,2);
	}
	
	public static void kLargetElement(int[] arr,int k){
		PriorityQueue<Integer> queue=new PriorityQueue<>();
		for(int i: arr){
			queue.add(i);
			if(queue.size()>k) {
				queue.remove();
			}
		}
		while(!queue.isEmpty()){
			System.out.println(queue.remove());
		}
	}

}