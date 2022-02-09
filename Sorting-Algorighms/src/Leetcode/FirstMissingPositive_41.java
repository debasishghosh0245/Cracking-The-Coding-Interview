package Leetcode;

import java.util.Arrays;

public class FirstMissingPositive_41 {
    public static void main(String[] args) {
        int nums[] = { 3, 4, -1, 1 };
        // int nums[]={7,8,9,11,12};
        // int nums[]={1};
        //int [] nums = {1,2,0};
        int missingNum = firstMissingPositive(nums);
        System.out.println(missingNum);
    }

    public static int firstMissingPositive(int[] nums) {
        cyclicSort(nums);
        System.out.println(Arrays.toString(nums));
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length+1;
    }

    public static void cyclicSort(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int correctIndex = nums[i] - 1;
            if (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[correctIndex]) {
                int temp = nums[i];
                nums[i] = nums[correctIndex];
                nums[correctIndex] = temp;
            } else {
                i++;
            }
        }

    }
}
