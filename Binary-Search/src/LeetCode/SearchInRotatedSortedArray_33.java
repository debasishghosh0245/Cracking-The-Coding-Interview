package LeetCode;

public class  SearchInRotatedSortedArray_33 {

    public static void main(String[] args) {
        int[] nums = {2,5,6,0,0,1,2};
        int target = 0;
        System.out.println(search(nums,target));
    }

    public static int findRotationIndex(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        if (arr[right] >= arr[left]) {
            return left;
        }
        while (left <= right) {
            int mid = right + (left - right) / 2;
            if (arr[mid] < arr[mid - 1]) {
                return mid;
            } else if (arr[mid + 1] < arr[mid]) {
                return mid + 1;
            } else if (arr[mid] > arr[0]) {
                left = mid + 1;
            } else {
                right = mid;
            }

        }
        return 1;
    }

    public static int search(int[] arr, int left, int right, int target) {
        while (left <= right) {
            int mid = (right + (left - right) / 2);
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    //int[] nums = { 4, 5, 6, 7, 8, 1, 2, 3 };
    public static int search(int[] arr, int target) {
        int left=0;
        int right=arr.length-1;
        while(left<=right) {
             int mid=right+(left-right)/2;
             if(arr[mid]==target)  {
                 return mid;
             }
             else if(arr[mid]>arr[left]) {
               if(arr[mid]>target && target>=arr[left]) {
                   right=mid-1;
               }else{
                   left=mid+1;
               }
            } else{
                if(arr[mid]<target && target<=arr[right]) {
                    left=mid+1;
                }else{
                    right=mid-1;
                }
            }
        }
       return -1;
    }
}
