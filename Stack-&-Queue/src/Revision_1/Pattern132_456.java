import java.util.*;
public class Pattern132_456{
	/* https://leetcode.com/problems/132-pattern/ */
	
	public static void main(String[] args){
		int[] nums={6,12,3,4,6,11,20};
		System.out.println(find132patternIII(nums));
	}
	
	//Time Complexicty :: O(n)
	public static boolean find132pattern(int[] nums) {
        for(int i=0;i<nums.length-2;i++){
			for(int j=i+1;j<nums.length-1;j++){
				for(int k=j+1;k<nums.length;k++){
					if(nums[j] > nums[i] 
						&& nums[j] > nums[k] && nums[k] > nums[i]){
						System.out.println("i >> "+i+" j >> "+j+" k >> "+k);
						return true;
					}
				}
			}
		}
		return false;
    }
	
	//Time Complexity : O(n2)
	public static boolean find132patternII(int[] nums) {
		int[] min=new int[nums.length];
		int min_i = Integer.MAX_VALUE;
		for(int j=0;j<nums.length-1;j++){
			min_i=Math.min(min_i,nums[j]);
			for(int k=j+1;k<nums.length;k++){
				if(nums[j] > min_i && nums[k] > min_i && nums[k] < nums[j]){
					System.out.println(" i >> "+min_i+" j >> "+nums[j]+" k >> "+nums[k]);
					return true;
				}
			}
		}
		System.out.println(Arrays.toString(min));
		return false;
    }
	
	
	//Time Complexity : O(n)
	public static boolean find132patternIII(int[] nums) {
		if(nums.length < 3) return false;
		int[] min=new int[nums.length];
		int min_i=Integer.MAX_VALUE;
		for(int i=0;i<nums.length;i++){
			min_i=Math.min(min_i,nums[i]);
			min[i]=min_i;
		}
		System.out.println("Minimum Array >> "+Arrays.toString(min));
		Stack<Integer> stack=new Stack<Integer>();
		for(int j=nums.length-1;j>=0;j--){
				if(nums[j] > min[j]){
					while(!stack.isEmpty() && stack.peek() <= min[j]){
						stack.pop();
					}
					if(!stack.isEmpty() && stack.peek() < nums[j]){
						System.out.println("J >> "+nums[j]+" I >> "+min[j]+" K >>  "+stack.peek());
						return true;
					}
					stack.push(nums[j]);
				}
				
		}
		return false;
    }
}