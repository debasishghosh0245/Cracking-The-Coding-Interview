public class FindMinimumRotatedSortedArray_153{

	public static void main(String[] args){
		int[] nums={3,1,2};
		System.out.println("min > "+findMin(nums));
	}
	
	public static int findMin(int[] nums) {
		//if the array is fully sorted //
		if(nums[nums.length-1] > nums[0]) return nums[0];
        int left=0;
		int right=nums.length-1;
		while(right >= left){
			int mid=left+(right-left)/2;
			if(mid<nums.length-1 && nums[mid]>nums[mid+1]) return mid+1;
			if(mid>0 && nums[mid]<nums[mid-1]) return mid;
			else if(nums[mid] > nums[left]){
				//this sorted part of array
				left=mid+1;
			}
			else if(nums[right] > nums[mid]){
				//this sorted part of array
				right=mid-1;
			}
		}
		return -1;
    }
}