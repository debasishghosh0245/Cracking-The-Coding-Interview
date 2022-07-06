import java.util.*;
public class MinimumRemoveMakeValidParentheses_1249{

	public static void main(String[] args){
		String str="))((";
		System.out.println(minRemoveToMakeValid(str));
	}
	
	public static String minRemoveToMakeValid(String str) {
        Stack<Integer> stack=new Stack<Integer>();
		for(int i=0;i<str.length();i++){
			char ch=str.charAt(i);
			if(ch=='('){
				stack.push(i);
			}
			else if(ch==')'){
				if(!stack.isEmpty() && str.charAt(stack.peek())=='('){
					stack.pop();
				}else{
					stack.push(i);
				}
			}
		}
		if(stack.isEmpty()){
			return str;
		}
		StringBuilder sb=new StringBuilder(str);
		while(!stack.isEmpty()){
			int remove_index=stack.pop();
			sb.deleteCharAt(remove_index);
		}
		return sb.toString();
    }

}