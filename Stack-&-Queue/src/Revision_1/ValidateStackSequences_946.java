import java.util.*;
public class ValidateStackSequences_946{
	
	public static void main(String[] args){
		 int[] pushed ={1,2,3,4,5};
		int[] popped = {4,3,5,1,2}; 
		//int[] pushed ={2,1,0};
		//int[] popped ={1,2,0};
		System.out.println(validateStackSequences(pushed,popped));
	}
	
	public static boolean validateStackSequences(int[] pushed, int[] popped) {
		int j=0;
		Stack<Integer> stack=new Stack<>();
		for(int i=0;i<pushed.length;i++){
			stack.push(pushed[i]);
			while(!stack.isEmpty() && stack.peek()==popped[j]){
				stack.pop();
				j++;
			}
		}
		return j==popped.length;
    }
}