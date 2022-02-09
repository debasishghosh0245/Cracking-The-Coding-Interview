import java.util.Stack;

public class MinStack_155{
    
    Stack<int[]> stack=new Stack<>();
    
    public MinStack_155() {
    }
    
    public void push(int data) {
        if(stack.isEmpty()){
           /*if the stack is empty then push everyghing */
          stack.push(new int[]{data,data});  
        }else{
           /*if the stack is not empty then peek last inserted value from stack 
             and compare with current data and push minimumn */
          stack.push(new int[]{data,Math.min(data,stack.peek()[1])});
        }
    }
    
    public void pop() {
        if(stack.isEmpty()){
           System.out.println("Stack UnderFlow");
        }
        else {
           stack.pop();
        }
    }
    
    public int top() {
       if(stack.isEmpty()) {
           System.out.println("Stack UnderFlow");
           return -1;
       }else{
          return stack.peek()[0];
       }
    }
    
    public int getMin() {
        if(stack.isEmpty()) {
           System.out.println("Stack UnderFlow");
           return -1;
        }else{
          return stack.peek()[1];
        }
    }
   
   
    public static void main(String[] args) {
        
    }
    
}