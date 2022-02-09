import java.util.Stack;

public class MaxStack_716{

    public static void main(String[] args) {
         
    }
    
    
    Stack<Integer> mainStack;
    Stack<Integer> maxStack;
    
    public MaxStack_716() {
        mainStack=new Stack<>();
        maxStack=new Stack<>();
    }
    
    public void push(int x) {
        int max = maxStack.isEmpty() ? x : maxStack.peek();
        maxStack.push(max > x ? max : x);
        mainStack.push(x);
    }
    
    public int pop() {
            maxStack.pop();
         return mainStack.pop();
    }
    
    public int top() {
         return mainStack.peek();
    }
    
    public int peekMax() {
          return maxStack.peek();   
    }
    
    public int popMax() {
        int max = peekMax();
        Stack<Integer> buffer = new Stack<>();
        while (top() != max) {
            buffer.push(pop());
        }
        pop();
        while (!buffer.isEmpty()) {
            push(buffer.pop());
        }
        return max;
    }


}