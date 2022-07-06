import java.util.*;
public class TrappingRainWater_42{

	public static void main(String[] args){
		int[] heights={4,2,0,3,2,5};
		int[] left=nextGreaterLeft(heights);
		int[] right=nextGreaterRight(heights);
		int totalArea=0;
		for(int i=0;i<heights.length;i++){
			int height=Math.min(left[i],right[i]);
			if(height-heights[i]>0){
				totalArea+=height-heights[i];
			}
		}	
		System.out.println("Total Area >> "+totalArea);
	}

	public static int[] nextGreaterLeft(int[] heights){
		Stack<Integer> stack=new Stack<>();
		int[] answer=new int[heights.length];
		for(int i=0;i<heights.length;i++){
			while(!stack.isEmpty()
				&& stack.peek() <= heights[i]){
				stack.pop();
			}
			if(stack.isEmpty()){
				answer[i]=0;
			}else{
				answer[i]=stack.peek();
			}
			stack.push(heights[i]);
		}
		return answer;
	}
	
	public static int[] nextGreaterRight(int[] heights){
		Stack<Integer> stack=new Stack<>();
		int[] answer=new int[heights.length];
		for(int i=heights.length-1;i>=0;i--){
			while(!stack.isEmpty()
				&& stack.peek() <= heights[i]){
				stack.pop();
			}
			if(stack.isEmpty()){
				answer[i]=0;
			}else{
				answer[i]=stack.peek();
			}
			stack.push(heights[i]);
		}
		return answer;
	}


}