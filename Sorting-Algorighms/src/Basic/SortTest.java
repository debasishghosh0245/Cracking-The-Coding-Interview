import java.util.*;
class SortTest {
    
    public static void main(String[] args) {
        int[] arr={64,34,25,12,22,11,90};
        bubbleSortRecursive(arr,0,0);
        System.out.println(Arrays.toString(arr));
    
    }
    
    public static void bubblesort(int[] arr){
        for(int i=0;i<arr.length;i++) {
           for(int j=0;j<arr.length-1-i;j++) {
               if(arr[j] > arr[j+1] ) {
                   swap(arr,j,j+1);
               }else{
                   continue;
               }
            }
        }
    }
    
    public static void bubbleSortRecursive(int[] arr,int i,int j) {
        if(i==arr.length-1)   return;
        if(j==arr.length-1-i) return;
        if(arr[j] > arr[j+1]){
            swap(arr,j,j+1);
        }
        bubbleSortRecursive(arr,i,j+1); 
        bubbleSortRecursive(arr,i+1,j);
    }
    
    
    public static void swap(int[] arr, int i, int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}