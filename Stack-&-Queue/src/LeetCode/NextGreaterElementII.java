import java.util.Arrays;
import java.util.Stack;
public class NextGreaterElementII{
    
	public static void main(String[] args) {
        int[] nums={5,4,3,2,1};
		int[] output=nextGreaterElements(nums);
		System.out.println(Arrays.toString(output));
    }
	
	public static int[] nextGreaterElements(int[] nums) {
         Stack<Integer> stack=new Stack<>();
		 int[] result=new int[nums.length];
		 for(int i=nums.length-2;i>=0;i--){
			 while(!stack.isEmpty() && stack.peek() <= nums[i] ){
				 stack.pop();
			 }
			 if(!stack.isEmpty()){
				result[i]=stack.peek(); 
			 }else{
				result[i]=-1;
			 }
			 stack.push(nums[i]); 	 
		 }
		 
		 for(int i=nums.length-1;i>=0;i--){
			 while(!stack.isEmpty() && stack.peek() <= nums[i] ){
				 stack.pop();
			 }
			 if(!stack.isEmpty()){
				result[i]=stack.peek(); 
			 }else{
				result[i]=-1;
			 }
			 stack.push(nums[i]); 	 
		 }
		
		
		 return result;
    }
}
