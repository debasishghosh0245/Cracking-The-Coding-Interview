package LeetCode;

public class SingleElementInSortedArray_540 {
    public static void main(String[] args) {
       //int[] nums = {1,1,2,3,3,4,4,8,8};
       int[] nums={10,3,3,7,7,11,11};
      // int[] nums={1};
       //int[] nums={1,1,2};
       System.out.println(search(nums));
    }


    public static int singleNonDuplicate(int[] nums) {
        int left=0; int right=nums.length-1;
        //if the array contains single elements only 
        if(nums.length==1) return nums[0];
        while(left<=right) {
            int mid=left+(right-left)/2;
            if(mid>0 && nums[mid]!=nums[mid-1] 
                  && mid<nums.length && nums[mid]!=nums[mid+1]) {
                    return mid;
            }else{
                 if(mid%2==0) {
                     right=mid-1;
                 }else{
                     left=mid+1;
                 }
            }
        }     
        return 0;
    }
    //Brute Force Solutino : Start 
    public static int search(int[] nums) {
          for(int i=0;i<nums.length-1;i=i+2){
              if(nums[i]!=nums[i+1]) {
                  return nums[i];
              }
          }
          return nums[nums.length-1];
    }
    //Brute Force Solution : End //

}
