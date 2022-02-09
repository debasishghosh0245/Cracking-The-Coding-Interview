import java.util.Stack;
public class LargestRectangleInHistogram {

    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 6, 2, 3};
        int output = largestRectangleAreaII(arr);
        System.out.println("output " + output);
    }


    public static int findLargetRectangleHistogram(int[] heights) {
        int maxarea = 0;
        for (int i = 0;i< heights.length; i++) {
            for (int j = i; j < heights.length; j++) {
                int minheight = Integer.MAX_VALUE;
                for (int k = i; k <= j; k++)
                    minheight = Math.min(minheight, heights[k]);
                maxarea = Math.max(maxarea, minheight * (j - i + 1));
            }
        }
        return maxarea;
    }
	
	public static int largestRectangleAreaII(int[] heights){
		int maxArea=0;
		Stack<Integer> stack=new Stack<>();
		stack.push(-1);
		for(int i=0;i<heights.length;i++){
			while(!stack.isEmpty() 
				 && stack.peek()!=-1 
			           && heights[stack.peek()]>heights[i]){
				int height=heights[stack.pop()];
				int width=i-stack.peek()-1;
				int area=height*width;
				maxArea=Math.max(area,maxArea);
			}
			stack.push(i);
		}
		while(!stack.isEmpty() 
			      && stack.peek()!=-1){
                int height=heights[stack.pop()];
				int width=heights.length-stack.peek()-1;
				int area=height*width;
				maxArea=Math.max(area,maxArea);
			
		}
		return maxArea;
	}

}
