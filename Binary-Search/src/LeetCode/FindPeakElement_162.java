package LeetCode;

public class FindPeakElement_162 {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 1, 3, 5, 6, 4, 9, 10, 14 };
        int peek = findPeek(nums);
        System.out.println("Peek Element is " + peek);
    }

    public static int findPeek(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return nums[left];
    }
}
