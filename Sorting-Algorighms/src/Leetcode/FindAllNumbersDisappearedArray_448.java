package Leetcode;
import java.util.*;

public class FindAllNumbersDisappearedArray_448 {

    public static void main(String[] args) {
    //    int[] nums = {4,3,2,7,8,2,3,1};
       int[] nums={1,1};
       List<Integer> list= findDisappearedNumbers(nums);
       System.out.println(list.toString());
      
    }
  
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list=new ArrayList<>();
        cyclicSort(nums);
        System.out.println(Arrays.toString(nums));
        for(int i=0;i<nums.length;i++) {
            if(nums[i]-1!=i){
              list.add(i+1);
            }
        }
        return list;
    }
    
    public static void cyclicSort(int[] arr) {
        int i=0;
        while(i<arr.length) {
            int correct=arr[i]-1;
            if(arr[i]!=arr[correct]){
               int temp=arr[i];
               arr[i]=arr[correct];
               arr[correct]=temp;
            }else{
                i++;
            }
        }
    }   
}

