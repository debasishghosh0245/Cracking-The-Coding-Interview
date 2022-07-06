import java.util.*;
public class InfixEvaluation{
	
	public static void main(String[] args){
		//String str="2+(6*4/8-3)";
		String str2="2 + 4/(5-3)*3";
		System.out.println(evaluteInfixExpression(str2));
	}
	
	public static HashMap<Character,Integer> precedenceMap=new HashMap<>();
	static {
		precedenceMap.put('(',-1);
		precedenceMap.put('+',0);
		precedenceMap.put('-',0);
		precedenceMap.put('*',1);
		precedenceMap.put('/',1);
	}
	
	
	public static int operation(int val1,int val2,char operator){
		 if(operator=='+'){
			return val2+val1; 
		 }else if(operator=='-'){
			return val2-val1;
		 }else if(operator=='*'){
			return val2*val1; 
		 }else if(operator=='/'){
			return val2/val1;
		 }
		 else return 0;
	}
	
	public static int evaluteInfixExpression(String str){
		Stack<Integer> operandStack=new Stack<Integer>();
		Stack<Character> operatorStack=new Stack<Character>();
		for(int i=0;i<str.length();i++){
			char ch=str.charAt(i);
			if(Character.isDigit(ch)) {
				operandStack.push(ch-'0');
			}
			else if(ch=='('){
				operatorStack.push(ch);
			}
			else if(ch==')'){
				while(!operatorStack.isEmpty() && operatorStack.peek()!='('){
					System.out.println("operator Stack "+operatorStack);
					System.out.println("Operand Stack "+operandStack);
					char operator=operatorStack.pop();
					int val1=operandStack.pop();
					int val2=operandStack.pop();
					int result=operation(val1,val2,operator);
					operandStack.push(result);
				}
				operatorStack.pop();
			}
			else if(ch=='+' || ch=='*' || ch=='/' || ch=='-') {
				while(!operatorStack.isEmpty() && precedenceMap.get(operatorStack.peek()) 
					>=  precedenceMap.get(ch)) {	
					int val1=operandStack.pop();
					int val2=operandStack.pop();
					char op=operatorStack.pop();
					int result=operation(val1,val2,op);
					operandStack.push(result);
					operatorStack.push(ch);
				}else{
					operatorStack.push(ch);
				}
			}
		}
		while(!operatorStack.isEmpty()){
			char operator=operatorStack.pop();
			int val1=operandStack.pop();
			int val2=operandStack.pop();
			int result=operation(val1,val2,operator);
			operandStack.push(result);
		}
		return operandStack.pop();
	}
	
	
}