import java.util.*;
public class QuadrupletSum{
	
	public static void main(String[] args){
		int[] nums ={-2, -1, 0, 0, 1,2};
		System.out.println(fourSum(nums,0,0,nums.length-1));
		
	}
	
	public static List<List<Integer>> fourSum(int[] nums,int target,
		int low,int high){
		List<List<Integer>> ans=new ArrayList<List<Integer>>();
		for(int i=0;i<nums.length;i++){
			while(i-1>=0 && nums[i]==nums[i-1]){
				i++;
			}
			List<List<Integer>> result=threeSum(nums,target-nums[i],i+1,nums.length-1);
			if(result.size()>0){
				for(List<Integer> list : result){
				    list.add(0,nums[i]);
				}
				ans.addAll(result);
			}
		}
		return ans;
	}
	
	public static List<List<Integer>> threeSum(int[] nums,int target,
		int low,int high){
		List<List<Integer>> ans=new ArrayList<List<Integer>>();
		for(int i=low;i<nums.length;i++){
			while(i-1>=0 && nums[i]==nums[i-1]){
				i++;
			}
			List<List<Integer>> result=twoSum(nums,target-nums[i],i+1,nums.length-1);
			if(result.size()>0){
				for(List<Integer> list : result){
				    list.add(0,nums[i]);
				}
				ans.addAll(result);
			}
		}
		return ans;
	}
	
	public static List<List<Integer>>  twoSum(int[] nums,int target,
		int low,int high) {
		List<List<Integer>> ans=new ArrayList<List<Integer>>();
		while(low < high){
			int sum=nums[low]+nums[high];
			if(target==sum) {
				List<Integer> list=new ArrayList<>();
				list.add(nums[low]);
				list.add(nums[high]);
				ans.add(list);
				low++;
				high--;
				while(low<high && nums[low]==nums[low-1]){
					low++;
				}
				while(low<high && nums[high]==nums[high-1]){
					high--;
				}
			}else if(target > sum){
				low++;
			}else {
				high--;
			}
		}
		return ans;
	}

}