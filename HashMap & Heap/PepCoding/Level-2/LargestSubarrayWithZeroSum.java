import java.util.*;
public class LargestSubarrayWithZeroSum{

	public static void main(String[] args) {
		int[] nums={15,-2,2,-8,1,7,10,23};
		System.out.println("Maximum Length >> "+countSubarrayWithZeroSum(nums));
	}
	
	public static int countSubarrayWithZeroSum(int[] nums){
		HashMap<Integer, ArrayList<Integer>> hashMap = new HashMap<>();
		int sum = 0;
		int i = 0;
		int count=0;
		while (i < nums.length) {
			sum += nums[i];
			if (sum == 0) {
				count++;
				System.out.println("SubArray Fund >> 0   " + i);
			} else if (hashMap.containsKey(sum)) {
				ArrayList<Integer> indexList = hashMap.get(sum);
				for (Integer idx : indexList) {
					count++;
					System.out.println("SubArray Fund >>   " + (idx + 1) + " " + i);
				}
				indexList.add(i);
				hashMap.put(sum, indexList);
			} else {
				ArrayList<Integer> list = new ArrayList<>();
				list.add(i);
				hashMap.put(sum, list);
			}
			i++;
		}
		return count;
	}
}