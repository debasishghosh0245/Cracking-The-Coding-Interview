import java.util.Stack;
public class NumberOfValidSubarrays_1063 {

    public static void main(String[] args){
		//int[] nums = {1,4,2,5,3};
		//int[] nums = {3,2,1};
		int[] nums={2,2,2};
		System.out.println(validSubarrays(nums));
	}
	
	public static int validSubarrays(int[] nums) {
		int result=0;
		int[] output=nextSmallerRight(nums);
		for(int i=0;i<nums.length;i++) {
			result+=output[i]-i;
		}
		return result;
    }
	
	public static int[] nextSmallerRight(int[] nums){
		Stack<Integer> stack=new Stack<>();
		int[] result=new int[nums.length];
		for(int i=nums.length-1;i>=0;i--) {
			while(!stack.isEmpty() && nums[stack.peek()] >= nums[i]){
				stack.pop();
			}
			if(stack.isEmpty()) {
				result[i]=nums.length;
			}else{
				result[i]=stack.peek();
			}
			stack.push(i);
		}
		return result;
	}


}