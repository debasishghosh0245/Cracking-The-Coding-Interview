import java.util.*;
public class AllIndicesOfArray {
    
	public static void main(String[] args) {
		int[] arr={15,11,40,4,4,9};
		int target=4;
		int[] result=new int[arr.length];
		int[] output=allIndices(arr,target,0,0);
		System.out.println(Arrays.toString(output));
		
	}
	
	public static int[] allIndices(int[] arr, int x, int idx,int fsf) {
		 if(idx>=arr.length-1) {
			return new int[fsf];
		 }
		 if(x==arr[idx]){
			  int[] iarr=allIndices(arr,x,idx+1,fsf+1);
			  iarr[fsf]=idx;
			  return iarr;
		 }else{
			   return allIndices(arr,x,idx+1,fsf);
		 }
    }


}