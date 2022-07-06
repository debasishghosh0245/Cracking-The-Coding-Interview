import java.util.*;
public class ThreeSum15{
	
	public static void main(String[] args){
		int[] nums ={-4, -1, -1, 0, 1, 2};
		List<List<Integer>> ans=new ArrayList<List<Integer>>();
		for(int i=0;i<nums.length;i++){
			while(i-1>=0 && nums[i]==nums[i-1]){
				i++;
			}
			List<List<Integer>> result=twoSum(nums,0-nums[i],i+1,nums.length-1);
			if(result.size()>0){
				for(List<Integer> list : result){
				    list.add(i);
				}
				ans.addAll(result);
			}
		}
		System.out.println(ans);
	}
	
	public static List<List<Integer>>  twoSum(int[] nums,int target,
		int start,int end) {
		List<List<Integer>> ans=new ArrayList<List<Integer>>();
		while(start < end){
			int sum=nums[start]+nums[end];
			if(target==sum) {
				List<Integer> list=new ArrayList<>();
				list.add(start);
				list.add(end);
				ans.add(list);
				start++;
				end--;
			}else if(target > sum){
				start++;
			}else {
				end--;
			}
		}
		return ans;
	}

}