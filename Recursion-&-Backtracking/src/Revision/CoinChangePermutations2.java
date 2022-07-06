import java.util.*;
public class CoinChangePermutations2{
	
	public static void main(String[] args){
		int[] nums={2,3,5,6,7};
		List<Integer> path=new ArrayList<>();
		permutation(nums,12,path,0);
	}
	
	public static void permutation(int[] nums,
		int sum,List<Integer> path,int numsIdx){
		if(sum==0){
			System.out.println(path);
			return;
		}
		if(sum < 0 || numsIdx == nums.length){
			return;
		}
		for(int idx=0;idx<nums.length;idx++){
				path.add(nums[idx]);
				permutation(nums,sum-nums[idx],path,numsIdx+1);
				path.remove(path.size()-1);
			}
	}
}