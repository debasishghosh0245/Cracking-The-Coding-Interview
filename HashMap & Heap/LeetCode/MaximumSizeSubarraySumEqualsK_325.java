import java.util.*;
public class MaximumSizeSubarraySumEqualsK_325{
	
	public static void main(String[] args){
		int[] nums={1,-1,5,-2,3};
		int k=3; 
		/* int[] nums={1,1,0};
		int k=1; */
		System.out.println("Maximum Length >> "+subarrSumEqualsK(nums,k));
	}
	
	public static int subarrSumEqualsK(int[] nums,int k){
        HashMap<Integer,Integer> sumIdxMap=new HashMap<>();
		sumIdxMap.put(0,-1);
		int prefixSum=0,
		length=0;
		for(int i=0;i<nums.length;i++) {
			prefixSum+=nums[i];
			if(sumIdxMap.containsKey(prefixSum-k)){
				length=Math.max(length,i-sumIdxMap.get(prefixSum-k));
			}
			if(!sumIdxMap.containsKey(prefixSum)){
				sumIdxMap.put(prefixSum,i);
			}
		}
		return length;
    }
}