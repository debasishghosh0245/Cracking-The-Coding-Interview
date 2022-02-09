package Leetcode;
import java.util.*;
public class FindAllDuplicatesInArray_442 {
    public static void main(String[] args) {
       int[] nums = {4,3,2,7,8,2,3,1};
        List<Integer> list= findDuplicates(nums);
        System.out.println(list);
    }
    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> list=new ArrayList<>();
        cyclicSort(nums);
        System.out.println(Arrays.toString(nums));
        for(int i=0;i<nums.length;i++) {
            if(i!=nums[i]-1){
                list.add(0,nums[i]);
            }
        }
        return list;
    }
    public static void cyclicSort(int[] arr) {
        int i=0;
        while(i<arr.length){
            int correctIndex=arr[i]-1;
            if(arr[i]!=arr[correctIndex]) {
                int temp=arr[i];
                arr[i]=arr[correctIndex];
                arr[correctIndex]=temp;
            }else{
                i++;
            }
        }
    }
}
