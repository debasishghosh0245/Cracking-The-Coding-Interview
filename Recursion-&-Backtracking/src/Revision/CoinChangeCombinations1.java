import java.util.*;
public class CoinChangeCombinations1{
	
	public static void main(String[] args){
		int[] nums={2,3,5};
		List<Integer> path=new ArrayList<>();
		List<List<Integer>> result=new ArrayList<>();
		System.out.println(coinChangeCombination(nums,nums.length-1,5,path,result));
	}
	
	public static List<List<Integer>> coinChangeCombination(int[] nums,int idx,
		int sum,List<Integer> path,List<List<Integer>> finalResult){
		if(idx < 0 ){
			if(sum==0){
				finalResult.add(new ArrayList<>(path));
			}	
			return finalResult;
		}

		path.add(nums[idx]);
		coinChangeCombination(nums,idx-1,sum-nums[idx],path,finalResult);
		path.remove(path.size()-1);
		coinChangeCombination(nums,idx-1,sum,path,finalResult);
		
		return finalResult;
	}
} 