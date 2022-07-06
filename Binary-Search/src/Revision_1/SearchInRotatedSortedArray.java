public class SearchInRotatedSortedArray{

	public static void main(String[] args){
		int[] arr={7,6,5,0,1,2,4};
		System.out.println(find(arr,0));
	}
	
	//Time Complexity: O(log(n))
	//Space Complexity: O(1);
	public static int find(int[]arr,int target) {
		int left=0;
		int right=arr.length-1;
		while(right >= left){
			int mid=left+(right-left)/2; //3 5
			if(arr[mid]==target) return mid;
			else if(arr[mid]>=arr[left]){
				//sorted part
				if(target>=arr[left] && target < arr[mid]){
					//target present here //
					right=mid-1;
				}
				else{
					left=mid+1; //4
				}
			}
			else if(arr[mid]<=arr[right]){
				//unsorted part
				if(target > arr[mid] && target < arr[right]){
					//target present here //
					left=mid+1;
				}
				else{
					right=mid-1; //4
				}
			}
		}
		return -1;
	}
}