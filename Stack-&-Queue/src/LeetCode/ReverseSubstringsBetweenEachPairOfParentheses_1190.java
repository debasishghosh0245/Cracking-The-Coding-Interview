import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;
import java.util.Stack;
public class ReverseSubstringsBetweenEachPairOfParentheses_1190{

    public static void main(String[] args){
		/* String str= "(u(love)i)"; */
		/* String str2="(ed(et(oc))el)"; */
		String str3="(abcd)";
		System.out.println(reverseParentheses(str3));
	}
	
	public static String reverseParentheses(String str) {
		StringBuilder output=new StringBuilder();
		Stack<Character> stack=new Stack<>();
		Queue<Character> queue=new ArrayDeque<>();
		for(int i=0;i<str.length();i++){
			char ch=str.charAt(i);
			if(ch==')'){
				while(!stack.isEmpty() && stack.peek()!='('){
					queue.add(stack.pop());
				}
				stack.pop(); //remove opening parentheses also
				while(!queue.isEmpty()) {
					stack.push(queue.remove());
				}
			}else{
				stack.push(ch);
			}
		}
		Iterator<Character> itr=stack.iterator();
		while(itr.hasNext()){
			output.append(itr.next().toString());
		}
		return output.toString();
    }

}