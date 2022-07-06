import java.util.*;
public class NextSmallerElementToTheLeft{
	
	public static void main(String[] args){
		int[] nums={2,5,9,3,1,12,6,8,7};
		System.out.println(Arrays.toString(nextSmallerElementLeft(nums)));
	}
	
	public static int[] nextSmallerElementLeft(int[] nums){
		Stack<Integer> stack=new Stack<>();
		int[] answer=new int[nums.length];
		for(int i=0;i<nums.length;i++){
			while(!stack.isEmpty() 
				&& stack.peek() > nums[i]){
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