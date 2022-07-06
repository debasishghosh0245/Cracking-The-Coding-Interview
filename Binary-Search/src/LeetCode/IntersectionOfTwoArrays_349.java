package LeetCode;

import java.util.*;

public class IntersectionOfTwoArrays_349 {
    public static void main(String[] args) {
        int[] nums1 = { 1, 2, 2, 1 };
        int[] nums2 = { 2, 2 };
        // int[] nums1 = {4,9,5};
        // int[] nums2 = {9,4,9,8,4};
        int[] output=findIntersectionTwoPointer(nums1, nums2);
        for(int op: output) {
               System.out.println(op);
        }
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> hashset1 = new HashSet<>();
        Set<Integer> hashset2 = new HashSet<>();
        for (int i : nums1)  hashset1.add(i);
        for (int j : nums2)  hashset2.add(j);
        
        if(hashset1.size() < hashset2.size()) {
            return  set_intersection(hashset1, hashset2);
        }else{
            return set_intersection(hashset2, hashset1);
        }
    }

    public static int[] set_intersection(Set<Integer> set1, Set<Integer> set2) {
        int [] output = new int[set1.size()];
        int idx = 0;
        for (Integer s : set1)
        if (set2.contains(s)) output[idx++] = s;
        return Arrays.copyOf(output, idx);
      }

      public static int[] findIntersectionTwoPointer(int[] nums1,int[]  nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        HashSet<Integer> hashSet=new HashSet<Integer>();
        int i=0;int j=0;
        int k=0;
        int[] result=new int[nums2.length];
        while(i<nums1.length && j<nums2.length) {
                if(nums1[i]==nums2[j]) {
                    hashSet.add(nums1[i]);
                    i++;  j++;
                }else if(nums1[i]<nums2[j]) {
                   i++;
                }else{
                   j++;
                }
        }
        for(Integer value:hashSet){
             result[k++]=value;
        }
        return Arrays.copyOf(result, k);
    }

}
