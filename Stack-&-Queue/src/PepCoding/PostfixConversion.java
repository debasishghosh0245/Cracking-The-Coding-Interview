import java.util.Stack;

public class PostfixConversion {

	public static void main(String[] args) {
		String str = "264*8/+3-";
		evalutePostfixExp(str);
	}

	public static void evalutePostfixExp(String str) {
		Stack<Integer> valueStack = new Stack<>();
		Stack<String>  infixStack=new Stack<>();
		Stack<String>  prefixStack=new Stack<>();
		
		for (char ch : str.toCharArray()) {
			if (!valueStack.isEmpty() &&  ch == '*' || ch == '/'
					|| ch == '+' || ch == '-') {
				int val2 = valueStack.pop();
				int val1 = valueStack.pop();
				valueStack.push(operation(val1, val2, ch));
				
				//for Infix Stack 
				String valInfix2 = infixStack.pop();
				String valInfix1 = infixStack.pop();
				infixStack.push("("+valInfix1+ch+valInfix2+")");
				
				//for Prefix Stack 
				String prefixVal2 = prefixStack.pop();
				String prefixVal1 = prefixStack.pop();
				prefixStack.push(ch+prefixVal1+prefixVal2);
			}
			else{
				valueStack.push(ch - '0');
				infixStack.push(ch+"");
				prefixStack.push(ch+"");
			}
		}
		System.out.println("PostFix Evalution " + valueStack.pop());
		System.out.println("Infix Evalution " + infixStack.pop());
		System.out.println("Prefix Evalution " + prefixStack.pop());
	}

	public static int operation(int value1, int value2, int ch) {
		int result = 0;
		switch (ch) {
			case '+':
				result = value1 + value2;
				break;
			case '-':
				result = value1 - value2;
				break;
			case '*':
				result = value1 * value2;
				break;
			case '/':
				result = value1 / value2;
				break;
			default:
				result = 0;
		}
		return result;
	}

}