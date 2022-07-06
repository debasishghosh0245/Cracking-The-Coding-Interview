import java.util.*;
public class RemoveOutermostParentheses_1021{
	
	public static void main(String[] args){
		//String str="(())";
		//String str="(()())(())(()(()))";
		//String str="()()";
		System.out.println(removeOutermostParenthesesWithoutSpace(str));
	}
	
	public static String removeOutermostParentheses(String str){
		Stack<Character> stack=new Stack<>();
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<str.length();i++){
			char ch=str.charAt(i);
			if(ch==')'){
				//if stack contains more than open opening parenthesis
				//copy closing parenthis into final result
				if(!stack.isEmpty() && stack.peek()=='(' && stack.size()>1){
					sb.append(ch);
					stack.pop();
				}else{
					// if tha stack contains only one opening parenthis
					//just pop is becase this is closing parenthis
					stack.pop();
				}
			}else if(ch=='('){
				stack.push(ch);
				//if stack contains more than one opening parenthesis
				//copy that character in result 
				if(stack.size()>1){
					sb.append(ch);
				}
			}
		}
		return sb.toString();
	}
	
	public static String removeOutermostParenthesesWithoutSpace(String str){
		StringBuilder sb=new StringBuilder();
		int bal=0;
		for(int i=0;i<str.length();i++){
			char ch=str.charAt(i);
			if(ch==')'){
				bal--;
				if(bal>0) sb.append(ch);
			}else if(ch=='('){
				bal++;
				if(bal>1) sb.append(ch);
			}
			
		}
		return sb.toString();
	}

}