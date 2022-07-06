import java.util.*;
public class GetCommonElements2 {

     public static void main(String[] args){
        int[] arr1={5,5,9,8,5,5,8,0,3};
        int[] arr2={9,7,1,0,3,6,5,9,1,1,8,0,2,4,2,9,1,5};
        getCommonElement(arr1,arr2);
    }
    //best alorithms
    public static void getCommonElement(int[] arr1, int[] arr2) {
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int i=0;
        int j=0;
        while(i<arr1.length && j<arr2.length) {
            if(arr1[i]==arr2[j]){
                System.out.print(arr1[i]+" ");
                i++;
                j++;
            }
            else if(arr1[i] < arr2[j]) {
                i++;
             
            }else{
                j++;
            }
        }
    }    
}