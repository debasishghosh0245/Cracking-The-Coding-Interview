import java.util.*;
public class InfixConversion{

	public static void main(String[] args){
		String str="a+b*c/d/e-f";
		infixConversion(str);
	}
	public static HashMap<Character,Integer> precedenceMap=new HashMap<>();
	static {
		precedenceMap.put('+',0);
		precedenceMap.put('-',0);
		precedenceMap.put('*',1);
		precedenceMap.put('/',1);
	}
	public static void infixConversion(String str) {
		Stack<String> postfixStack=new Stack<String>();
		Stack<String> prefixstack=new Stack<String>();
		Stack<Character> operatorStack=new Stack<>();
		for(int i=0;i<str.length();i++){
			char ch=str.charAt(i);
			if(ch=='('){
				operatorStack.push(ch);
			}
			else if(ch==')'){
				while(!operatorStack.isEmpty() && operatorStack.peek()!='('){
					String val1_postfix=postfixStack.pop();
					String val2_postfix=postfixStack.pop();
					char operator=operatorStack.pop();
					String result_postfix=val2_postfix+val1_postfix+operator;
					postfixStack.push(result_postfix);
					String val1_infix=prefixstack.pop();
					String val2_infix=prefixstack.pop();
					String result_infix=operator+val2_infix+val1_infix;
					prefixstack.push(result_infix);
				}
				operatorStack.pop();//remove the opending parentheses
			}
			else if(ch=='+' || ch=='*' || ch=='-' || ch=='/'){
				
				while(!operatorStack.isEmpty() && operatorStack.peek()!='('
					&& precedenceMap.get(operatorStack.peek())>= precedenceMap.get(ch)){
					System.out.println(precedenceMap.get(operatorStack.peek()));
					char operator=operatorStack.pop();
					String val1_postfix=postfixStack.pop();
					String val2_postfix=postfixStack.pop();
					String result_posfix=val2_postfix+val1_postfix+operator;
					postfixStack.push(result_posfix);
					String val1_infix=prefixstack.pop();
					String val2_infix=prefixstack.pop();
					String result_infix=operator+val2_infix+val1_infix;
					prefixstack.push(result_infix);
				}
				operatorStack.push(ch);
			}
			else{
				postfixStack.push(ch+"");
				prefixstack.push(ch+"");
			}
		}
		System.out.println("Operator Stack >>"+operatorStack);
		System.out.println("Postfix Stack >> "+postfixStack);
		while(!operatorStack.isEmpty()){
			String val1_postfix=postfixStack.pop();
			String val2_postfix=postfixStack.pop();
			char operator=operatorStack.pop();
			String result_postfix=val2_postfix+val1_postfix+operator;
			postfixStack.push(result_postfix);
			String val1_infix=prefixstack.pop();
			String val2_infix=prefixstack.pop();
			String result_infix=operator+val2_infix+val1_infix;
			prefixstack.push(result_infix);
		} 
		for(String str1: postfixStack){
			System.out.print(str1);
		}
		System.out.println("");
		for(String str2: prefixstack){
			System.out.print(str2);
		}
	}
}