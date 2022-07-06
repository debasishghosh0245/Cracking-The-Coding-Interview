import java.util.*;
public class MinimumStack {
	
	Stack<Integer> mainstack=null;
	Stack<Integer> minstack=null;

	public static void main(String[] args){
		MinimumStack minimumstack=new MinimumStack();
		minimumstack.push(2);
		minimumstack.push(0);
		minimumstack.push(3);
		minimumstack.push(0);
		System.out.println(minimumstack.getMin());
		System.out.println(minimumstack.pop());
		System.out.println(minimumstack.getMin());
	}
	
	public MinimumStack() {
        mainstack=new Stack<Integer>();
		minstack=new Stack<Integer>();
    }
    
    public void push(int val) {
		if(minstack.isEmpty()){
			minstack.push(val);
		}else{
			if(minstack.peek()>=val){
				minstack.push(val);
			}
		}
		mainstack.push(val);
    }
    
    public int pop() {
		if(mainstack.isEmpty()){
			System.out.println("Stack underflow");
			return -1;
		}else{
			int top=mainstack.pop();
			if(!minstack.isEmpty() 
				&& top==minstack.peek()){
				minstack.pop();
			}
			return top;
		}
    }
    
    public int top() {
		if(!mainstack.isEmpty()){
			 return mainstack.peek();
		}else{
			System.out.println("Stack underflow");
			return -1;
		}
    }
    
    public int getMin() {
		if(!minstack.isEmpty()){
			return minstack.peek();
		}else{
			System.out.println("Stack underflow");
			return -1;
		}
    }
}