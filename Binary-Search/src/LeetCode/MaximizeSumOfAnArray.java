import java.util.*;
public class MaximizeSumOfAnArray {

	public static void main(String[] args){
		int[] arr={2,3,1,5,4};
		System.out.println(maximise(arr));	
	}
	
	public static int maximise(int[] arr) {
        Arrays.sort(arr);
		int sum=0;
        for(int i=0;i<arr.length;i++){
			sum+=i*arr[i];
		}
		return sum;
	}
}