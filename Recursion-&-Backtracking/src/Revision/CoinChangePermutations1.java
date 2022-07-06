import java.util.*;
public class CoinChangePermutations1{
	
	public static void main(String[] args){
		int[] nums={2,3,5,6,7};
		boolean[] visited=new boolean[nums.length];
		List<Integer> path=new ArrayList<>();
		permutation(nums,visited,12,path,0);
	}
	
	public static void permutation(int[] nums,boolean[] visited,
		int sum,List<Integer> path,int numsIdx){
		if(sum==0){
			System.out.println(path);
			return;
		}
		if(sum < 0 || numsIdx == nums.length){
			return;
		}
		for(int idx=0;idx<nums.length;idx++){
			if(visited[idx]==false){
				path.add(nums[idx]);
				visited[idx]=true;
				permutation(nums,visited,sum-nums[idx],path,numsIdx+1);
				path.remove(path.size()-1);
				visited[idx]=false;
			}
		}
	}
}