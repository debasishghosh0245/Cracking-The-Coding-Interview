import java.util.Stack;

public class PostfixEvaluation {

	public static void main(String[] args) {
		String str = "264*8/+3-";
		evalutePostfixExp(str);
	}

	public static void evalutePostfixExp(String str) {
		Stack<Integer> valueStack = new Stack<>();
		for (char ch : str.toCharArray()) {
			if (!valueStack.isEmpty() &&  ch == '*' || ch == '/'
					|| ch == '+' || ch == '-') {
				int val2 = valueStack.pop();
				int val1 = valueStack.pop();
				valueStack.push(operation(val1, val2, ch));
			}
			else{
				valueStack.push(ch - '0');
			}

		}

		System.out.println("PostFix Evalution " + valueStack.pop());
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