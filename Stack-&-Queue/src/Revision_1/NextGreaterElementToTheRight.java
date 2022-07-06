import java.util.*;
public class NextGreaterElementToTheRight {

	public static void main(String[] args){
		int[] nums={5,5,3,8,2,7};
		System.out.println(Arrays.toString(nextGreaterElementToRight(nums)));
	}
	
	public static int[] nextGreaterElementToRight(int[] nums){
		Stack<Integer> stack=new Stack<>();
		int[] answer=new int[nums.length];
		for(int i=nums.length-1;i>=0;i--){
			while(!stack.isEmpty() && 
				stack.peek() < nums[i]){
				stack.pop();
			}
			if(stack.isEmpty()){
				answer[i]=-1;
			}else{
				answer[i]=stack.peek();
			}
			stack.push(nums[i]);
		}
		return answer;
	}


}