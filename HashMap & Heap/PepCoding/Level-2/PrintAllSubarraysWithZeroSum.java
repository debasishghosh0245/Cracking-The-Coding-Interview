import java.util.*;
public class PrintAllSubarraysWithZeroSum{

	public static void main(String[] args) {
		int[] nums={6, 3, -1, -3, 4, -2, 2,4, 6, -12, -7};
		printSubarrayWithZeroSum(nums);
	}
	
	public static void printSubarrayWithZeroSum(int[] nums){
		HashMap<Integer, ArrayList<Integer>> hashMap = new HashMap<>();
		int sum = 0;
		int i = 0;
		while (i < nums.length) {
			sum += nums[i];
			if (sum == 0) {
				System.out.println("SubArray Fund >>   0 " + i);
			} else if (hashMap.containsKey(sum)) {
				ArrayList<Integer> indexList = hashMap.get(sum);
				for (Integer idx : indexList) {
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
	}
}