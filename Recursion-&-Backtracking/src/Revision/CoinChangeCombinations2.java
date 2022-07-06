import java.util.*;
public class CoinChangeCombinations2{
	
	public static void main(String[] args){
		//int[] nums={2,3,5};
		int[] nums={2,3,5,6,7};
		int target=12;
		List<Integer> path=new ArrayList<>();
		List<List<Integer>> result=new ArrayList<>();
		System.out.println(coinChangeCombination(nums,nums.length-1,target,path,result));
	}
	
	//Time Complexity  :O(2^tn)
	//Space Complexity :O(n)
	public static List<List<Integer>> coinChangeCombination(int[] nums,int idx,
		int sum,List<Integer> path,List<List<Integer>> finalResult){
		if(idx < 0 ){
			if(sum==0){
				finalResult.add(new ArrayList<>(path));
			}	
			return finalResult;
		}
		if(sum >= nums[idx]){
			path.add(nums[idx]);
			coinChangeCombination(nums,idx,sum-nums[idx],path,finalResult);
			path.remove(path.size()-1);
		}
		coinChangeCombination(nums,idx-1,sum,path,finalResult);
		return finalResult;
	}
} 