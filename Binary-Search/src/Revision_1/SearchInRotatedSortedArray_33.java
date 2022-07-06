public class SearchInRotatedSortedArray_33{

	public static void main(String[] args){
		int[] nums={4,5,6,7,0,1,2};
		int target=0;
		System.out.println(findMin(nums,target));
	}
	
	public static int findMin(int[] nums,int target) {
        int left=0;
		int right=nums.length-1;
		while(right >= left){
			int mid=left+(right-left)/2;
			if(target==nums[mid]) return mid;
			else if(nums[mid] >= nums[left]){
				//this sorted part of array
				if(target >=nums[left] && target < nums[mid]){
					right=mid-1;
				}else{
					left=mid+1;
				}
			}
			else if(nums[right] >= nums[mid]){
				//this sorted part of array
				if(target > nums[mid] && target <= nums[right]){
					left=mid+1;
				}else{
					right=mid-1;
				}
			}
		}
		return -1;
    }
}