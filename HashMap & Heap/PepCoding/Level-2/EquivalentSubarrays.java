import java.util.*;
public class EquivalentSubarrays{
	
	public static void main(String[] args){
		int[] nums={2,1,3,2,3};
		System.out.println("Count >> "+countOfEquivalentSubarrays(nums));
	}
	
	public static int countOfEquivalentSubarrays(int[] nums){
		HashSet<Integer> set=new HashSet<>();
		HashMap<Integer,Integer> map=new HashMap<>();
		int i=0,j=0,count=0;
		for(int num: nums){
			set.add(num);
		}
		while(true){
			boolean flag1=false;
			boolean flag2=false;
			while(i<nums.length){
				flag1=true;
				int num=nums[i++];
				map.put(num,map.getOrDefault(num,0)+1);
				if(map.size()==set.size()){
					count+=nums.length-(i-1);
					break;
				}
			}
			while(map.size()==set.size()){
				flag2=true;
				int num=nums[j++];
				if(map.getOrDefault(num,0)==1){
					map.remove(num);
				}else{
					map.put(num,map.getOrDefault(num,0)-1);
				}
			}
			if(flag1==false && flag2==false){
				break;
			}
		}
		return count;
	}
}