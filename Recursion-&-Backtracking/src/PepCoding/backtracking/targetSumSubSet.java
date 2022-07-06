package PepCoding.backtracking;

import java.util.*;
public class targetSumSubSet {
  
   public static void main(String[] args) {
       //String str="abc";
       int[] arr={10,20,30};
       printSubsets(arr,0,"",0,60);
   }
   
   public static void printSubsets(String str,String ans) {
        if(str.length()==0) {
           System.out.println(ans);
           return ;
        }
        char ch=str.charAt(0);
        String ros=str.substring(1);
        printSubsets(ros,ans);
        printSubsets(ros,ans+ch);
       
   }
   
    public static void printSubsets(int[] arr,int idx,List<Integer> ans) {
        if(arr.length==idx) {
           System.out.println(ans);
           return ;
        }
        printSubsets(arr,idx+1,new ArrayList<Integer>(ans));
        ans.add(arr[idx]);
        printSubsets(arr,idx+1,new ArrayList<Integer>(ans));
       
   }
   
   public static void printSubsets(int[] arr,int idx,String ans,int currentSum,int target) {
        if(arr.length==idx) {
            if(target==currentSum) {
                System.out.println(ans);
            }
           return ;
        }
        printSubsets(arr,idx+1,ans,currentSum,target);
        printSubsets(arr,idx+1,ans+" "+arr[idx]+"",currentSum+arr[idx],target);
   }
   
   
   

}
