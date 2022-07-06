package LeetCode;

// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/submissions/

class FindMinimumInRotatedSortedArrayII_154 {
    public static void main(String[] args) {
        // int[] arr = { 2, 2, 2, 4, 5, 6, 7, 0, 1, 1, 1, 2 };
        int[] arr= {2,1};
        System.out.println(arr[findMinimum(arr)]);
    }

    public static int findMinimum(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (right >= left) {
            int mid=left+(right-left)/2;
            if(mid>0 && mid<arr.length-1 && 
                   arr[mid]<arr[mid-1] 
                     && arr[mid]<arr[mid+1]) {
                return arr[mid];
            }
            if(arr[mid]>arr[right]) {
                //This partion from left to mid is sorted 
                left=mid+1;
            }else if(arr[mid]<arr[right]){
                right=mid; //mid might the minimum element 
            }else if(arr[mid]==arr[right]){
                right--;
            }

        }
        return arr[left];
    }
}