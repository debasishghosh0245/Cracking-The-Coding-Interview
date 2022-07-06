import java.util.Stack;
public class EvaluateReversePolishNotation_150{

    public static void main(String[] args){
		//String[] tokens = {"2","1","+","3","*"};
		 //String[] tokens={"4","13","5","/","+"};
		 String[] tokens={"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
		
		System.out.println(evalRPN(tokens));
	}


    public static int evalRPN(String[] tokens) {
		Stack<Integer> stack=new Stack<>();
		for(String str: tokens) {
			if(str.equals("+") || str.equals("-") 
			   || str.equals("*") || str.equals("/")){
			   int val2=stack.pop();
               int val1=stack.pop();
			   System.out.println(str);
			   int val=operation(str,val1,val2);
			   System.out.println(val);
               stack.push(val); 			  
			}else{
			   stack.push(Integer.parseInt(str));
			}
		}
		return stack.peek();
    }
	
	public static int operation(String ch, int val1,int val2){
		int result=0;
		switch(ch) {
			case "+" : 
			   result=val1+val2;
			   break;
			case "-":
			   result=val1-val2;
			   break;
			case "*" :
			   result=val1*val2;
			   break;
			case "/":
			   result=val1/val2;
			   break;
		}
		return result;
	}
} 