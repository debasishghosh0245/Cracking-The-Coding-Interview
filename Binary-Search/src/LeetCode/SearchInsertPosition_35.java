package LeetCode;

public class SearchInsertPosition_35 {
    
    public static void main(String[] args) {
    int[] arr={1,2,3,4,7,8,10,12,15};
    int target=5; 
      System.out.println("Upper Bound Or Floot of Array >> "+arr[search(arr, target)]);
    }
    public static int search(int[] arr,int target) {
        int left=0;int right=arr.length-1;
        if(arr[right]<target) return right+1;
        while(left<=right) {
            int mid=(left+right)/2; //3
            if(arr[mid]==target) return mid;
            else if(arr[mid]>target) {
                right=mid-1; //3
            }else{
                left=mid+1; //1
            }
        }
        return left;
    }
}
