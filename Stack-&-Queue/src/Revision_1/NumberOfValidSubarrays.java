import java.util.*;
public class NumberOfValidSubarrays{
	
	public static void main(String[] args){
		//int[] nums={2,2,2};
		int[] nums={1,4,2,5,3};
		System.out.println("count Valid Sub-Arrays >> "+validSubarrays(nums));
	}
	
	public static int validSubarrays(int[] nums) {
       int count=0;
	   int[] result=nextSmallerRight(nums);
	   for(int i=0;i<result.length;i++){
		   count+=result[i]-i;
	   }
	   return count;
    }
	
	public static int[] nextSmallerRight(int[] nums){
		Stack<Integer> stack=new Stack<>();
		int[] result=new int[nums.length];
		for(int i=nums.length-1;i>=0;i--){
			while(!stack.isEmpty() 
				&& nums[stack.peek()]>=nums[i]){
				stack.pop();
			}
			if(!stack.isEmpty()){
				result[i]=stack.peek();
			}
			else{
				result[i]=nums.length;
			}
			stack.push(i);
		}
		return result;
	}

}