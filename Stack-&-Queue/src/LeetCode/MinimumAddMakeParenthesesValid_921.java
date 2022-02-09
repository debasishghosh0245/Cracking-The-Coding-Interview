import java.util.Stack;
public class MinimumAddMakeParenthesesValid_921 {
	
	public static void main(String[] args) {
		String s = "())";
		System.out.println(minAddToMakeValid(s));
	}
	
	
	public static int minAddToMakeValid(String str) {
      Stack<Character> stack=new Stack<>();
      for(int i=0;i<str.length();i++) {
		  char ch=str.charAt(i);
		  if(!stack.isEmpty() && ch==')'
		      && stack.peek()=='('){
				  stack.pop();
		  }else {
			 stack.push(ch);	  
		  }
	  } 
	  return stack.size();
    }
	
	
}