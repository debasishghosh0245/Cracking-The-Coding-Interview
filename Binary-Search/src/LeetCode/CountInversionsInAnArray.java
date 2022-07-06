import java.util.*;
public class CountInversionsInAnArray{
	
	static int countInversion=0;
	
	public static void main(String[] args){
		int[] arr={8, 4, 2, 1};
		System.out.println("Merge Sort >> "+Arrays.toString(mergeSort(arr,0,arr.length-1)));
		System.out.println("Count Number of Inversion >> "+countInversion);
	}
	
	public static int[] mergeSort(int[] arr,int low,int high){
		if(low==high) {
			return new int[]{arr[low]};
		}
		int mid=low+(high-low)/2;
		int[] left=mergeSort(arr,low,mid);
		int[] right=mergeSort(arr,mid+1,high);
		return mergeTwoSortedArray(left,right);
	}

	public static int[] mergeTwoSortedArray(int[] arr1,int[] arr2){
		int[] result=new int[arr1.length+arr2.length];
		int i=0,j=0,r=0;
		while(i<arr1.length && j<arr2.length){
			if(arr1[i] <= arr2[j]){
				result[r++]=arr1[i++];
			}
			else {
				countInversion+=arr1.length-i;
				result[r++]=arr2[j++];
			}
		}
		while(i<arr1.length){
			result[r++]=arr1[i++];	
		}
		while(j<arr2.length){
			result[r++]=arr2[j++];
		}
		return result;
	}	
}