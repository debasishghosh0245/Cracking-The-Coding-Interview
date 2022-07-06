import java.util.*;
public class RemoveDuplicateLetters_316{

	public static void main(String[] args){
		//String str="abacb";
		//String str1="bcabc";
		//String str2="cbacdcbc";
		String str3="bbcaac";
		System.out.println(removeDuplicateLetters(str3));
	}
	
	public static String removeDuplicateLetters(String str) {
		HashMap<Character,Integer> last_occurence=new HashMap<>();
		HashSet<Character> hashset=new HashSet<>();
		for(int i=0;i<str.length();i++){
			char ch=str.charAt(i);
			last_occurence.put(ch,i);
		}
		System.out.println(last_occurence);
		Stack<Character> stack=new Stack<>();
		for(int i=0;i<str.length();i++){
			char ch=str.charAt(i);
			if(stack.isEmpty()){
				stack.push(ch);
				hashset.add(ch);
			}
			else{
				if(!hashset.contains(ch)){
					while(!stack.isEmpty() && stack.peek()>ch 
						&& last_occurence.get(stack.peek())>i){
						char top=stack.peek();
						stack.pop();
						hashset.remove(top);
					}
					stack.push(ch);
					hashset.add(ch);
				}
			}
		}
		//final filter for unique output //
		StringBuilder sb=new StringBuilder();
		for(Character ch: stack){
			sb.append(ch);
		}
		//System.out.println(hashset);
		return sb.toString();
    }
}