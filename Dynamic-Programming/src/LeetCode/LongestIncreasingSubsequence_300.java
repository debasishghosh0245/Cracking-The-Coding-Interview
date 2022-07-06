public class LongestIncreasingSubsequence_300 {

	public static void main(String[] args) {
		int[] nums = {1,3,2};
		Integer[][] memo = new Integer[nums.length + 1][nums.length + 1];
		System.out.println("Longest Increasing " + longestIncreasingSubseqTab(nums));
	}

	// Approach 1: Recursive
	public static int longestIncreasingSubseq(int[] nums, int idx, int lastIdx) {
		if (idx >= nums.length)
			return 0;
		int notTake = longestIncreasingSubseq(nums, idx + 1, lastIdx);
		int take = Integer.MIN_VALUE;
		if (lastIdx == -1 || nums[idx] > nums[lastIdx]) {
			take = 1 + longestIncreasingSubseq(nums, idx + 1, idx);
		}
		int result = Math.max(take, notTake);
		return result;
	}

	// Approach 2 : Memorization // Bottom -up
	public static int longestIncreasingSubseqMemo(int[] nums, int idx, int lastIdx,
		Integer[][] memo) {
		if (idx >= nums.length)
			return 0;
		if (memo[idx][lastIdx + 1] != null)
			return memo[idx][lastIdx + 1];
		int notTake = longestIncreasingSubseqMemo(nums, idx + 1, lastIdx, memo);
		int take = Integer.MIN_VALUE;
		if (lastIdx == -1 || nums[idx] > nums[lastIdx]) {
			take = 1 + longestIncreasingSubseqMemo(nums, idx + 1, idx, memo);
		}
		int result = Math.max(take, notTake);
		memo[idx][lastIdx + 1] = result;
		return result;
	}

	//Approach 3: Tabular // Top-down
	public static int longestIncreasingSubseqTabullar(int[] nums) {
		int[][] dp = new int[nums.length + 1][nums.length + 1];
		for (int idx = nums.length; idx >= 0; idx--) {
			for(int lastIdx = nums.length; lastIdx >= 0; lastIdx--) {
				if (idx == nums.length ) {
					dp[idx][lastIdx]=0;
				} else {
					int notTake = dp[idx + 1][lastIdx];
					int take = Integer.MIN_VALUE;
					if (lastIdx == nums.length || nums[idx] > nums[lastIdx]) {
						take = 1 + dp[idx + 1][idx];
					}
					dp[idx][lastIdx] = Math.max(take, notTake);
				}
			}
		}
		for (int idx = 0; idx < nums.length + 1; idx++) {
			for (int lastIdx = 0; lastIdx < nums.length + 1; lastIdx++) {
				System.out.print(dp[idx][lastIdx]);
			}
			System.out.println(" ");
		}
		return dp[0][nums.length];
	}
}