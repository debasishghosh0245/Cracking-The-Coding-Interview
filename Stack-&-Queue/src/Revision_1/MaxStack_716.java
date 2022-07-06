import java.util.*;
public class MaxStack_716{

	Stack<Integer> mainStack=null;
	Stack<Integer> maxStack=null;
	
	public MaxStack_716() {
        mainStack=new Stack<>();
		maxStack=new Stack<>();
    }
    
    public void push(int val) {
        if(maxStack.isEmpty()){
			maxStack.push(val);
		}
		else{
			int max=Math.max(val,maxStack.peek());
			maxStack.push(max);
			
		}
		mainStack.push(val);
    }
    
    public int pop() {
        int top= mainStack.pop();
		maxStack.pop();
		return top;
    }
    
    public int top() {
        return mainStack.peek();
    }
    
    public int peekMax() {
        return maxStack.peek();
    }
    
    public int popMax() {
        int max=peekMax();
		Stack<Integer> buffer=new Stack<Integer>();
		while(!mainStack.isEmpty() 
			&& max!=top()){
			buffer.push(pop());
		}
		pop();
		while(!buffer.isEmpty()){
			push(buffer.pop());
		} 
		return max;
    }
	
	public static void main(String[] args){
		MaxStack_716 maxStack716=new MaxStack_716();
		maxStack716.push(5);
		maxStack716.push(1);
		maxStack716.push(-5);
		//maxStack716.push(5);
		//System.out.println(maxStack716.top());
		//System.out.println(maxStack716.maxStack);
		System.out.println(maxStack716.popMax());
		System.out.println(maxStack716.popMax());
		System.out.println(maxStack716.popMax());
		//System.out.println(maxStack716.peekMax());
		/* System.out.println(maxStack716.top());
		
		 */
		System.out.println(maxStack716.maxStack);
		System.out.println(maxStack716.mainStack);
	}


}