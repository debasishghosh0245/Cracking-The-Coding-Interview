import java.util.*;
public class GetCommonElements1 {
    
    public static void main(String[] args){
        int[] arr1={5,5,9,8,5,5,8,0,3};
        int[] arr2={9,7,1,0,3,6,5,9,1,1,8,0,2,4,2,9,1,5};
        getCommonElement(arr1,arr2);
    }
    
    public static void getCommonElement(int[] arr1, int[] arr2) {
        HashSet<Integer> hashSet1=new HashSet<>();
        HashSet<Integer> hashSet2=new HashSet<>();
        for(int i : arr1) {
            hashSet1.add(i);
        }
        for(int i: arr2){
            hashSet2.add(i);
        }
        if(hashSet1.size() < hashSet2.size()) {
            printCommonElement(hashSet1,hashSet2);
        }
        else{
            printCommonElement(hashSet2,hashSet1);
        } 
    }
    
    
    public static void printCommonElement(HashSet<Integer> hashSet1,
        HashSet<Integer> hashSet2) {
        //System.out.println("print hashSet >> "+hashSet1);
        //System.out.println("print hashSet >> "+hashSet2);
        for(int i : hashSet1){
            if(hashSet2.contains(i)){
                System.out.print(i+" ");
            }
        }
    }
}