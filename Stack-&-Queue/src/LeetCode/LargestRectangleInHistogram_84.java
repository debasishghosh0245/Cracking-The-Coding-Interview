package LeetCode;

import java.util.Arrays;
import java.util.Stack;
public class LargestRectangleInHistogram_84{

   public static void main(String[] args){
	   int[] heights = {6,2,5,4,5,1,6};
	  /*int[] heights = {2,4};*/
      int maxArea=largestRectangleArea(heights);
      System.out.println("Max Area >> "+maxArea);	   
   }
   
   public static int largestRectangleArea(int[] heights) {
	   int max=0;
	   int[] nextSmallerLeft=nextSmallerElementLeft(heights);
	   System.out.println(Arrays.toString(nextSmallerLeft));
	   int[] nextSmallerRight=nextSmallerElementRight(heights);
	   System.out.println(Arrays.toString(nextSmallerRight));
	   for(int i=0;i<heights.length;i++){
	     max=Math.max(max,heights[i]*((nextSmallerRight[i]-nextSmallerLeft[i])+1));
	   }
	   return max;
   }
   
   public static int[] nextSmallerElementLeft(int[] arr) {
		int[] nge = new int[arr.length];
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0;i< arr.length;i++) {
            while (!stack.isEmpty() 
				&& arr[i] <=arr[stack.peek()]) {
                stack.pop();
            }
			if(stack.isEmpty())  nge[i]=0;
			else nge[i]=stack.peek()+1;
            stack.push(i);
        }
        return nge;
	}
	
	public static int[] nextSmallerElementRight(int[] arr) {
		int[] nge = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = arr.length-1; i>=0; i--) {
            while (!stack.isEmpty() 
				&& arr[i] <=arr[stack.peek()]) {
                stack.pop();
            }
			if(stack.isEmpty()) nge[i]=arr.length-1;
			else nge[i]=stack.peek()-1;
            stack.push(i);
        }
        return nge;
	  }
	
}