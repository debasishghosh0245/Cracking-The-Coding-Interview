import java.util.*;
public class CountDistinctElementsInEveryWindowOfSizeK{
	
	public static void main(String[] args){
		int[] nums={1,2,1,3,4,2,3};
		int k=4;
		findDistinctElementInWindow(nums,k);
	}
	
	public static void findDistinctElementInWindow(int[] nums,int k){
		HashMap<Integer,Integer> windowFreqMap=new HashMap<>();
		int i=0;
		int j=0;
		while(i<k-1){
			windowFreqMap.put(nums[i],windowFreqMap.getOrDefault(nums[i],0)+1);
			i++;
		}
		while(i<nums.length) {
			windowFreqMap.put(nums[i],windowFreqMap.getOrDefault(nums[i],0)+1);
			System.out.println(windowFreqMap.size());
			if(windowFreqMap.get(nums[j])==1){
				windowFreqMap.remove(nums[j]);
			}else{
				windowFreqMap.put(nums[j],windowFreqMap.get(nums[j])-1);
			}
			j++; i++;
		}
	}
}