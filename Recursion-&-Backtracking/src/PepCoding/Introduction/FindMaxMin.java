package PepCoding.Introduction;

public class FindMaxMin{
    
	public static void main(String[] args) {
		int[] arr={1,20,10,5,2,3,18};
		System.out.println(findMin(arr,0));
	}	
	
	public static int findMax(int[] arr,int idx){
		if(idx==arr.length-1){
			return arr[arr.length-1];
		}  
		int max=findMax(arr,idx+1);
		return arr[idx] > max ? arr[idx]: max;
	}
	
	public static int findMin(int[] arr,int idx){
		if(idx==arr.length-1){
			return arr[arr.length-1];
		}  
		int min=findMin(arr,idx+1);
		return arr[idx] < min ? arr[idx]: min;
	}


}