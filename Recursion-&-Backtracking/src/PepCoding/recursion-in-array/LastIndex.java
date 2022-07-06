public class LastIndex {
      public static void main(String[] args) {
		int[] arr={4,100,40,4,4,4};
		int target=4;
		System.out.println(lastIndex(arr,0,target));
	}
	
	public static int lastIndex(int[] arr, int idx, int x){
		if(idx >= arr.length-1) {
			if(x==arr[arr.length-1]) {
				return arr.length-1;
			} else{
				return -1;
			}
		}
		int last=lastIndex(arr,idx+1,x);
		if(last==-1 && arr[idx]==x){
			return idx;	
		}
		else if(arr[idx]==x &&  last!=-1){
			return last;
		}
		else if(arr[idx]!=x && last!=-1) {
			return last;
		}
		else {
			return -1;
		}
	}
}