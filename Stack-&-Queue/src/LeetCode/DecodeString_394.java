import java.util.*;
public class DecodeString_394{
	
	public static void main(String[] args){
		String str= "100[leetcode]";
		//String str1="3[a]2[bc]";
		//String str2="2[abc]3[cd]ef";
		//Output: "aaabcbc";
		System.out.println(decodeString(str));
	}

	//Time Complexity  :  
	//Space Complexity :
	public static String decodeString(String str){
        Stack<Character> stack=new Stack<>();
		StringBuilder ans=new StringBuilder();
		for(int i=0;i<str.length();i++){
			char ch=str.charAt(i);
			if(ch==']'){
				StringBuilder decodedString=new StringBuilder();
				while(stack.peek()!='['){
					decodedString.insert(0,stack.pop());
				}
				stack.pop();
				int num=0;
				int base=0;
				while(!stack.isEmpty() && Character.isDigit(stack.peek())){
					num=(int)Math.pow(10,base++)*(stack.pop()-'0')+num;
				}
				while(num-->0){
					for(char decodedStr: decodedString.toString().toCharArray()){
						stack.push(decodedStr);
					}
				}
			}else{
				stack.push(ch);
			}
		}
		for(Character res: stack){
			ans.append(res);
		}
		return ans.toString();
    }

}