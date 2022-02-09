import java.util.Stack;

public class MinimumStackI {

    int[] stackRef;
    int top = -1;
    Stack<Integer> minStack = new Stack<>();

    public MinimumStackI(int cap) {
        stackRef = new int[cap];
    }

    public static void main(String[] args) {

        MinimumStackI minStack1 = new MinimumStackI(10);
        minStack1.push(100);
        minStack1.push(20);
        minStack1.push(1);
        minStack1.push(2);
        minStack1.push(3);
        minStack1.push(4);
        minStack1.push(5);
        minStack1.push(1);
        minStack1.display();
        System.out.println("Minimum From Stack >> " + minStack1.getMin());
        minStack1.pop();
        minStack1.display();
        System.out.println("Minimum From Stack >> " + minStack1.getMin());
    }

    public int size() {
        return top + 1;
    }

    public void push(int data) {
        if (top == size()) {
            System.out.println("Stack Overflow");
        } else {
             if (minStack.isEmpty() || data <=minStack.peek()) {
                minStack.push(data);
            }
            stackRef[++top] = data;
        }
    }

    public int pop() {
        if (top == -1) {
            System.out.println("Stack Underflow");
            return -1;
        } else {
			if(minStack.peek()==stackRef[top]){
				minStack.pop();
			}
            return stackRef[top--];
        }
    }

    public int peek() {
        if (top == -1) {
            System.out.println("Stack Underflow");
            return -1;
        } else {
            return stackRef[top];
        }
    }

    public void display() {
        for (int i = 0;i<stackRef.length; i++) {
            System.out.print(stackRef[i] + "  ");
        }
        System.out.println();
    }

    public int getMin() {
        System.out.println("Minimum Stack Contains >> " + minStack.toString());
        if (!minStack.isEmpty()) {
            return minStack.peek();
        } else {
            System.out.println("Stack Underflow");
            return -1;
        }
    }
}