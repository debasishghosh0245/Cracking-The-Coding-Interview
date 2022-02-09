public class MaxOfAnArray{
    
	public static void main(String[] args) {
		int[] arr={6,15,30,40,4,11,50,600};
		System.out.println(findMax(arr,0));
	}
	
	public static int findMax(int[] arr, int idx) {
	    if (idx > arr.length-1)  {
			return arr[arr.length-1];
		}
        int max=findMax(arr,idx+1);
        if(max> arr[idx]){
			return max;
		}else{
			return arr[idx];
		}			
	}


}