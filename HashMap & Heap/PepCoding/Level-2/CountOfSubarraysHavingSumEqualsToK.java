import java.util.*;
public class CountOfSubarraysHavingSumEqualsToK {
	
	public static void main(String[] args){
		int[] nums={1,1,1};
		int k=2;
		System.out.println("Count >> "+subarraySum(nums,k));
	}
	
	public static int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> sumFrqMap=new HashMap<>();
		sumFrqMap.put(0,1);
		int sum=0;
		int count=0;
		int i=0;
		while(i<nums.length){
			sum+=nums[i++];
			if(sumFrqMap.containsKey(sum-k)){
				count+=sumFrqMap.get(sum-k);
			}
			sumFrqMap.put(sum,sumFrqMap.getOrDefault(sum,0)+1); 
		}
		return count;
    }


}