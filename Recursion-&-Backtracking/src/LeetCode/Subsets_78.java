
import java.util.*;

// Given an integer array nums of unique elements, return all possible subsets (the power set).
// The solution set must not contain duplicate subsets. Return the solution in any order.
public class Subsets_78 {

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        List<List<Integer>> subsets = new ArrayList<>();
        findSubset(nums, 0, new ArrayList<Integer>(), subsets);
        System.out.println(subsets);
    }

    public static void findSubset(int[] nums, int index, List<Integer> output, List<List<Integer>> subsets) {
        if (index == nums.length) {
            subsets.add(output);
            return;
        }
        output.add(nums[index]);
        findSubset(nums, index + 1, new ArrayList<Integer>(output), subsets);
        output.remove(output.size() - 1);
        findSubset(nums, index + 1, new ArrayList<Integer>(output), subsets);
    }
}
