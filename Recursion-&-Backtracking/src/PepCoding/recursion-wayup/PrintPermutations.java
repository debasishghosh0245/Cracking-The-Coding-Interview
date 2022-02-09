import java.util.*;
public class PrintPermutations {
    public static void main(String[] args) {
        String str="abc";
         int[] arr={10,20,30};
        // for(int i=0;i<arr.length;i++) {
             // System.out.println(Arrays.toString(Arrays.copyOfRange(arr,0,i)));
             // System.out.println(Arrays.toString(Arrays.copyOfRange(arr,i+1,arr.length)));
        // }
        printPermutations(arr,0,"");
    }

    public static void printPermutations(String str, String ans) {
        if(str.length()==0){
            System.out.println(ans);
            return;
        }
        for(int i=0;i<str.length();i++) {
            char ch=str.charAt(i);
            String ros=str.substring(0,i)+str.substring(i+1);
            printPermutations(ros,ans+ch);
        }
    }
    
    public static void printPermutations(int[] arr,int idx,String ansf) {
        if(idx==arr.length) {
            System.out.println(ansf+" ");
            return;
        }
        for(int i=0;i<arr.length;i++) {
            printPermutations(arr,idx+1,ansf+arr[i]+" ");
        }
    }
    
    
}