import java.util.*;
public class ReverseSubstringsBetweenEachPairParentheses_1190{
	
	public static void main(String[] args){
		String str="(abcd)";
		System.out.println(reverseParentheses(str));
	}
	
	public static String reverseParentheses(String str) {
        Stack<Character> stack=new Stack<Character>();
		for(int i=0;i<str.length();i++){
			char ch=str.charAt(i);
			if(ch==')'){
				StringBuilder temp=new StringBuilder();
				while(!stack.isEmpty() && stack.peek()!='('){
					temp.append(stack.pop());
				}
				stack.pop();
				for(int j=0;j<temp.length();j++){
					char tempChar=temp.charAt(j);
					stack.push(tempChar);
				}
			}else{
				stack.push(ch);
			}
		}
		StringBuilder answare=new StringBuilder();
		while(!stack.isEmpty()){
			answare.insert(0,stack.pop());
		}
		return answare.toString();
    }
}