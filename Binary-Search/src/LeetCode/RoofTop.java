public class RoofTop {

	public static void main(String[] args){
		int[] nums={1,4,5,2,3,2,4};
		System.out.println(findMaxSteps(nums));
	}
	
	public static int findMaxSteps(int[] nums) {
        int count=0;
		int maxCount=0;
		for(int i=0;i<nums.length-1;i++){
			if(nums[i]<nums[i+1]){
				count++;
				maxCount=Math.max(count,maxCount);
			}
			else count=0;
		}
        return maxCount;
    }
}