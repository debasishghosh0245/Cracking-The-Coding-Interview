import java.util.*;
public class MinimumAddToMakeParenthesesValid_921 {
	
	public static void main(String[] args){
		String str="()))((";
		System.out.println("Minimum Add Required >> "+minAddToMakeValid(str));
	}
	
	public static int minAddToMakeValid(String str) {
        Stack<Character> stack=new Stack<>();
		for(int i=0;i<str.length();i++){
			char ch=str.charAt(i);
			if(ch==')') {
				if(!stack.isEmpty() && stack.peek()=='('){
					stack.pop();
				}else{
					stack.push(ch);
				}
			}
			else{
				stack.push(ch);
			}
		}
		return stack.size();
    }	
}