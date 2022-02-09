package LeetCode;

public class SearchInRotatedSortedArrayII_81 {
    public static void main(String[] args) {
        // int arr[]={5,1,3};
        // int target=3;
       int[] nums = {2,5,6,0,0,1,2}; int target = 0;
       System.out.println(search(nums,target));
    }
    public static int search(int[] arr,int target){
        int left=0; int right=arr.length-1;
        while(left<=right) {
            int mid=left+(right-left)/2;
            if(target==arr[mid]) return mid;
            else if(arr[mid]>arr[left]) {
                if(arr[left] <= target && target <=arr[mid]) {
                         right=mid-1;
                }else{
                         left=mid+1;
                }
            }
            else if(arr[mid]<arr[left]){
                if(arr[mid]<=target && target <=arr[right]){
                   left=mid+1;
                }else{
                   right=mid-1;
                }
            }
            else if(arr[mid]==arr[left]){
                   left=left+1;
            }
        }
        return -1;
    }

    public static class DivideChocolate_1231{

          public static void main(String[] args){
            int[] sweetness = {1,2,3,4,5,6,7,8,9}; int k = 5;
            System.out.println(maximizeSweetness(sweetness,k+1));
          }
          public static int maximizeSweetness(int[] sweetness, int cuts) {
                int low = Integer.MAX_VALUE, high = 0;
                for(int sweet : sweetness) {
                      high += sweet;
                      low = Math.min(low, sweet);
                }
                System.out.println("low >> "+low+" high>>" +high);
                while(low<=high) {
                      int mid=low+(high-low)/2;
                      if(isPossible(sweetness,cuts,mid)) {
                            high=mid-1;
                      }else{
                            low=mid+1;
                      }
                }
                return low;
          }

          public static boolean isPossible(int[] sweetness,int cuts,int target) {
                int sum=0;
                for(int i=0;i<sweetness.length;i++) {
                      sum+=sweetness[i];
                      if(sum>target) {
                            sum=0;
                            cuts--;
                      }
                }
                return cuts>=1;
          }


    }
}
