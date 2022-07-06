import java.util.*;
public class NextGreaterElementI_496 {

	public static void main(String[] args){
		int[] nums1={4,1,2};
		int[] nums2={1,3,4,2};
		System.out.println(Arrays.toString(nextGreaterElement(nums1,nums2)));
	}
	
	public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
		HashMap<Integer,Integer> map=nextGreaterElement(nums2);
		int[] answer=new int[nums1.length];
		for(int i=0;i<nums1.length;i++){
			answer[i]=map.get(nums1[i]);
		}
		return answer;
    }
	
	public static HashMap<Integer,Integer> nextGreaterElement(int[] nums){
		HashMap<Integer,Integer> nextGreaterMap=new HashMap<>();
		Stack<Integer> stack=new Stack<Integer>();
		for(int i=nums.length-1;i>=0;i--){
			while(!stack.isEmpty()
				&& stack.peek() < nums[i]){
				stack.pop();
			}
			if(stack.isEmpty()){
				nextGreaterMap.put(nums[i],-1);
			}else{
				nextGreaterMap.put(nums[i],stack.peek());
			}
			stack.push(nums[i]);
		}
		return nextGreaterMap;
	}

}