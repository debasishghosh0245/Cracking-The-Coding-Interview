import java.util.*;
public class SumOfSubarrayRanges_2104 {
	
	public static void main(String[] args){
		int[] nums={4,-2,-3,4,1};
		int res=sumSubarrayMax(nums)-sumSubarrayMins(nums);
		System.out.println("Sum of Sumarray Range "+res);
	}
	
	public static int sumSubarrayMins(int[] nums){
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
	
	public static int sumSubarrayMax(int[] nums){
		Stack<Integer> stack=new Stack<>();
		long result=0;
		stack.push(-1);
		for(int i=0;i<nums.length;i++){
			while(!stack.isEmpty() && stack.peek()!=-1
				&& nums[stack.peek()]<=nums[i]){
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