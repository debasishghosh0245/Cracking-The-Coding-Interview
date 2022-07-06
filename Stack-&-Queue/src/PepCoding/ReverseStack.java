import java.util.Stack;

public class ReverseStack {

      public static void main(String[] args){
		  //6 elements are pushed into stack 
		  Stack<Integer> stack=new Stack<>();
		  stack.push(1);
		  stack.push(2);
		  stack.push(3);
		  stack.push(4);
		  stack.push(5);
		  stack.push(6);
		  //how to print one stack
		  System.out.println(stack.toString());
		  reverse(stack);
		 // System.out.println(stack2.toString());
		  
	  }
	  
	  public static void reverse(Stack<Integer> stack) {
 		  if(stack.isEmpty()) return;
		  //System.out.print("[");
		  int temp =stack.pop();
		  System.out.print(temp +"  ");
		   //System.out.print("]");
		  reverse(stack);
		  //insertAtBottom(stack,temp);
	  }
	  
	  
	  public static void insertAtBottom(Stack<Integer> stack,int data){
		  if(stack.isEmpty()) {
			  stack.push(data);
			  return;
		  }
		  int temp=stack.pop();
		  insertAtBottom(stack,data);
		  stack.push(temp); 
	  }

}