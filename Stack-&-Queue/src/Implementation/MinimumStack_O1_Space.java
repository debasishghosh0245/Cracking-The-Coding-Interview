package Implementation;

import java.util.Stack;
public class MinimumStack_O1_Space {

    public static void main(String[] args) {
       
      int[] arr={12,30,7,6,45,2,11,27,15};
      
      
      // minStack.push(6);
      // minStack.push(45);
      // minStack.push(2);
      // minStack.push(11);
      // minStack.push(27);
      // minStack.push(15);

    /*   System.out.println("Minimum Element "+minStack.getMin());
      minStack.pop();
      minStack.pop();
      minStack.pop();
      minStack.pop(); 
      
      System.out.println(minStack.peek());
      System.out.println("Minimum Element "+minStack.getMin()); */

    } 
    
    public int minElement=-1;
    Stack<Integer> stack=new Stack<Integer>();
    
    public void push(int data) {
        if(stack.isEmpty()){
           stack.push(data);
           minElement=data;           
        }else{
            if(minElement >= data) {
               stack.push(2*data-minElement);
               minElement=data;  
            }else{
              stack.push(data); 
            } 
        }
    }
    
    public int pop() {
        if(stack.isEmpty()) {
            System.out.println("Stack is UnderFlow");
            return -1;
        }else{
            if(stack.peek() <= minElement) {
                int temp=minElement;
                minElement=2*minElement-stack.pop();
                return temp;
            }else{
                return stack.pop();
            }
           
        } 
    }  
    
    public int peek() {
        if(stack.isEmpty()) {
            System.out.println("Stack is UnderFlow");
            return -1;
        }else{
            if(stack.peek() <= minElement) {
                return minElement;
            }else{
                return stack.peek();
            }
        }  
    }   
    
    public int getMin() {
        if(stack.isEmpty()) {
            return -1;
        }else{
            return minElement;
        }
    }    
}