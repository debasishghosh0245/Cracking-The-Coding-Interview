
import java.util.*;

public class CombinationSumII_40 {

    // Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where 
    // the candidate  numbers
    // sum to target. Each number in candidates may only be used once in the combination.

 public static void main(String[] args) {
        int[] candidates = { 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
        int target = 19;
        Set<List<Integer>> subsets = new HashSet<List<Integer>>();
        Arrays.sort(candidates);
        calCombinationSum(candidates, 0, target, subsets, new ArrayList<Integer>());
        System.out.println(new ArrayList<List<Integer>>(subsets));
}

public static void calCombinationSum(int[] candidates, int index, int target,  Set<List<Integer>> subsets,
        List<Integer> output) {
        if (index == candidates.length) {
            if (target == 0) {
                subsets.add(output);
            }
            return;
        }
        if (target >= candidates[index]) {
            output.add(candidates[index]);
            calCombinationSum(candidates, index+1, target - candidates[index], subsets, new ArrayList<Integer>(output));
            output.remove(output.size() - 1);
        }
           calCombinationSum(candidates, index + 1, target, subsets, new ArrayList<Integer>(output));
    }
}
