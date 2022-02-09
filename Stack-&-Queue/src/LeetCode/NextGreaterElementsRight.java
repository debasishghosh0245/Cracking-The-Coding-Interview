import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElementsRight {

    public static void main(String[] args) {
        int[] query = {4, 1, 2};
        int[] nums = {1, 3, 4, 2};
        int[] output = nextGreaterElement(nums, query);
        System.out.println(Arrays.toString(output));

    }

    public static int[] nextGreaterElementRight(int[] arr) {
        int[] result = new int[arr.length];
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = stack.peek();
            }
            stack.push(arr[i]);
        }
        return result;
    }


    public static int[] nextGreaterElement(int[] nums, int[] query) {
        int[] result = new int[query.length];
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                hashMap.put(i, -1);
            } else {
                hashMap.put(i, stack.peek());
            }
            stack.push(nums[i]);
        }
        for (int q = 0; q < query.length; q++) {
            result[q] = hashMap.get(query[q]);
        }
        return result;
    }
}