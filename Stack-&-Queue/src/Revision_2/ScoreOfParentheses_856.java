import java.util.*;
public class ScoreOfParentheses_856 {
	
	public static void main(String[] args){
		String str= "()()";
		System.out.println(scoreOfParentheses(str));
	}
	
	public static int scoreOfParentheses(String str) {
        Stack<Integer> stack=new Stack<>();
		for(int i=0;i<str.length();i++){
			char ch=str.charAt(i);
			if(ch=='('){
				stack.push(-1);
			}
			else if(ch==')'){
				if(!stack.isEmpty() && stack.peek()==-1){
					stack.pop();
					stack.push(1);
				}
				else{
					int sum=0;
					while(stack.peek()!=-1){
						sum+=stack.pop();
					}
					stack.pop();
					stack.push(sum*2);
				}
			}
		}
		int result=0;
		while(!stack.isEmpty()){
			result+=stack.pop();
		}
		return result;	
	}
}