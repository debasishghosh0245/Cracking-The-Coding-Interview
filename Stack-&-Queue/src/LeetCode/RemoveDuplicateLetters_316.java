import java.util.HashMap;
import java.util.Stack;
public class RemoveDuplicateLetters_316 {
    
	public static void main(String[] args){
		String str= "cbacdcbc";
		System.out.println(removeDuplicateLetters(str));
	}
	
	public static String removeDuplicateLetters(String str) {
        HashMap<Character,Integer> hashMap=new HashMap<>();
		Stack<Character> stack=new Stack<>();
		for(int i=0;i<str.length();i++) {
			char ch=str.charAt(i);
			hashMap.put(ch,hashMap.getOrDefault(ch,0)+1);
		}
		for(int i=0;i<str.length();i++) {
		   char ch=str.charAt(i);
		   while(!stack.isEmpty() && stack.peek() > ch) {
			  System.out.println(ch);
			  if(hashMap.get(stack.peek())>1) {
				  hashMap.put(ch,hashMap.get(stack.peek())-1);
				  stack.pop();
			  } 
		     }
		    stack.push(ch);
		}
		System.out.println(stack.toString());
		return "";
    }

}