import java.util.*;
public class PostfixConversion{
	
	public static void main(String[] args){
		String str="264*8/+3-";
		//infix == -+/*64823
		postfixEvalution(str);
		postfixConversion(str);
	}
	
	public static int operation(int val1,int val2,char operator){
		if(operator=='+'){
			return val1+val2;
		}
		else if(operator=='-'){
			return val2-val1;
		}
		else if(operator=='*'){
			return val2*val1;
		}
		else if(operator=='/'){
			return val2/val1;
		}
		else return 0;
	}
	
	public static void postfixEvalution(String str){
		Stack<Integer> postfixOperand=new Stack<Integer>();
		for(int i=0;i<str.length();i++){
			char ch=str.charAt(i);
			if(Character.isDigit(ch)){
				postfixOperand.push(ch-'0');
			}
			if(ch=='*' || ch=='/' || ch=='+' || ch=='-'){
				int val1=postfixOperand.pop();
				int val2=postfixOperand.pop();
				int result=operation(val1,val2,ch);
				postfixOperand.push(result);
			}
		}
		System.out.println(postfixOperand.pop());
	}
	
	public static void postfixConversion(String str){
		Stack<String> prefixOperandStack=new Stack<>();
		Stack<String> infixOperandStack=new Stack<>();
		for(int i=0;i<str.length();i++){
			char ch=str.charAt(i);
			if(Character.isDigit(ch)){
				prefixOperandStack.push(ch+"");
				infixOperandStack.push(ch+"");
			}
			else if(ch=='+' || ch=='/' || ch=='*' || ch=='-'){
				//for prefix conversion from postfix
				String prefix_val1=prefixOperandStack.pop();
				String prefix_val2=prefixOperandStack.pop();
				String prefix_result=ch+""+prefix_val2+prefix_val1;
				prefixOperandStack.push(prefix_result);
				
				//for infix conversion from postfix
				String infix_val1=infixOperandStack.pop();
				String infix_val2=infixOperandStack.pop();
				String result="("+infix_val2+""+ch+""+infix_val1+")";
				infixOperandStack.push(result);
			} 
		}
		for(String infix : infixOperandStack){
			System.out.println(infix);
		}
		for(String prefix : prefixOperandStack){
			System.out.println(prefix);
		}
	}
}