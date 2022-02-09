import java.util.Stack;
public class ScoreOfParentheses_856{
     
	 public static void main(String[] args){
		String str="(()(()))";
		System.out.println(scoreOfParentheses(str));
	 }
	 
	 public static int scoreOfParentheses(String str){
		 int sum=0;
		 int sumOfTop=0;
		 Stack<Integer> stack=new Stack<>();
		 for(int i=0;i<str.length();i++){
			 char ch=str.charAt(i);
			 if(!stack.isEmpty() && ch==')'){
				 if(stack.peek()==-1){
					 stack.pop();
					 stack.push(1);
				 }
				 else{
					  while(stack.peek()!=-1){
						  sumOfTop+=stack.pop();
					  }
					  stack.push(sumOfTop);
				 }
			 }else{
				 stack.push(-1);
			 }
		 }
		 return 2*stack.pop();
	 }
}