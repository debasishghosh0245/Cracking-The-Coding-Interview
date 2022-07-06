import java.util.*;
public class RemoveOutermostParentheses_1021 {
	
	public static void main(String[] args){
		String str="(()())(())";
		System.out.println(removeOuterParentheses(str));
	}
	
	public static String removeOuterParentheses(String str) {
		Stack<Character> stack=new Stack<>();
		StringBuilder answer=new StringBuilder();
		for(int i=0;i<str.length();i++){
			char ch=str.charAt(i);
			if(ch==')'){
				stack.pop();
				if(stack.size()>0){
					answer.append(ch);
				}
			}else{
				if(stack.size()>0){
						answer.append(ch);
				}
				stack.push(ch);
			}
		}
		return answer.toString();
    }
}