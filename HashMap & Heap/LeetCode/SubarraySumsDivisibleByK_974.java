import java.util.*;
public class SubarraySumsDivisibleByK_974 {
	
	public static void main(String[] args){
		int[] nums={2,7,6,1,4,5};
		int k=3;
		System.out.println("Maximum Length >> "+subarraysDivByK(nums,k));
	}
	
	public static int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer,Integer> remFreqMap=new HashMap<>();
		remFreqMap.put(0,1);
		int prefixSum=0;
		int count=0;
		for(int i=0;i<nums.length;i++){
			int num=nums[i];
			prefixSum+=num;
			int rem=prefixSum%k;
			if(rem<0) rem+=k;
			if(remFreqMap.containsKey(rem)){
				count+=remFreqMap.get(rem);
			}
			remFreqMap.put(rem,remFreqMap.getOrDefault(rem,0)+1);
		}
		return count;
    }




}