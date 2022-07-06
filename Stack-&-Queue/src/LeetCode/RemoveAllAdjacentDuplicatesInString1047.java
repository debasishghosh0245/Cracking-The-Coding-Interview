import java.util.Stack;
public class RemoveAllAdjacentDuplicatesInString1047 {
    public static void main(String[] args){
		String str="azxxzy";
		System.out.println(removeAdjacentDuplicatesI(str));
	}
	
	public static String removeAdjacentDuplicates(String str) {
		Stack<Character> stack=new Stack<>();
		for(int i=0;i<str.length();i++){
			char ch=str.charAt(i);
			if(stack.isEmpty()){
				stack.push(ch);
			}
			else if(stack.peek()==ch){
				stack.pop();
            }
			else{
				stack.push(ch);
			}
		}
		StringBuilder sb=new StringBuilder();
		while(!stack.isEmpty()){
			sb.insert(0,stack.pop());
		}
		return sb.toString();
    }
	
	public static String removeAdjacentDuplicatesI(String str) {
		StringBuilder stringBuilder=new StringBuilder();
		int j=0;
		for(int i=0;i<str.length();i++){
			char ch=str.charAt(i);
			if(j>0 && ch==stringBuilder.charAt(j-1)){
			    stringBuilder.deleteCharAt(j-1);
			}
			else{
				stringBuilder.append(ch);
				j++;
			}
		}
		return stringBuilder.toString();
    }	
}