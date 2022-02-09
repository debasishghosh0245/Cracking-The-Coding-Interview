import java.util.*;
public class ThreeSum_15_HashMap {
    
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        //int[] nums={-1,0,1,2,-1,-4,-2,-3,3,0,4};
	    List<List<Integer>> output=threeSum(nums);
        System.out.println(output.toString());
    }
	public static List<List<Integer>> threeSum(int[] nums) {
         //Arrays.sort(nums);
         List<List<Integer>> result=new ArrayList<List<Integer>>();
         for(int i=0;i<nums.length && nums[i]<=0; ++i) {
               twoSum(nums,i,result);
         }
         return result;
    }
    public static void twoSum(int[] nums,int i,List<List<Integer>> result) {
        HashSet<Integer> seen=new HashSet<>();        
        for(int j=i+1;j<nums.length;j++) {
            int content=-nums[i]-nums[j];
            if(seen.contains(content)){
                result.add(Arrays.asList(nums[i],nums[j],content));
            }
            seen.add(nums[j]);
        }
    }
}