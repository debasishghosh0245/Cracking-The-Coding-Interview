import java.util.*;
public class CombinationSumIII_216 {
	public static void main(String[] args) {
		int n=1;
		int k=4;
		System.out.println(combinationSum3(k,n));
	}
	
	public static List<List<Integer>> combinationSum3(int k, int n) {
		int[] nums={1,2,3,4,5,6,7,8,9};
        return helper(nums,0,0,n,0,k,new ArrayList<Integer>(),new ArrayList<List<Integer>>());	
    }
	
	public static List<List<Integer>> helper(int[] nums,int idx,int amtsf,int amt,
	int numOfChoice,int totalChoice,List<Integer> ansf,List<List<Integer>> output){
		if(idx==nums.length) {
			if(amtsf==amt && numOfChoice==totalChoice){	
				output.add(new ArrayList<>(ansf));
			}
			return output;
		}
		ansf.add(nums[idx]);
		helper(nums,idx+1,amtsf+nums[idx],amt,numOfChoice+1,totalChoice,ansf,output);
		ansf.remove(ansf.size()-1);
		helper(nums,idx+1,amtsf,amt,numOfChoice,totalChoice,ansf,output);
		return output;
    }
}