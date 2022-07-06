import java.util.*;
public class MaximalRectangle_85{
	
	public static void main(String[] args){
		// char[][] matrix={{'1','0','1','0','0'},{'1','0','1','1','1'},
		// {'1','1','1','1','1'},{'1','0','0','1','0'}};
		char[][] matrix2={{'0','1'},{'1','0'}};
		System.out.println(maximumRectangle(matrix2));
	}
	
	public static int maximumRectangle(char[][] matrix) {
		if (matrix.length == 0) return 0;
        int maxarea = 0;
        int[] dp = new int[matrix[0].length];
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                dp[j] = matrix[i][j] == '1' ? dp[j] + 1 : 0;
            }
            // update maxarea with the maximum area from this row's histogram
            maxarea = Math.max(maxarea,calMaximumArea(dp));
        } 
		return maxarea;
    }
	
	public static int calMaximumArea(int[] nums){
		Stack < Integer > stack = new Stack < > ();
        stack.push(-1);
        int maxarea = 0;
        for (int i=0; i <nums.length; ++i) {
            while (stack.peek() != -1 && nums[stack.peek()] >= nums[i])
            maxarea = Math.max(maxarea, nums[stack.pop()] * (i-stack.peek()- 1));
            stack.push(i);
        }
        while (stack.peek() != -1)
            maxarea = Math.max(maxarea, nums[stack.pop()] * (nums.length - stack.peek() -1));
        return maxarea;
	}
}