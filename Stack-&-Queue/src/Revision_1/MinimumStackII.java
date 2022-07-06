import java.util.*;
public class MinimumStackII {
	
	Stack<Pair> mainstack=null;
	
	public static class Pair{
		int val;
		int minVal;
		
		Pair(int val,int minVal){
			this.val=val;
			this.minVal=minVal;
		}
	}

	public static void main(String[] args){
		MinimumStackII minimumstack=new MinimumStackII();
		minimumstack.push(10);
		minimumstack.push(20);
		minimumstack.push(5);
		minimumstack.push(8);
		minimumstack.push(2);
		minimumstack.push(4);
		minimumstack.push(11);
		System.out.println(minimumstack.getMin());
		minimumstack.pop();
		minimumstack.pop();
		minimumstack.pop();
		System.out.println(minimumstack.getMin());
		minimumstack.pop();
		minimumstack.pop();
		System.out.println(minimumstack.getMin());
	}
	
	public MinimumStackII() {
        mainstack=new Stack<>();
    }
    
    public void push(int val) {
		if(mainstack.isEmpty()){
			mainstack.push(new Pair(val,val));
		}else{
			Pair pair=mainstack.peek();
			int minVal=Math.min(pair.minVal,val);
			mainstack.push(new Pair(val,minVal));
		}
    }
    
    public void pop() {
		mainstack.pop();
    }
    
    public int top() {
		return mainstack.peek().val;
    }
    
    public int getMin() {
		if(!mainstack.isEmpty()){
			return mainstack.peek().minVal;
		}else{
			return -1;
		}
    }
}