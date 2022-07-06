public class Subarray {
    
    public static void main(String[] args){
       int[] arr={10,20,30};
       for(int i=0;i<arr.length;i++) {
           for(int j=i;j<arr.length;j++){
               for(int k=i;k<=j;k++){
                   System.out.print(arr[k]+"\t");
               }
               System.out.println(" ");
           }
       }
    }
}