import java.util.Stack;
public class TrappingRainWater_42{

    public static void main(String[] args){
		int[] heights = {4,2,0,3,2,5};
		System.out.println(trap(heights));	
	}
    
    public static int trap(int[] heights) {
		Stack<Integer> stack=new Stack<>();
		int totalArea=0;
		for(int i=0;i<heights.length;i++) {
			while(!stack.isEmpty() && heights[stack.peek()] <= heights[i]) {
				int height=heights[stack.pop()];
				if(stack.size()==0) break;
				int distance=i-stack.peek()-1;
				int bundedArea=Math.min(heights[i],heights[stack.peek()])*distance-height*distance;
				totalArea+=bundedArea;
			}
			stack.push(i);
		}
		return totalArea;
    }
}