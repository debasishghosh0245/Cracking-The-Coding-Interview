import java.util.*;
public class InverseOfAnArray {
    
    public static void main(String[] args){
        
        int[] arr={4,0,2,3,1};
        int[] res=new int[arr.length];
        
        for(int i=0;i<arr.length;i++){
            res[arr[i]]=i;
        }
        for(int val: res){
            System.out.println(val);
        }
    }
}