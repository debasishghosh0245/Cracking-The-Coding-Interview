
import java.util.*;
public class CombinationSum_39 {

    public static void main(String[] args) {
        /* int[] candidates ={2,3,6,7,4,-1};
        int target = 7;
        List<List<Integer>> subsets=new ArrayList<List<Integer>>();
        calCombinationSum(candidates,0,target,subsets,new ArrayList<Integer>());
        System.out.println(subsets); */
        int[] candidates ={2,3,5};
        int target=7;
        helper(candidates,0,new ArrayList<Integer>());
    }

    public static void calCombinationSum(int[] candidates, int index, 
        int target, List<List<Integer>> subsets, List<Integer> output) {
        if (index == candidates.length) {
            if (target == 0) {
                subsets.add(output);
            }
            return;
        }
        if (target >= candidates[index]) {
            output.add(candidates[index]);
            calCombinationSum(candidates, index, target - candidates[index],
                    subsets, new ArrayList<Integer>(output));
            output.remove(output.size() - 1);
        }
        calCombinationSum(candidates, index + 1, target, subsets,
            new ArrayList<Integer>(output));
    }
    
    
    public static void helper(int[] candidates, int index, List<Integer> output) {
        
        if(index==candidates.length) {
            System.out.println(output);
            return;
        }
        output.add(candidates[index]);
        helper(candidates,index+1,output);
        output.remove(output.size()-1);
        helper(candidates,index+1,output);
    }
}
