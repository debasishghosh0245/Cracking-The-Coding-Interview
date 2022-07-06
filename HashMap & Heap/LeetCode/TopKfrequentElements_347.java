import java.util.*;
public class TopKfrequentElements_347{
	
	public static void main(String[] args){
		int[] nums = {5,5,5,20,20,30}; int k = 2;
		System.out.println(Arrays.toString(topKFrequent(nums,k)));
	}
	
	public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> hashMap=new HashMap<>();
		for(int i:nums){
			hashMap.put(i,hashMap.getOrDefault(i,0)+1);
		}
		PriorityQueue<int[]> heap = new PriorityQueue<>((n1,n2)->-n2[0]-n1[0]);
		for(Map.Entry<Integer,Integer> entry:hashMap.entrySet()){
			heap.add(new int[]{entry.getValue(),entry.getKey()});
			if(heap.size()>k){
				heap.poll();
			}
		}
		int[] top = new int[k];
		for(int j=0;j<k;j++){
			top[j]=heap.poll()[1];
		}
		return top;
    }
}