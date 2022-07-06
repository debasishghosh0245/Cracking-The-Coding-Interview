import java.util.*;
public class LongestSubarrayWithSumDivisibleByK {
	
	public static void main(String[] args){
		int[] nums={2,7,6,1,4,5};
		int k=3;
		System.out.println("Maximum Length >> "+subarraysDivByK(nums,k));
	}
	
	public static int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer,Integer> remIdxMap=new HashMap<>();
		remIdxMap.put(0,-1);
		int prefixSum=0;
		int maxLength=0;
		for(int i=0;i<nums.length;i++){
			int num=nums[i];
			prefixSum+=num;
			int rem=prefixSum%k;
			if(rem<0) rem+=k;
			if(remIdxMap.containsKey(rem)){
				maxLength=Math.max(maxLength,(i-remIdxMap.getOrDefault(rem,0)));
			}else{
				remIdxMap.put(rem,i);
			}
		}
		return maxLength;
    }
}