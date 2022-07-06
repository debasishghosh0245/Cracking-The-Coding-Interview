import java.util.Stack;
public class BalancedBrackets{

  public static void main(String[] args) {
  
	//String str = "[()]{}{[()()]()}"; 
	/* String str="[(a + b) + {(c + d) * (e / f)}";
	String str="[(a + b) + {(c + d) * (e / f)}"; */
	String str="Ijoz1+.";
	System.out.println(areBracketsBalanced(str));
  
  }
  
  public static boolean areBracketsBalanced(String str) { 
    Stack<Character> stack=new Stack<>();
    //	for(int i=0;i<str.length();i++) {
//		str.charAt(i);
//	}

	for(char ch: str.toCharArray()) {
 		 if(!stack.isEmpty() && stack.peek()=='(' && ch==')'){
			 stack.pop();
		 }
		 else if(!stack.isEmpty() && stack.peek()=='{' && ch=='}'){
			 stack.pop();
		 }
		 else if(!stack.isEmpty() && stack.peek()=='[' && ch==']'){
			 stack.pop();
		 }
		 else {
			if(ch=='(' || ch=='{' || ch=='['){
				stack.push(ch); 
			}
			
		 }  
	}
    return stack.isEmpty();
  }
}
