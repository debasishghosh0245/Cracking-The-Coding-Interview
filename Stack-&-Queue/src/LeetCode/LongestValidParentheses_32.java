import java.util.Stack;
public class LongestValidParentheses_32{
    
	public static void main(String[] args){
		 //String str= ")()())";
		 //String str="(()";
		 //String str="()(()()";
		 String str="()()()";
		System.out.println(longestValidParentheses(str));
	}
	
	public static int longestValidParentheses(String str) {
		int result=0;
        Stack<Integer> stack=new Stack<>();
		stack.push(-1);
		for(int i=0;i<str.length();i++){
			char ch=str.charAt(i);
			if(!stack.isEmpty() && stack.peek()!=-1 
			    && str.charAt(stack.peek())=='(' && ch==')'){
				stack.pop();
				result=Math.max(result,i-stack.peek());
			}else{
				stack.push(i);
			}
			
		}
		return result;
    }
}