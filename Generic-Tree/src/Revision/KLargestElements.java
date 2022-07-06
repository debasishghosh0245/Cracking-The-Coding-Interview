import java.util.*;
public class KLargestElements {

	public static void main(String[] args){
		int[] arr={13,12 ,62,22,15,37,99,11,37,98,67,31,84,99};
		kLargetElement(arr,4);
	}
	
	public static void kLargetElement(int[] arr,int k){
		PriorityQueue minQueue=new PriorityQueue<>();
		for(int i: arr){
			if(minQueue.size()>=k){
				minQueue.remove();
			}
			minQueue.add(i);
		}
		while(!minQueue.isEmpty()){
			System.out.println(minQueue.remove());
		}
	}

}