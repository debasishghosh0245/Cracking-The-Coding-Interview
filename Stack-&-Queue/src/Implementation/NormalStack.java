import java.util.Arrays;
import java.util.EmptyStackException;

public class NormalStack {
	
    int[] data;
    int top;
    int elementSize;

    public NormalStack(int cap) {
		this.elementSize=cap;
        data = new int[elementSize];
        top = -1;
    }

    public int size() {
        return top + 1;
    }

    public void display() {
        for(int i=0;i<size();i++){
		   System.out.print(data[i]+"  ");
		}
    }

    public void push(int val) {
        if (top ==elementSize-1) {
           int[] newStack=new int[2*elementSize];
		   newStack=Arrays.copyOf(data,2*elementSize);
		   newStack[++top] = val;
		   data=newStack;
        } else {
           data[++top] = val;
        }
    }

    public int pop() {
        if (top==-1) {
			throw new EmptyStackException();
        } else {
           return data[top--];
        }
    }

    public int top() {
        if (top()== -1) {
			throw new EmptyStackException();
        } else {
             return data[top];
        }
    }
	
	 public static void main(String[] args) {
        NormalStack customStack = new NormalStack(10);
        customStack.push(1);
        customStack.push(2);
		customStack.push(3);
		customStack.push(4);
		customStack.push(5);
		customStack.push(6);
		customStack.push(7);
		customStack.push(8);
		customStack.push(9);
		customStack.push(10);
        customStack.push(1);
		customStack.push(2);
		customStack.push(3);
		customStack.push(4);
		customStack.push(5);
		customStack.push(6);
		customStack.push(7);
		customStack.push(8);
		customStack.push(9);
		customStack.push(10);

        customStack.display();
		System.out.println();
		
		System.out.println(customStack.pop());
		System.out.println(customStack.pop());
		
		customStack.display();
		
    }
}