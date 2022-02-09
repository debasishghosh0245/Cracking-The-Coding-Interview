import java.util.Stack;
public class MinimumRemoveToMakeValidParentheses_1249{
     
	 public static void main(String[] args){
		/* String str= "lee(t(c)o)de)"; */
		String str2="))((";
		System.out.println(minRemoveToMakeValid(str2));
	 }
	 public static String minRemoveToMakeValid(String str) {
		Stack<int[]> stack=new Stack<>();
		for(int i=0;i<str.length();i++){
			char ch=str.charAt(i);
			if(ch=='('){
				stack.push(new int[]{ch,i});
			}else{
				if(ch==')'){
					if(!stack.isEmpty() && stack.peek()[0]=='('){
					   stack.pop();
				    }else{
					    stack.push(new int[]{ch,i});
				    }
				}
			}
		}
		char[] arr=null;
		while(!stack.isEmpty()){
			arr=str.toCharArray();
			arr[stack.pop()[1]]='.';
		}
		StringBuilder stBuilder=new StringBuilder();
		for(char ch1:arr){
			if(ch1!='.'){
				stBuilder.append(ch1);
			}
		}

        return stBuilder.toString();
     }
}