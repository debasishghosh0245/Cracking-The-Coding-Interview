import java.util.*;
public class CelebrityProblem {

	public static void main(String[] args){
		int[][] arr={{0,1,1,0,1},{1,0,0,1,0},{1,0,0,1,0},{0,0,0,0,0},{0,1,0,1,0}};
		//System.out.println(arr[2][1]);
		System.out.println(findCelebrity(arr));
	}
	
	public static int findCelebrity(int[][] nums){
		Stack<Integer> stack=new Stack<>();
		for(int i=0;i<nums.length;i++){
			stack.push(i);
		}
		//System.out.println("stack >>"+stack);
		while(stack.size()>1){
			int i=stack.pop();
			int j=stack.pop();
			if(nums[i][j]==1){
				stack.push(j);
			}
			else if(nums[j][i]==1){
				stack.push(i);
			} 
		}
		if(stack.isEmpty()) return -1;
		int celibrity=stack.pop();
		for(int i=0;i<nums.length;i++){
			if(i==celibrity) continue;
			if(nums[i][celibrity]==0) return -1;
		}
		return celibrity;
	}
}