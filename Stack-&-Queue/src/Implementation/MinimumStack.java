import java.util.Stack;

public class MinimumStack {

    Stack<Integer> allData;
    Stack<Integer> minData;
    
    
    public MinimumStack() {
        allData = new Stack<>();
        minData = new Stack<>();
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
        minStack1.display();
        System.out.println("Minimum from Stack >> " + minStack1.getMin());
    }

    public int size() {
        return allData.size();
    }

    void push(int val) {
        if (minData.isEmpty() || val <= minData.peek()) {
            minData.push(val);
        }
        allData.push(val);
    }

    public int pop() {
        if (allData.isEmpty()) {
            System.out.println("Stack underflow");
            return -1;
        } else {
            if (allData.peek() == minData.peek()) {
                minData.pop();
            }
            return allData.pop();
        }
    }

    public int peek() {
        if (allData.isEmpty()) {
            System.out.println("Stack underflow");
            return -1;
        } else {
            return allData.peek();
        }
    }

    public void display() {
        System.out.println(allData.toString());
    }

    public int getMin() {
        if (!minData.isEmpty()) {
            return minData.peek();
        } else {
            System.out.println("Stack underflow");
            return -1;
        }
    }

}
