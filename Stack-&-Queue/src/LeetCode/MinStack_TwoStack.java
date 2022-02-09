import java.io.*;
import java.util.*;
public  class MinStack_TwoStack {
    
    Stack<Integer> allData;
    Stack<Integer> minData;

    public MinStack_TwoStack() {
      allData = new Stack<>();
      minData = new Stack<>();
    }

    int size() {
        return allData.size();
    }

    void push(int val) {
        if(minData.isEmpty() || val<=minData.peek()) {
    		minData.push(val);
    	}else{
    	    minData.push(minData.peek());
    	}
    	allData.push(val);
    }
    
    int pop() {
      if(allData.isEmpty()) {
		  System.out.println("Stack underflow");
		  return -1;
	  }else{
	       minData.pop();
		  return allData.pop();
	  }
    }
    
    int top() {
       if(allData.isEmpty()) {
		  System.out.println("Stack underflow");
		  return -1;
	  }else{
		  return allData.peek();
	  }
    }
    
    int min(){
  	  if(!minData.isEmpty()){
		  return minData.peek();
	  }
	  else {
	      System.out.println("Stack underflow");
	      return -1;
	  }
    }

    public static void main(String[] args) throws Exception {
        
    }
  
}