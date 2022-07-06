public class FindMinimumRotatedSortedArray{

	public static void main(String[] args){
		int[] nums ={2,2,2,0,1};
		System.out.println("Minimum Index of Rotated Array >> "+find(nums));
	}
	
	public static int find(int[] nums){
		int left=0;
		int right=nums.length-1;
		if(nums[right]>nums[left]) return nums[left];
		while(right >= left){
			int mid=left+(right-left)/2;
			if(mid-1 > 0 && nums[mid]<nums[mid-1]){
				return nums[mid];
			}
			else if(mid < nums.length
				&& nums[mid]>nums[mid+1]){
				return nums[mid+1];
			}
			else if(nums[mid] >= nums[left]){
				left=mid+1;
			}
			else if(nums[mid] <= nums[right]){
				right=mid-1;
			}
		}
		return -1;
	}

}