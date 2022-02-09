import java.util.Stack;

public class OnlineStockSpan_901 {


    Stack<int[]> stack = null;

    public OnlineStockSpan_901() {
        stack = new Stack<>();
    }

    public static void main(String[] args) {

        /* ["StockSpanner", "next", "next", "next", "next", "next", "next", "next"]
          [[], [100], [80], [60], [70], [60], [75], [85]]
           Output
          [null, 1, 1, 1, 2, 1, 4, 6] */
        OnlineStockSpan_901 stackspan = new OnlineStockSpan_901();
        System.out.println(stackspan.next(100));
        System.out.println(stackspan.next(80));
        System.out.println(stackspan.next(60));
        System.out.println(stackspan.next(70));
        System.out.println(stackspan.next(60));
        System.out.println(stackspan.next(75));
        System.out.println(stackspan.next(85));
    }

    public int next(int price) {
        int result = 1;
        if (stack.isEmpty()) {
            stack.push(new int[]{price, result});
            return result;
        }
        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            result += stack.pop()[1];
        }
        stack.push(new int[]{price, result});
        return result;
    }

}