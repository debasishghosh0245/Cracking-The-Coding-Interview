import java.util.*;
public class PrefixEvaluation{
	
	public static void main(String[] args){
		String str="-+2/*6483";
		//infix == -+/*64823
		prefixEvalution(str);
		prefixConversion(str);
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
	public static void prefixEvalution(String str){
		Stack<Integer> prefixOperand=new Stack<Integer>();
		for(int i=str.length()-1;i>=0;i--){
			char ch=str.charAt(i);
			if(Character.isDigit(ch)){
				prefixOperand.push(ch-'0');
			}
			if(ch=='*' || ch=='/' || ch=='+' || ch=='-'){
				int val1=prefixOperand.pop();
				int val2=prefixOperand.pop();
				int result=operation(val2,val1,ch);
				prefixOperand.push(result);
			}
		}
		System.out.println(prefixOperand.pop());
	}
	
	public static void prefixConversion(String str){
		Stack<String> postfixOperandStack=new Stack<>();
		Stack<String> infixOperandStack=new Stack<>();
		for(int i=str.length()-1;i>=0;i--){
			char ch=str.charAt(i);
			if(Character.isDigit(ch)){
				postfixOperandStack.push(ch+"");
				infixOperandStack.push(ch+"");
			}
			else if(ch=='+' || ch=='/' || ch=='*' || ch=='-'){
				//for prefix conversion from postfix
				String prefix_val1=postfixOperandStack.pop();
				String prefix_val2=postfixOperandStack.pop();
				String prefix_result=prefix_val1+prefix_val2+""+ch;
				postfixOperandStack.push(prefix_result);
				
				//for infix conversion from postfix
				String infix_val1=infixOperandStack.pop();
				String infix_val2=infixOperandStack.pop();
				String result="("+infix_val1+""+ch+""+infix_val2+")";
				infixOperandStack.push(result);
			} 
		}
		for(String infix : infixOperandStack){
			System.out.println(infix);
		}
		for(String postfix : postfixOperandStack){
			System.out.println(postfix);
		}
	}
}