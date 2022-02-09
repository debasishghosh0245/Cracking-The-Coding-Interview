package unacademy;

import java.util.*;

public class SubsetSum {

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3 };
        List<Integer> subsetSum = new ArrayList<Integer>();
        List<List<Integer>> subset = new ArrayList<List<Integer>>();
        calSubsetSum(arr, 0, 0, subsetSum, subset, new ArrayList<Integer>());
        System.out.println(subset);
        System.out.println(subsetSum);
    }

    public static void calSubsetSum(int[] arr, int index, int sum, List<Integer> subsetSum, List<List<Integer>> subset,
            List<Integer> output) {
        if (index == arr.length) {
            subset.add(output);
            subsetSum.add(sum);
            return;
        }
        sum = sum + arr[index];
        output.add(arr[index]);
        calSubsetSum(arr, index + 1, sum, subsetSum, subset, new ArrayList<>(output));
        sum = sum - arr[index];
        output.remove(output.size() - 1);
        calSubsetSum(arr, index + 1, sum, subsetSum, subset, new ArrayList<>(output));
    }
}
