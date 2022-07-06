public class FindPivotIndex24{

	public static void main(String[] args){
		//int[] nums ={1,7,3,6,5,6};
		int[] nums={2,-1,1};
		System.out.println("Pivot Index "+pivotIndex(nums));
	}
	
	public static int pivotIndex(int[] nums) {
        int prefix_sum=0;
		int total_sum=0;
		int middle_idx=0;
		for(int num:nums){
			total_sum+=num;
		}
		for(int i=0;i<nums.length;i++){
			prefix_sum+=nums[i];
			if(prefix_sum==total_sum) return i;
			total_sum-=nums[i];
		}
		return -1;
    }

}