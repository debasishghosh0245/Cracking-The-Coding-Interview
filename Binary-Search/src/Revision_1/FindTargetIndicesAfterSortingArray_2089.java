import java.util.*;
public class FindTargetIndicesAfterSortingArray_2089{
	
	public static void main(String[] args){
		int[] nums={1,2,5,2,3};
		int target=2;
		Arrays.sort(nums);
		List<Integer> result=new ArrayList<Integer>();
		targetIndices(nums,target,result);
		//findLastPosition(nums,target,result);
		System.out.println(result);
	}
	
	public static void targetIndices(int[] nums,int target){
		int count = 0, lessthan = 0;
        for (int n : nums) {
            if (n == target) count++;
            if (n < target) lessthan++;
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            result.add(lessthan++);
        }
        return result;			
	}
	
}
	
