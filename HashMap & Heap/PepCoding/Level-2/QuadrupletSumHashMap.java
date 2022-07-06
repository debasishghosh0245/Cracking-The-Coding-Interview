import java.util.*;
public class QuadrupletSumHashMap{
	
	public static void main(String[] args){
		int[] nums ={-5,4,-6,-8,3,-3,-7,2,-10,-3,9,10,-1,5,-7,-8,-6,9,-2,9};
		System.out.println(fourSum(nums,10,0,nums.length-1));
	}
	
	public static List<List<Integer>> fourSum(int[] nums,int target,
		int low,int high){
		List<List<Integer>> ans=new ArrayList<List<Integer>>();
		for(int i=0;i<nums.length;i++){
			while(i-1>=0 && nums[i]==nums[i-1]){
				i++;
			}
			Set<List<Integer>> result=threeSum(nums,target-nums[i],i+1,nums.length-1);
			if(result.size()>0){
				for(List<Integer> list : result){
				    list.add(0,nums[i]);
				}
				ans.addAll(result);
			}
		}
		return ans;
	}
	
	public static Set<List<Integer>> threeSum(int[] nums,int target,
		int low,int high){
		Set<List<Integer>> ans=new HashSet<List<Integer>>();
		for(int i=low;i<nums.length;i++){
			while(i-1>=0 && nums[i]==nums[i-1]){
				i++;
			}
			Set<List<Integer>> result=twoSum(nums,target-nums[i],i+1,nums.length-1);
			if(result.size()>0){
				for(List<Integer> list : result){
				    list.add(0,nums[i]);
				}
				ans.addAll(result);
			}
		}
		return ans;
	}
	
	public static Set<List<Integer>> twoSum(int[] nums,int target,
		int low,int high) {
		Set<List<Integer>> ans=new HashSet<List<Integer>>();
		HashSet<Integer> seen=new HashSet<>();
		for(int i=low;i<=high;i++){
			if(seen.contains(target-nums[i])){
				List<Integer> list=new ArrayList<>();
				list.add(nums[i]);
				list.add(0,target-nums[i]);
				ans.add(list);
			}
			seen.add(nums[i]);
		}
		return ans;
	}
}