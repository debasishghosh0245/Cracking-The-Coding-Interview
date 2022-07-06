import java.util.*;
public class BuildingsWithOceanView_1762{
	
	public static void main(String[] args){
		int[] heights={1,3,2,4};
		System.out.println(Arrays.toString(findBuildings(heights)));
	}
	
	public static int[] findBuildings(int[] heights) {
        Stack<Integer> stack=new Stack<>();
		for(int i=heights.length-1;i>=0;i--){
			if(stack.isEmpty()){
				stack.push(i);
			}
			else if(!stack.isEmpty() 
					&& heights[stack.peek()] < heights[i]){
				stack.push(i);
			}
		}
		int[] ans=new int[stack.size()];
		int residx=0; //result array index 
		while(!stack.isEmpty()){
			ans[residx++]=stack.pop();
		}
		return ans;
    }


}