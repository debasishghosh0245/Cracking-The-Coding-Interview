public class FirstIndex{
    public static void main(String[] args) {
		int[] arr={15,4,40,4,4,9};
		int target=4;
		System.out.println(firstIndex(arr,0,target));
	}
	
	public static int firstIndex(int[] arr, int idx, int x){
		if(idx >= arr.length-1) {
			if(x==arr[arr.length-1]) {
				return arr.length-1;
			} else{
				return -1;
			}
		}
		int sidx=firstIndex(arr,idx+1,x);
		if(arr[idx]==x){
			return idx;
		}else{
			return sidx;
		}
	}



}