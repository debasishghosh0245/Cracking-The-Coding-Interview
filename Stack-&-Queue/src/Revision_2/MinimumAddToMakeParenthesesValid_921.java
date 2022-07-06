import java.util.*;
public class MinimumAddToMakeParenthesesValid_921{
	
	public static void main(String[] args){
		String str="()))((";
		System.out.println(minAdd(str));
	}
	
	//Space Complexity: O(n);
	public static int minAddToMake(String str){
		Stack<Character> stack=new Stack<>();
		for(int i=0;i<str.length();i++){
			char ch=str.charAt(i);
			if(ch=='('){
				stack.push(ch);
			}
			else if(ch==')'){
				if(!stack.isEmpty() && stack.peek()=='('){
					stack.pop();
				}else{
					stack.push(ch);
				}
			}
		}
		return stack.size();	
	}
	
	public static int minAdd(String str){
		int bal=0;
		int ans=0;
		for(int i=0;i<str.length();i++){
			bal+=str.charAt(i)=='(' ? 1 : -1;
			if(bal==-1){
				bal++;
				ans++;
			}
		}
		return ans+bal;
	}

}