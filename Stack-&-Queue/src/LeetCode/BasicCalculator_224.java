import java.util.Stack;

public class BasicCalculator_224 {
    public static void main(String args[]){
        //String str="(1+12-(4+5+2)-3)+(6+8)";
        String str="-2+1";
        int cal=calculate(str);
        System.out.println(cal);
    }

     public static int calculate(String str) {
        int sign=+1;
        int result=0;
        Stack<Integer> oprandStack=new Stack<>();
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if(ch=='-') {
                sign=-1;
            }
            else if(ch=='+'){
                sign=+1;
            }
            else if(Character.isDigit(ch)){
                int operand=0;
                while(i<str.length() && Character.isDigit(str.charAt(i))) {
                    operand=operand*10+(str.charAt(i)-'0');
                    i++;
                }
                i--;
                result+=sign*operand;
            }
            else if(ch=='('){
                oprandStack.push(result);
                oprandStack.push(sign);
                result=0;
                sign=+1;
            }
            else if(ch==')' && !oprandStack.isEmpty()){
                result=oprandStack.pop()*result;
                result=oprandStack.pop()+result;
                
            }
        }
        return result;
    }
    
}