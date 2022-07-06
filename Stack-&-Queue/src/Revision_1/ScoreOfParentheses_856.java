import java.util.*;
public class ScoreOfParentheses_856{

	public static void main(String[] args){
		String str="((()))";
		System.out.println(scoreParentheses(str));
	}
	public static int scoreParentheses(String str){
		Stack<Integer> stack=new Stack<>();
		for(int i=0;i<str.length();i++){
			char ch=str.charAt(i);
			if(ch=='('){
				stack.push(0);
			}else if(ch==')'){
				if(stack.peek()==0){
					stack.pop();
					stack.push(1);
				}else{
					int sum=0;
					while(stack.peek()!=0){
						sum+=stack.pop();
					}
					stack.pop();
					stack.push(2*sum);
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


