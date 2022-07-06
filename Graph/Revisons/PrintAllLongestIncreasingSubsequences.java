import java.util.*;
public class PrintAllLongestIncreasingSubsequences {

	public static void main(String[] args) {
		int[] nums={52,9,11,56,23,59,18,91,28,41,1,30,14};
		printAllLIS(nums,nums.length-1);
	}

	public static List<Integer> printAllLIS(int[] nums,int idx){
		if(idx==0){
			List<Integer> list=new ArrayList<Integer>();
			list.add(nums[0]);
			return list;
		}
		List<Integer> take=null;
		List<Integer> not_take=null;
		if(nums[idx] > nums[idx-1]){
			take=printAllLIS(nums,idx-1);
		}
			not_take=printAllLIS(nums,idx-1);
		System.out.println(take);
		System.out.println(not_take);
		if(take.size() > not_take.size()){
			return take;
		}
		else{
			return not_take;
		}
	}
}