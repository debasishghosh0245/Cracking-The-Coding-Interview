package LeetCode;
import java.util.*;
public class IntersectionOfTwoArraysII_350 {
    public static void main(String[] args) {
       int[] nums1 = {4,9,5};
       int[] nums2 = {9,4,9,8,4};
    //    int[] nums1 = {1,2,2,1};
    //    int[] nums2 = {2};
    //    int[] oparr=intersectionOfArrays(nums1, nums2);
       int[] oparr=findIntersectionTwoPointer(nums1, nums2);
       for(Integer i: oparr){
           System.out.println(i);
       }
    }

    //get intersetion of 2 arrays //
    public static int[] intersectionOfArrays(int[] nums1,int[] nums2){
        int[] result=new int[nums1.length];
        int idx=0;
        Map<Integer,Integer> hashMap=new HashMap<>();
        for(Integer i:nums2){
            hashMap.put(i,hashMap.getOrDefault(i,0)+1);
        }
        for(Integer j:nums1){
           if(hashMap.containsKey(j) && hashMap.get(j)>0) {
               result[idx++]=j;
               hashMap.put(j, hashMap.get(j)-1);
           }
        }
        return  Arrays.copyOf(result, idx);
    }
    
    public static int[] findIntersectionTwoPointer(int[] nums1,int[]  nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i=0;int j=0;
        int k=0;
        int[] result=new int[nums2.length];
        while(i<nums1.length && j<nums2.length) {
                if(nums1[i]==nums2[j]) {
                    result[k++]=nums1[i];
                    i++;  j++;
                }else if(nums1[i]<nums2[j]) {
                   i++;
                }else{
                   j++;
                }
        }
        return Arrays.copyOf(result, k);
    }
}
