import java.util.Stack;
public class PrefixEvaluation{

  public static void main(String[] args){
	 String str="-+2/*6483";
	 evalutePrefixExpression(str); 
  }
  
  public static void evalutePrefixExpression(String str) {
	   Stack<Integer> valueStack=new Stack<>();
	   char[] ch=str.toCharArray();
	   for(int i=ch.length-1;i>=0;i--) { 
		   if(ch[i]=='+' || ch[i]=='-' || ch[i]=='*' || ch[i]=='/'){
		      int val1=valueStack.pop();
			  int val2=valueStack.pop();
			  valueStack.push(operation(val1,val2,ch[i]));
		   }
		   else{
			  valueStack.push(ch[i]-'0'); 
		   }
	   }
	   System.out.println(valueStack.pop());
  }
  
  public static int operation(int value1,int value2,char ch){
	  int result=0;
	  switch(ch) {
		  case '+': 
		       result=value1+value2;
		       break;
		  case '*':
		       result=value1*value2;
		       break;
		  case '-':
		       result=value1-value2;
		       break;
		  case '/':
		       result=value1/value2;
		       break;
		  default:
               result=0;
	  } 
	  return result;
  }

}