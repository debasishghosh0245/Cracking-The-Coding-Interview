import java.util.*;
public class RemoveKDigits_402 {

	public static void main(String[] args){
		String num = "1432219"; int k=3;
		System.out.println("Remove K Digits >>"+removeKdigits(num,k));
	}
	public static String removeKdigits(String num, int k) {
		Stack<Character> stack=new Stack<>();
		for(int i=0;i<num.length();i++){
			char ch=num.charAt(i);
			if(stack.isEmpty()){
				stack.push(ch);
			}else{
				while(!stack.isEmpty()
					&& stack.peek()-'0' > ch-'0' && k!=0){
					stack.pop();
					k--;
				}
				stack.push(ch);
			}
		} 
		System.out.println(stack);
		while(k-->0){
			stack.pop();
		}
		StringBuilder answer=new StringBuilder();
		boolean leadingZero=true;
		for(char ch:stack){
			if(leadingZero && ch=='0') continue;
			answer.append(ch);
			leadingZero=false;
		}
		if(answer.length()==0) answer.append('0');
		return answer.toString();
    }
}