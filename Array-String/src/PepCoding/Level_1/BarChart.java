import java.util.*;
public class BarChart {

    public static void main(String[] args) {
        int[] arr={3,1,0,7,5};
        int max=arr[0];
        for(int i=0;i<arr.length;i++) {
            max=Math.max(arr[i],max);
        }        
        for(int i=max;i>0;i--) {
            for(int j=0;j<arr.length;j++){
               if(i<=arr[j]){
                  System.out.print("*\t"); 
               }else{
                  System.out.print("\t");
               }
            }
            System.out.println("");
        }
    }
}