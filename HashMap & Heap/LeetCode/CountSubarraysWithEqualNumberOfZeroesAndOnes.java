import java.util.*;
public class CountSubarraysWithEqualNumberOfZeroesAndOnes {

	public static void main(String[] args){
		int[] nums={0,1,1,0,1,1};
		System.out.println(""+findMaxLength(nums));
	}

	public static int findMaxLength(int[] nums){
		HashMap<Integer,Integer> zeroOneFreqMap=new HashMap<>();
		zeroOneFreqMap.put(0,1);
		int prefixSum=0,frequency=0;
		for(int i=0;i<nums.length;i++){
			int num=nums[i];
			if(num==0) num=-1;
			prefixSum+=num;
			if(zeroOneFreqMap.containsKey(prefixSum)){
				frequency+=zeroOneFreqMap.get(prefixSum);
			}
			zeroOneFreqMap.put(prefixSum,zeroOneFreqMap.getOrDefault(prefixSum,0)+1);
		}
		return frequency;
    }
}