import java.util.*;
public class RotateAnArray {

    public static void main(String[] args) {
		int[] arr={1,2,3,4,0,0,5,6};
		int[] result=null;
		for(int i=0;i<2;i++) {
		   result=rotate(arr);
		}
		System.out.println(Arrays.toString(result));
	}
	
	public static int[] rotate(int[] arr) {
		for(int i=arr.length-1;i > 0;i--) {
			int temp=arr[i];
			arr[i]=arr[i-1];
			arr[i-1]=temp;
		}
		return arr;
	}
}