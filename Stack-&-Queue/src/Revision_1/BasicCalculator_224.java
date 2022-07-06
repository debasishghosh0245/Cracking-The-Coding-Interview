import java.util.*;
public class BasicCalculator_224 {
  
	public static void main(String[] args){
		String s="(1+(-4-5+2)";
		System.out.println(evaluteInfixExpression(s));  
	}

	public static int operation(int val1,char operator){
		if(operator=='-'){
			return val1*-1; 
		}
		else {
			return val1*1;
		}
	}
	
	public static int evaluteInfixExpression(String str){
		Stack<Integer> operandStack=new Stack<Integer>();
		Stack<Character> operatorStack=new Stack<Character>();
		for(int i=0;i<str.length();i++){
			char ch=str.charAt(i);
			if(Character.isDigit(ch)) {
				int num=0;
				while(i<str.length() && Character.isDigit(str.charAt(i))){
					num=num*10+(str.charAt(i++)-'0');
				}
				i--;
				if(!operatorStack.isEmpty()){
					char operator='+';
					if(operatorStack.peek()!='('){
						operator=operatorStack.pop();
					}
					num=operation(num,operator);
				}
				operandStack.push(num);
			}
			else if(ch=='('){
				operatorStack.push(ch);
			}
			else if(ch==')') {
				while(!operatorStack.isEmpty() && operatorStack.peek()!='('){
					int val1=operandStack.pop();
					int val2=operandStack.pop();
					int res=val1+val2;
					operandStack.push(res);
				} 
				operatorStack.pop();
			}
			else if(ch=='+' || ch=='-') {
				operatorStack.push(ch);
			}
		}
		System.out.println("operator Stack "+operatorStack);
		System.out.println("Operand Stack "+operandStack);
		int result=0;
		while(!operandStack.isEmpty()){
			int val1=0;
			int val2=0;
			if(!operandStack.isEmpty()){
				val1=operandStack.pop();
			}
			if(!operandStack.isEmpty()){
				val2=operandStack.pop();
			}
			result+=val1+val2;
		} 
		return result;
	}
}