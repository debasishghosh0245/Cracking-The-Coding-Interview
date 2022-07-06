import java.util.*;
public class FindKClosestElements_658{
	
	public static void main(String[] args){
		int[] arr ={1,5,10}; 
		int k=1;
		int x=4;
		System.out.println(findClosestElements(arr,k,x));
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
		int mid=0;
		List<Integer> result=new ArrayList<Integer>();
		while(high >= low){
			mid=low+(high-low)/2;
			if(nums[mid]==x){
				break;
			}
			else if(nums[mid] < x){
				low=mid+1;
			}else{
				high=mid-1;
			}
		}
		System.out.println("middle >> "+mid);
		//initialized the sliding window
		low=low-1;
		high=low+1;
		
		while(low >= 0 && high < nums.length && k!=0){
			if(Math.abs(x-nums[high]) < Math.abs(x-nums[low])) {
				result.add(nums[high]);
				high++;
			}
			else if(Math.abs(x-nums[low]) < Math.abs(x-nums[high])) {
				result.add(nums[low]);
				low--;
			}
			else{
				result.add(nums[low]);
				low--;
			}
			k--;
		}
		
		while(k!=0 && low>=0){
			result.add(nums[low]);
			low--;
			k--;
		}
		
		while(k!=0 && high<nums.length){
			result.add(nums[high]);
			high++;
			k--;
		}
		
		Collections.sort(result);
		return result;
    }
}