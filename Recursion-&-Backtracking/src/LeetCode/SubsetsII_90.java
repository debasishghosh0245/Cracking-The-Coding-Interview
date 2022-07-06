

import java.util.*;

public class SubsetsII_90 {
    // Given an integer array nums that may contain duplicates, return all possible
    // subsets (the power set).
    // The solution set must not contain duplicate subsets. Return the solution in  any order.
    // Example 1:
    // Input: nums = [1,2,2]
    // Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
    public static void main(String[] args) {
        Set<List<Integer>> subsetsLists = new HashSet<>();
        int[] arr = {1,2,2};
        Arrays.sort(arr);
        subsetsWithOutDup(arr, subsetsLists, 0, new ArrayList<Integer>());
        System.out.println(subsetsLists);
    }

    public static void subsetsWithOutDup(int[] nums, Set<List<Integer>> subset, int index, List<Integer> output) {
        if (nums.length == index) {
            subset.add(output);
            return;
        }
        output.add(nums[index]);
        subsetsWithOutDup(nums, subset, index+1, new ArrayList<Integer>(output));
        output.remove(output.size() - 1);
        subsetsWithOutDup(nums, subset, index+1, new ArrayList<Integer>(output));
        return;
    }
}
