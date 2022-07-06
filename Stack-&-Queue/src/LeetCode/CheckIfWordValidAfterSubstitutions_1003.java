import java.util.Stack;
public class CheckIfWordValidAfterSubstitutions_1003 {
	
	public static void main(String[] args){
		 String str= "abccba";
		 System.out.println(isValid(str));	
	}
	
	public static boolean isValid(String str) {
		Stack<Character> stack=new Stack<>();
		for(int i=0;i<str.length();i++){
			char ch=str.charAt(i);
			if(ch=='c' && !stack.isEmpty() 
				&& stack.pop()=='b' && !stack.isEmpty()
    			&& stack.pop()=='a' ) {
               //nothing to do //
			}
			else{
				stack.push(ch);
			}
		}
		return stack.isEmpty();   
    }
	
	
	
}