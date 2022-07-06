import java.util.*;
public class LargestRectangleInHistogram_84{
	
	public static void main(String[] args){
		int[] heights ={1,1};
		System.out.println("Max Area of Rarget Rectangle Area >> "
		+largestRectangleArea(heights));
	}
	
	public static int[] nextSmallerLeft(int[] heights){
		Stack<Integer> stack=new Stack<>();
		int[] answer=new int[heights.length];
		for(int i=0;i<heights.length;i++){
			while(!stack.isEmpty()
				&& heights[stack.peek()] > heights[i]){
				stack.pop();
			}
			if(stack.isEmpty()){
				answer[i]=-1;
			}else{
				answer[i]=stack.peek();
			}
			stack.push(i);
		}
		return answer;
	}
	
	public static int[] nextSmallerRight(int[] heights){
		Stack<Integer> stack=new Stack<>();
		int[] answer=new int[heights.length];
		for(int i=heights.length-1;i>=0;i--){
			while(!stack.isEmpty()
				&& heights[stack.peek()] >= heights[i]){
				stack.pop();
			}
			if(stack.isEmpty()){
				answer[i]=heights.length;
			}else{
				answer[i]=stack.peek();
			}
			stack.push(i);
		}
		return answer;
	}

	public static int largestRectangleArea(int[] heights) {
        Stack<Integer> stack=new Stack<>();
		stack.push(-1);
		int maxArea=0;
		for(int i=0;i<heights.length;i++){
			while(stack.peek()!=-1
				&& heights[i] <= heights[stack.peek()]){
				int height=heights[stack.pop()];
				int area=height*(i-stack.peek()-1);
				maxArea=Math.max(area,maxArea);
			}
			stack.push(i);
		}
		while(stack.peek()!=-1){
			int height=heights[stack.pop()];
			int area=height*(heights.length-stack.peek()-1);
			maxArea=Math.max(area,maxArea);
		}
		return maxArea;
    }
}