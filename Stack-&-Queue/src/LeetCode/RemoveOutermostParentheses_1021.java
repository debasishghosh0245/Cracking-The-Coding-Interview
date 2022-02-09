import java.util.Stack;
public class RemoveOutermostParentheses_1021{
   public static void main(String args[]) {
      /* String str= "(()())(())";  */
     /*  String str= "()()"; */   	 
      String str="(()())(())(()(()))";	 
	  System.out.println(removeOuterParentheses(str));
   }
   public static String removeOuterParentheses(String str) {
	    StringBuilder output=new StringBuilder();
	    Stack<Character> stack=new Stack<>();
        for(int i=0;i<str.length();i++) {
			char ch=str.charAt(i);
			if(ch=='('){
			   if(stack.size()>0){
				 output=output.append(ch);    
			   }
			   stack.push(ch);		
			} 
			else{
			   char top=stack.pop();
			   if(stack.size()>0){
				  output=output.append(ch);  
			   }
			}
		}
		return output.toString();
   }
}