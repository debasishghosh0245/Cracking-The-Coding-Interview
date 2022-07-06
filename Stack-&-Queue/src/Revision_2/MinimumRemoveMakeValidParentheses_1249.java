import java.util.*;
public class MinimumRemoveMakeValidParentheses_1249 {
	
	public static void main(String[] args){
		String str= "))((";
		System.out.println(minimumRemoveMakeValidParentheses(str));
	}
	
	public static String minimumRemoveMakeValidParentheses(String str){
		Stack<Integer> stack=new Stack<>();
		for(int i=0;i<str.length();i++){
			char ch=str.charAt(i);
			if(ch=='('){
				stack.push(i);
			}
			else if(ch==')'){
				if(!stack.isEmpty() && str.charAt(stack.peek())=='('){
					stack.pop();
				}
				else{
					stack.push(i);
				}
			}
			else{
				//do nothing for others
			}
		}
			
		StringBuilder sb=new StringBuilder(str);
		int i=0;
		for(int remove_idx: stack){
			sb.deleteCharAt(remove_idx-i);
			i++;
		}
		
		return sb.toString();
	}
}