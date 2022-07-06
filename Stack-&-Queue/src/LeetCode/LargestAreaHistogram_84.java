import java.util.Stack;
public class LargestAreaHistogram_84{
    
	public static void main(String[] args){
		 int[] heights={2,1,5,6,2,3};
		 System.out.println(largetAreaHistrogram2(heights));
	}
	
	
	public static int largetAreaHistrogram(int[] heights){
		int maximumArea=0;
		int[] nsr=nextSmallerRight(heights);
		int[] nsl=nextSmallerLeft(heights);
		for(int i=0;i<heights.length;i++){
			int width=((nsr[i]-nsl[i])-1);
			int area=heights[i]*width;
			maximumArea=Math.max(maximumArea,area);
		}
        return maximumArea;
	}
	
	public static int[] nextSmallerRight(int[] heights) {
		int[] result=new int[heights.length];
		Stack<Integer> stack=new Stack<>();
		for(int i=heights.length-1;i>=0;i--){
			while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
				stack.pop();
			}
			if(stack.isEmpty()){
				result[i]=heights.length;
			}else{
				result[i]=stack.peek();
			}
			stack.push(i);
		}
		return result;
	}
	
	
	public static int[] nextSmallerLeft(int[] heights){
		int[] result=new int[heights.length];
		Stack<Integer> stack=new Stack<>();
		for(int i=0;i<heights.length;i++){
			while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
				stack.pop();
			}
			if(stack.isEmpty()){
				result[i]=-1;
			}else{
				result[i]=stack.peek();
			}
			stack.push(i);
		}
		return result;
	}
	
	public static int largetAreaHistrogram2(int[] heights){
		int maxArea=0;
		Stack<Integer> stack=new Stack<>();
		for(int i=0;i<heights.length;i++){
			while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
				int height=stack.pop(); int width=0;
				if(stack.isEmpty()){
				   width=((i+1)-1);	
				}else{
				   width=((i-stack.peek())-1);	
				}
				int area=heights[height]*width;
				maxArea=Math.max(maxArea,area);
			}
			stack.push(i);
		}
		 while(!stack.isEmpty()){
				int height=stack.pop();
				int width=0;
				if(stack.isEmpty()){
				   width=(heights.length+1)-1;
				}else{
				   width=((heights.length-stack.peek())-1);	
				}
				int area=heights[height]*width;
				maxArea=Math.max(maxArea,area);
		}
		return maxArea;
	}
}