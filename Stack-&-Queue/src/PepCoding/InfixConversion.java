package PepCoding;

import java.util.HashMap;
import java.util.Stack;

public class InfixConversion{

     public static HashMap<Character,Integer> predecenceMap=new HashMap<>();
     
     static {
         predecenceMap.put('+', 1);
         predecenceMap.put('-', 1);
         predecenceMap.put('*', 2);
         predecenceMap.put('/', 2);
     }
     public static void main(String[] args){
         String str="2*(6-4+8)/3";
         infixConversion(str);
     }
     
     public static void infixConversion(String str){
         
         Stack<Character> operator=new Stack<>();
         Stack<String> postfix=new Stack<>();
         Stack<String> prefix=new Stack<>();
         
         for(char ch: str.toCharArray()) {
             
             if(ch=='(') {
                operator.push(ch); 
             }
             else if(Character.isDigit(ch)) {
               postfix.push(String.valueOf(ch));
               prefix.push(String.valueOf(ch));               
             }
             else if(ch=='*' || ch=='/' || ch=='+' || ch=='-') {
                 while(!operator.isEmpty()
                      && operator.peek()!='(' 
                          && predecenceMap.get(operator.peek())>=predecenceMap.get(ch)){
                         char op=operator.pop();
                         //for postfix stack 
                         String postVal2=postfix.pop();
                         String postVal1=postfix.pop();
                         postfix.push(postVal1+postVal2+op);
                         
                         // for prefix stack 
                         String preVal2=prefix.pop();
                         String preVal1=prefix.pop();
                         prefix.push(op+preVal1+preVal2);
                 }
                  operator.push(ch);
             }
             else if(ch==')') {
                 while(!operator.isEmpty() 
                      && operator.peek()!='('){
                         char op=operator.pop();
                         
                         //for postfix stack 
                         String postVal2=postfix.pop();
                         String postVal1=postfix.pop();
                         postfix.push(postVal1+postVal2+op);
                         
                         // for prefix stack 
                         String preVal2=prefix.pop();
                         String preVal1=prefix.pop();
                         prefix.push(op+preVal1+preVal2);
                }
               operator.pop();                
             }
         }
         
         if(!operator.isEmpty()){
            while(!operator.isEmpty()){
                         char op=operator.pop();
                         //for postfix stack 
                         String postVal2=postfix.pop();
                         String postVal1=postfix.pop();
                         postfix.push(postVal1+postVal2+op);
                         
                         // for prefix stack 
                         String preVal2=prefix.pop();
                         String preVal1=prefix.pop();
                         prefix.push(op+preVal1+preVal2);
                }
         }
         
         System.out.println("PostFix >> "+postfix.pop());
         System.out.println("Prefix >> "+ prefix.pop());
     }
     
}