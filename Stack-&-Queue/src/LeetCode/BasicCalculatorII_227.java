import java.util.Stack;
public class BasicCalculatorII_227{

    public static void main(String[] args){
	   String str= "3+2*2";
	   System.out.println(calculate(str));
	}
	public static int calculate(String str) {
		Stack<Integer> operand=new Stack<>();
		Stack<Character> operator=new Stack<>();
		for(int i=0;i<str.length();i++) {
			char ch=str.charAt(i);
			if(Character.isDigit(ch)) {
				int val=0;
				while(i<str.length() && Character.isDigit(str.charAt(i))){
					val=val*10+(str.charAt(i)-'0');
					i++;
				} 
				i--;
				operand.push(val);
			}else if(ch=='('){
				operator.push(ch);
			}
            else if(ch=='+' || ch=='-' || ch=='*' || ch=='/' ) {
               //before push resovle if already if their is same piority element 
               while(!operator.isEmpty()&& operand.size()>=2 
               && (precendence(operator.peek())>=precendence(ch))){
                   int val2=operand.pop();
                   int val1=operand.pop();
                   char optedch=operator.pop();
                   int val=operation(optedch,val1,val2); 
                   operand.push(val);
               }               
               operator.push(ch);
            }
            else if(ch==')') {
                while(operator.peek()!='(') {
                   int val2=operand.pop();
                   int val1=operand.pop();
                   char optedch=operator.pop();
                   int val=operation(optedch,val1,val2); 
                   operand.push(val);
                }
                operator.pop();
            } 
        }
        while(!operator.isEmpty()) {
            int val2=operand.pop();
            int val1=operand.pop();
            char ch=operator.pop();
            int val=operation(ch,val1,val2); 
            operand.push(val);  
        }
        String outputStr=new String();
        while(!operand.isEmpty()) {
           outputStr=operand.pop()+outputStr;
        }
        return Integer.parseInt(outputStr);
    }
    public static int operation(char ch, int a,int b) {
        int result=0;
        switch(ch){
            case '+':
              result=a+b;
              break;
            case '-':
              result=a-b;
              break;
            case '*':
              result=a*b;
            break;
            case '/':
              result=a/b;
              break;
        }
        return result;   
    }
    
    public static int precendence(char ch) {
       if(ch=='+') return 1;
       if(ch=='-') return 1;
       else if(ch=='*') return 2;       
       else if(ch=='/') return 2; 
       else return 0;
    }
}