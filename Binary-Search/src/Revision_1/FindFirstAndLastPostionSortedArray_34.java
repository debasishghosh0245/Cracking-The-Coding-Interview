public class FindFirstAndLastPostionSortedArray_34{

	public static void main(String[] args){
		int[] nums={5,7,7,8,8,10};
        int target=8;
		System.out.println(findFirstPosition(nums,target));
		System.out.println(findLastPosition(nums,target));
	}
	
	public static int findFirstPosition(int[] nums,int target){
		int left=0;
		int right=nums.length-1;
		int firstPostion=-1;
		while(right >= left){
			int mid=left+(right-left)/2;
			if(nums[mid]==target) {
				firstPostion=mid;
				right=mid-1;
			}
			else if(target > nums[mid]){
				//check right side
				left=mid+1;
			}else {
				right=mid-1;
			}
		}
		return right+1;		
	}
	
	public static int findLastPosition(int[] nums,int target){
		int left=0;
		int right=nums.length-1;
		int lastPostion=-1;
		while(right >= left){
			int mid=left+(right-left)/2;
			if(nums[mid]==target) {
				 lastPostion=mid;
				 left=mid+1;
			}
			else if(target > nums[mid]){
				left=mid+1;
			}else {
				right=mid-1;
			}
		}
		return left-1;		
	}
}