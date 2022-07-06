import java.util.*;
public class FirstAndLastPostionOfElement{
	
	public static void main(String[] args){
		int[] nums={2,2,3,3,3,4,5};
		System.out.println(Arrays.toString(find(nums,3)));
	}
	
	  public static int[] find(int[]arr,int target) {
        int[] res={-1,-1};
        findFristOccurence(arr,target,res);
        findLastOccurence(arr,target,res);
        return res;
    }
    
    
    public static void findFristOccurence(int[] nums,int target,int[] res){
		int left=0;
		int right=nums.length-1;
		while(right>=left){
			int mid=left+(right-left)/2;
			if(target==nums[mid]) {
			    res[0]=mid;
				right=mid-1;
			}
			else if(target > nums[mid]) {
				left=mid+1;
			}
			else{
				right=mid-1;
			}
		}
	}
	
	public static void findLastOccurence(int[] nums,int target,int[] res){
		int left=0;
		int right=nums.length-1;
		while(right >= left) {
			int mid=(left+(right-left)/2);
			if(target==nums[mid]) {
			    res[1]=mid;
				left=mid+1;
			}
			else if(target > nums[mid]) {
				left=mid+1;
			}
			else{
				right=mid-1;
			}
		}
	}	
	
}