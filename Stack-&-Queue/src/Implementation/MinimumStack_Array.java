import java.util.Stack;
public class MinimumStack_Array {

   public static void main(String[] args) {
       
      int[] arr={12,30,7,6,45,2,11,27,15};
    
      MinimumStack_Array minStack=new MinimumStack_Array();
      
      minStack.push(12);
      minStack.push(30);
      minStack.push(7);
      minStack.push(6);
      minStack.push(45);
      minStack.push(2);
      minStack.push(11);
      minStack.push(27);
      minStack.push(15);

      System.out.println("Minimum Element "+minStack.getMin());
      
      minStack.pop();
      minStack.pop();
      minStack.pop();
      minStack.pop();
      
      
      System.out.println(minStack.peek());
      
      System.out.println("Minimum Element "+minStack.getMin());

   }

   Stack<int[]> stack=new Stack<>();

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
   
   
   public int peek() {
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

}