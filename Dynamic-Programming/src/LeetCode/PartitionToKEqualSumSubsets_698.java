import java.util.*;
public class PartitionToKEqualSumSubsets_698{
	
	public static void main(String[] args){
		int[] nums={4,3,2,3,5,2,1};
		int k=4;
		System.out.println(canPartition(nums,k));
	}
	
	public static boolean canPartition(int[] nums,int k){
		int total_sum=Arrays.stream(nums).sum();
		System.out.println("Total Sum >> "+total_sum);
		if(total_sum%k!=0) return false;
		else{
			int subsets=countSubSet(nums,nums.length-1,total_sum/k);
			System.out.println(subsets);
			return subsets==k;
		}
	}
	
	//Apprach : Recursive 
	//Time Complexity  :
	//Space Complexity :
	public static int countSubSet(int[] nums,int idx,int sum){
		if(sum==0) return 1;
		if(idx==0){
			if(sum==nums[idx]) return 1;
			else return 0;
		}
		return countSubSet(nums,idx-1,sum)+countSubSet(nums,idx-1,sum-nums[idx]);
	}

}