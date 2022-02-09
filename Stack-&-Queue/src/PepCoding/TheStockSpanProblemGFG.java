import java.util.Arrays;
import java.util.Stack;

public class TheStockSpanProblemGFG{
    
	public static void main(String[] args) {
		/* int[] arr={100 ,80, 60, 70, 60,75}; */ 
		int[] arr={2,5,9,3,1,12,6,87}; 
		int[] result=calculateStockSpan(arr);
		System.out.println(Arrays.toString(result));
		
	}
	
	public static int[] calculateStockSpan(int[] arr) {
		int[] span=new int[arr.length];
		Stack<Integer> stack=new Stack<Integer>();
		stack.push(0);
		span[0]=1;
		for(int i=1;i<arr.length;i++) {
			int count=1;
			while(!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
				stack.pop();
				count++;
			}
			if(stack.isEmpty()){
				span[i]=i+1;
				
			}
			if(!stack.isEmpty()) {
				span[i]=i-stack.peek();
			}
			stack.push(i);
	   } 
	   return span;
}
}