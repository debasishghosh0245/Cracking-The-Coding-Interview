import java.util.Stack;
public class DuplicateParenthesis {
      
	  public static void main(String[] args) {
		String str= "((a+b)+((c+d)))";
		System.out.println(isDuplidateParanthesis(str));
		  
	  }
	  public static boolean isDuplidateParanthesis(String str) {
		  Stack<Character> stack=new Stack<>();
		  for(char ch: str.toCharArray()) {
			  if(ch==')') {
				  if(stack.peek()=='(') return true;
				  while(stack.peek()!='('){
					  stack.pop();
				  }
				  stack.pop();
			  }else{
				  stack.push(ch);
			  }   
		  }
		  return false;
	  }

}