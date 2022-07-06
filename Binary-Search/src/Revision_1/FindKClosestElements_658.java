import java.util.*;
public class FindKClosestElements_658{
	
	public static void main(String[] args){
		int[] arr ={1,2,3,4}; 
		int k=4;
		int x=3;
		System.out.println(findClosestElementsII(arr,k,x));
	}
	
	public static class Pair implements Comparable<Pair>{
		int differnce;
		int index;
		Pair(int differnce,int index){
			this.differnce=differnce;
			this.index=index;
		}
		public int compareTo(Pair pair){
			if(this.differnce==pair.differnce){
				return this.index-pair.index;
			}else{
				return this.differnce-pair.differnce;
			}
		}
		public String toString(){
			return this.differnce+" "+this.index;
		}
	}
	
	public static List<Integer> findClosestElementsII(int[] nums,int k,int x) {
		List<Integer> result=new ArrayList<Integer>();
		PriorityQueue<Pair> maxHeap=new PriorityQueue<>(Collections.reverseOrder());
		for(int i=0;i<nums.length;i++){
			Pair pair=new Pair(Math.abs(x-nums[i]),i);
			maxHeap.offer(pair);
			if(maxHeap.size()>k){
				System.out.println("Out >> "+maxHeap.poll().differnce);
			}
		}
		while(!maxHeap.isEmpty()){
			result.add(nums[maxHeap.poll().index]);
		}
		Collections.sort(result);
		return result;
    }
	
	public static List<Integer> findClosestElements(int[] nums,int k,int x) {
		int low=0;
		int high=nums.length-1;
		List<Integer> result=new ArrayList<Integer>();
		while(high > low){
			int mid=low+(high-low)/2;
			System.out.println("Mid >>"+mid);
			if(nums[mid]==k){
				result.add(nums[mid]);
				while(mid>0 && Math.abs(nums[mid--]-k)<=Math.abs(x-nums[mid])){
					result.add(0,nums[mid]);
				}
				return result;
			}
			else if(nums[mid] < k){
				low=mid+1;
			}else{
				high=mid-1;
			}
		}
		return result;
    }
}