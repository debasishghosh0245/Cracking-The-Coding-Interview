import java.util.*;
public class DesignAStackWithIncrementOperation_1381{
	int[] stack=null;
	int[] increment=null;
	int size=0;
	
	public DesignAStackWithIncrementOperation_1381(int maxSize) {
        stack=new int[maxSize];
		increment=new int[maxSize];
    }
    
    public void push(int x) {
        if (size < stack.length) {
            stack[size++] = x;
        }  		
    }
    
    public int pop() {
		if(size > 0) {
            int top = stack[--size] + increment[size];
            if (size > 0) increment[size - 1] += increment[size];
            increment[size] = 0;
            return top;
        }
        return -1;
    }
	
    public void increment(int k,int val) {
		if (k > size) k = size;
        if (k > 0) increment[k - 1] += val; 
    }
	
	public static void main(String[] args){
		DesignAStackWithIncrementOperation_1381 customStack=new DesignAStackWithIncrementOperation_1381(30);
		System.out.println(customStack.pop());
		customStack.increment(3,40);
		customStack.push(30);
		customStack.increment(4,63);
		customStack.increment(2,79);
		System.out.println(Arrays.toString(customStack.stack));
		System.out.println(Arrays.toString(customStack.increment));
	}

}