import java.util.*;
public class SumOfSubarrayMinimums_907 {
	
	public static void main(String[] args){
		int[] nums={71,55,82,55};
		System.out.println("Sum of Subarray Minumus >> "+sumSubarrayMinsBestApproach(nums));
	}
	
	public static int sumSubarrayMins(int[] nums) {
		long sum=0;
		int[] nxtSmllrLeftIdxs=nextSmallerLeft(nums);
		int[] nextSmllrRightIdxs=nextSmallerRight(nums);
		for(int i=0;i<nums.length; i++){
			int left=i-nxtSmllrLeftIdxs[i];
			int right=nextSmllrRightIdxs[i]-i;
			System.out.println("for "+nums[i]+" left "+left+" Right >> "+right);
			sum+=(long)nums[i]*left*right%1000000007;
		}
		sum=sum%1000000007;
		return (int)sum;
    }
	
	public static int[] nextSmallerLeft(int[] nums){
		Stack<Integer> stack=new Stack<>();
		int[] result=new int[nums.length];
		for(int i=0;i<nums.length;i++){
			while(!stack.isEmpty() && nums[stack.peek()]>=nums[i]){
				stack.pop();
			}
			if(stack.isEmpty()){
				result[i]=-1;
			}else{
				result[i]=stack.peek();
			}
			stack.push(i);
		}
		return result;
	}
	
	public static int[] nextSmallerRight(int[] nums){
		Stack<Integer> stack=new Stack<>();
		int[] result=new int[nums.length];
		for(int i=nums.length-1;i>=0;i--){
			while(!stack.isEmpty() && nums[stack.peek()]>=nums[i]){
				stack.pop();
			}
			if(stack.isEmpty()){
				result[i]=nums.length;
			}else{
				result[i]=stack.peek();
			}
			stack.push(i);
		}
		return result;
	}
	
	//Time complexity: O(n2)
	public static int sumOfSubarrayMinsII(int[] nums){
		int sum=0;
		for(int i=0;i<nums.length;i++){
			int min=Integer.MAX_VALUE;
			for(int j=i;j<nums.length;j++){
				/* System.out.print("{"); */
				/* for(int k=i;k<=j;k++){
					System.out.print(nums[k]);
				} */
				min=Math.min(min,nums[j]);
				/* System.out.print("}"); */
				//System.out.println("Minmum >> "+min);
				sum+=min;
			}
			//System.out.println("Sum "+sum);
		}
		return sum;
	}
	
	
	
	public static int sumSubarrayMinsBestApproach(int[] nums){
		Stack<Integer> stack=new Stack<>();
		long result=0;
		stack.push(-1);
		for(int i=0;i<nums.length;i++){
			while(!stack.isEmpty() && stack.peek()!=-1
				&& nums[stack.peek()]>=nums[i]){
				int currElementIndex =stack.pop();
				result+=(long)nums[currElementIndex]*(currElementIndex-stack.peek())*(i-currElementIndex);
				}
			stack.push(i);
		}
		
		while(stack.peek()!=-1){
			int currElementIndex =stack.pop();
			result+=(long)nums[currElementIndex]*(currElementIndex-stack.peek())*(nums.length-currElementIndex);
		}
		result=result%1000000007;
		return (int)result;
	}
}