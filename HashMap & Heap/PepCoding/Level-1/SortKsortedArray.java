import java.util.*;
public class SortKsortedArray{

	public static void main(String[] args){
		int[] arr={3,2,4,1,6,5,7,9,8};
		int k=3;
		sortKSortedArray(arr,k);
	}
	
	//Time Complexity :O(nLogK)
	//Space Complexity:O(k)
	public static void sortKSortedArray(int[] arr,int k){
		PriorityQueue<Integer> heap=new PriorityQueue<>();
		for(int i:arr){
			heap.offer(i);
			if(heap.size()>k){
				System.out.println(heap.poll());
			}
		}
		while(!heap.isEmpty()){
		    System.out.println(heap.poll());
		}
	}
}