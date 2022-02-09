import java.util.*;

/* https://leetcode.com/problems/permutations/ */
public class Permutations46 {
    
    
    public static void main(String[] args){
        int[] nums={1,2,3};
        List<List<Integer>> output=permute(nums);
        System.out.println(output);
    }
     
    public static List<List<Integer>> permute(int[] nums) {
        boolean[] placed=new boolean [nums.length];
        return helper(nums,new ArrayList<Integer>(),new ArrayList<List<Integer>>(),placed);
    }
    
    public static List<List<Integer>> helper(int[] nums,List<Integer> ans,
        List<List<Integer>> list,boolean[] placed) {
        if(ans.size()==nums.length) {
            list.add(new ArrayList<>(ans));
            return list;
        }
        for(int i=0;i<nums.length;i++) {
            if(placed[i]==false) {
                placed[i]=true;
                ans.add(nums[i]);
                helper(nums,ans,list,placed);
                ans.remove(ans.size()-1);
                placed[i]=false;
            } 
        }
        return list;
    }
}