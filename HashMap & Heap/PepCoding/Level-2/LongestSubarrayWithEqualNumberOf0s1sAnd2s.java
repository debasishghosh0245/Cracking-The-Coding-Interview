import java.util.*;
public class LongestSubarrayWithEqualNumberOf0s1sAnd2s {
	
	public static void main(String[] args){
		int[] nums={0,1,0,2,0,1,0};
		System.out.println("Length >> "+largestSubarry(nums));
	}
	
	public static int largestSubarry(int[] nums){
		HashMap<String,Integer> map=new HashMap<>();
		int zero=0,one=0,two=0;
		int diffOneZero=0,diffTwoOne=0;
		String key="0#0";
		map.put(key,-1);
		int length=0;
		for(int i=0;i<nums.length;i++){
			int num=nums[i];
			if(num==0){
				zero++;
			}else if(num==1){
				one++;
			}else if(num==2){
				two++;
			}
			diffOneZero=one-zero;
			diffTwoOne=two-one;
			key=diffOneZero+"#"+diffTwoOne;
			if(map.containsKey(key)){
				System.out.println("From >>"+i+" To "+map.get(key));
				length=Math.max(length,i-map.get(key));
			}else{
				map.put(key,i);
			}
			
		}
		System.out.println("Map >> "+map);
		return length;
	}
}