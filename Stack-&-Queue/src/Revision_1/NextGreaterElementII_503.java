import java.util.*;
public class NextGreaterElementII_503{
	
	public static void main(String[] args){
		int[] nums = {1,2,3,4,3};
		System.out.println(Arrays.toString(nextGreaterElements(nums)));
	}
	
	public static int[] nextGreaterElements(int[] nums) {
		int[] answer=new int[nums.length];
		Stack<Integer> stack=new Stack<>();
		for(int i=2*nums.length-1;i>=0;i--){
			while(!stack.isEmpty() 
				&& stack.peek() <= nums[i%nums.length]){
				stack.pop();
			}
			if(stack.isEmpty()){
				answer[i%nums.length]=-1;
			}else{
				answer[i%nums.length]=stack.peek();
			}
			stack.push(nums[i%nums.length]);
		}
		return answer;
    }


}