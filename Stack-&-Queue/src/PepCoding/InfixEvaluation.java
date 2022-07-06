package PepCoding;

import java.util.HashMap;
import java.util.Stack;

public class InfixEvaluation {

    public static HashMap<Character, Integer> precedenceMap = null;

    static {
        precedenceMap = new HashMap<>();
        precedenceMap.put('+', 1);
        precedenceMap.put('-', 1);
        precedenceMap.put('*', 2);
        precedenceMap.put('/', 2);
    }

    public static void main(String[] args) {
        String str = "2+ (5-3*6/2)";
        int output = evaluteInfix(str);
        System.out.println(output);
    }

    public static int operation(int value1, int value2, char ch) {
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
               result=0;            
        }
        return result;
    }
    
    public static int evaluteInfix(String str) {
        Stack<Integer> operand = new Stack<>();
        Stack<Character> operator = new Stack<>();
        for (char ch : str.toCharArray()) {
            if (ch == '(') {
                operator.push(ch);
            } else if (Character.isDigit(ch)) {
                operand.push(ch - '0');
            } else if (ch == '+' || ch == '*' || ch == '/' || ch == '-') {
                if (!operator.isEmpty() && operator.peek() != '('
                        && precedenceMap.get(operator.peek()) >= precedenceMap.get(ch)) {
                    int value2 = operand.pop();
                    int value1 = operand.pop();
                    char op = operator.pop();
                    operand.push(operation(value1, value2, op));
                }
                operator.push(ch);
            } else if (ch == ')') {
                while (!operator.isEmpty() && operator.peek() != '(') {
                    int value2 = operand.pop();
                    int value1 = operand.pop();
                    char op = operator.pop();
                    operand.push(operation(value1, value2, op));
                }
                operator.pop();
            }
        }
        while(!operator.isEmpty()) {
            int value2 = operand.pop();
            int value1 = operand.pop();
            char op = operator.pop();
            int optval=operation(value1, value2, op);
            operand.push(optval);
        }
        int val=operand.pop();
        return val;
    }
}
