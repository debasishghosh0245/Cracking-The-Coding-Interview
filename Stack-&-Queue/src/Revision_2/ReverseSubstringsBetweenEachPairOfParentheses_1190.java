import java.util.*;
public class ReverseSubstringsBetweenEachPairOfParentheses_1190{
	
	public static void main(String[] args){
		String str="(u(love)i)";
		System.out.println(revereSubStrings(str));
	}
	
	//Time Complexity  :
	//Space Complexity :
	public static String revereSubStrings(String str){
		Stack<Character> stack=new Stack<>();
		for(int i=0;i<str.length();i++){
			char ch=str.charAt(i);
			if(ch==')'){
				StringBuilder sb=new StringBuilder();
				while(!stack.isEmpty() && stack.peek()!='('){
					sb.append(stack.pop());
				}
				stack.pop();
				for(char ch2 : sb.toString().toCharArray()){
					stack.push(ch2);
				}
			}else{
				stack.push(ch);
			}
		}
		StringBuilder result=new StringBuilder();
		for(char ch:stack){
			result.append(ch);
		}
		return result.toString();
	}
}