package LeetCode;

public class FindFirstLastPositionSortedArray_34 {
    
    public static void main(String[] args) {
       int[] nums = {5,7,7,8,8,10};
       int  target = 8; 
       searchRange(nums,target);
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] result={-1,-1};
        int fastIndex=search(nums,target,true);
        int lastIndex=search(nums,target,false);
        System.out.println(fastIndex);
        System.out.println(lastIndex);
        return result;
    }
    public static int search(int[] nums,int target,boolean fastIndex) {
        int ans=-1;
        int left=0;
        int right=nums.length-1;
        while(left<=right) {
             int mid=left+(right-left)/2;
             if(target==nums[mid]) {
                 ans=mid;
                if(fastIndex) {
                    right=mid-1;
                }else{
                    left=mid+1;
                }
             }
             else if(target>nums[mid]) {
                   left=mid+1;
             }else{
                   right=mid-1;
             }
        }
        return ans;
    }
}
