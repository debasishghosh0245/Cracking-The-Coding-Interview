import java.util.*;
public class MergeSort {

	public static void main(String[] args){
		int[] arr={2,8,1,4};
		//int[] arr2={1,4};
		System.out.println("Merge Sort >> "+Arrays.toString(mergeSort(arr,0,arr.length-1)));
	}
	
	public static int[] mergeSort(int[] arr,int left,int right){
		if(left==right) {
			return new int[]{arr[left]};
		}
		int mid=left+(right-left)/2;
		int[] leftPart=mergeSort(arr,left,mid);
		int[] rightPart=mergeSort(arr,mid+1,right);
		return mergeTwoSortedArray(leftPart,rightPart);
	}

	public static int[] mergeTwoSortedArray(int[] arr1,int[] arr2){
		int[] result=new int[arr1.length+arr2.length];
		int i=0,j=0,r=0;
		while(i<arr1.length && j<arr2.length){
			if(arr1[i] <= arr2[j]){
				result[r++]=arr1[i++];
			}
			else {
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