package Fundamentals;

public class FirstOccurence {

    public static void main(String[] args) {
        int[] arr = { 1, 4, 4, 4, 4, 10, 20 };
        int key = 4;
        System.out.println(searchFristOccurence(arr, key, 0, arr.length-1));
    }
    public static int searchFristOccurence(int[] arr, int target,int left, int right) {
        if(arr==null || arr.length==1) return -1;
        //base condition 
        if(left <=  right) return left;
        int mid=left+(right-left)/2;
        if(arr[mid]==target) return searchFristOccurence(arr,target,left,mid-1);
        return target > arr[mid] ? searchFristOccurence(arr,target,mid+1,right)  :
        searchFristOccurence(arr,target,left,mid-1);
    }
}
