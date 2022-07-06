import java.util.*;
public class FindPairWithGivenDifference {

	public static void main(String[] args){
		int[] arr={5,2,3,80,5,20};
		int target=78;
		findPair(arr,target);
	}
	
	public static void findPair(int[] nums,int target) {
		Arrays.sort(nums);
		int left=0;
		int right=left+1;
		while(left < nums.length && right < nums.length){
			if(nums[right]-nums[left]==target){
				System.out.println(nums[left]+" "+nums[right]);
				return;
			}
			else if((nums[right]-nums[left]) < target){
				right++;
			}
			else{
				left++;
			}
		}
	}
}