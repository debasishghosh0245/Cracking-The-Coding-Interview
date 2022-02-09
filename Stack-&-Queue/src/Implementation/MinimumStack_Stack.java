import java.util.Stack;
public class MinimumStack_Stack{
       
       
    public static void main(String[] args){
       
        int[] arr={12,30,7,6,45,2,11,27,15}; 
        MinimumStack_Stack minimunStack=new MinimumStack_Stack();
        minimunStack.push(12); 
        minimunStack.push(30);
        minimunStack.push(7);
        minimunStack.push(6);   
        minimunStack.push(45);   
        minimunStack.push(2);   
        minimunStack.push(11);           
        minimunStack.push(27);           
        minimunStack.push(15); 

        System.out.println("Minimum Element "+minimunStack.getMin());
        minimunStack.pop();
        minimunStack.pop();
        minimunStack.pop();
        minimunStack.pop();
        minimunStack.pop();
        minimunStack.pop();
        minimunStack.pop();
           
        System.out.println("Peeked Element "+minimunStack.peek());
        System.out.println("Minimum Element "+minimunStack.getMin());
         
           
    }
     
    Stack<Integer> mainStack=new Stack<>();      
    Stack<Integer> minStack=new Stack<>();      
       
    public void push(int data) {
        mainStack.push(data);
        if(minStack.isEmpty()) {
            minStack.push(data);
        }
        minStack.push(data >= minStack.peek() ? minStack.peek() : data);
    }
    
    public void pop() {
        if(mainStack.isEmpty() || minStack.isEmpty()) {
            System.out.println("Stack UnderFlow");
        }
        minStack.pop();
        mainStack.pop();
    }
    
    public int peek() {
        if(mainStack.isEmpty()) {
            System.out.println("Stack UnderFlow");
            return -1;
        }
        return mainStack.peek();
    }
    
    public int getMin() {
        if(minStack.isEmpty()) {
            System.out.println("Stack UnderFlow");
            return -1;
        }
        return minStack.peek();  
    }
}