import java.util.Stack;
public class RemoveKDigits402{

     public static void main(String[] args){
		String num="9"; int k=1;
		System.out.println(removeKdigitsII(num,k));
	 }
	 
	 public static String removeKdigitsII(String num, int k) {
          StringBuilder strBuilder=new StringBuilder();
		  int s=0;
		  for(int i=0;i<num.length();i++){
			    char ch=num.charAt(i);
				while(k>0 && s>0 && strBuilder.charAt(s-1)>ch){
					strBuilder.deleteCharAt(s-1);
					k--;
					s--;
				}
				strBuilder.append(ch);	
                s++;				
		  }
		  //if all elements are non decending then remove from last 
		  while(k!=0){
			 strBuilder.deleteCharAt(strBuilder.length()-1);
             k--;			 
		  }
		  while(strBuilder.toString().startsWith("0")  ){
			  strBuilder.deleteCharAt(0);
		  }
		  if(strBuilder.length()==0){
			  strBuilder.append("0");
		  }
		  return strBuilder.toString();
     } 
	 
	 public static void removeKdigits(String str, int k) {
          Stack<Character> stack=new Stack<>();
		  for(int i=0;i<str.length();i++){
			  char ch=str.charAt(i);
			  while(k>0 && !stack.isEmpty() && stack.peek() >= ch){
				  stack.pop();
				  k--;
			  }
			  stack.push(ch);
			  
		  }
		  System.out.println(stack.toString());
     }


}