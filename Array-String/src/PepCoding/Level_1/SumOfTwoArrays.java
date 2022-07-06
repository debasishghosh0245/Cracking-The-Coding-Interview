import java.util.*;
public class SumOfTwoArrays {

    public static void main(String[] args){
        //int[] arr1={9,3,4,6,8};
        //int[] arr2={1,9,8,8};
        int[] arr2 = new int[]{3,1,0,7,5 };
        int[] arr1 = new int[]{1,1,1,1,1,1};
        int[] arr=sum(arr1,arr2);
    }
    
    public static int[] sum(int[] arr1,int[] arr2){
        int[] arr=new int[arr1.length > arr2.length ? arr1.length : arr2.length];
        int i=arr1.length-1;
        int j=arr2.length-1;
        int k=arr.length-1;
        int rem=0;
        while(i>=0 || j>=0) {
            int sum=rem;
            if(i>=0){
               sum+=arr1[i];    
            }
            if(j>=0){
               sum+=arr2[j];    
            }
            if(k>=0){
               arr[k]=sum%10; 
            }
            rem=sum/10;
            i--; j--; k--;
        }
        if(rem!=0){
            System.out.println(rem);
        }
        for(int val: arr){
            System.out.println(val);
        }
        return arr;
    }
}