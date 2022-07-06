public class FindSmallestDivisorGivenThreshold_1283 {

	public static void main(String[] args){
		/* int[] nums={1,2,5,9}; 
		int threshold=6; */
		int[] nums={44,22,33,11,1};
		int threshold = 5;
		System.out.println(smallestDivisor(nums,threshold));
	}
	
	public static int smallestDivisor(int[] nums, int threshold) {
		int low=1, high=(int)1e6;
		while(high>low){
			int mid=low+(high-low)/2;
			int sum=calSum(nums,mid);
			if(sum <= threshold){
				// decrease the divisor then sum will be increase
				high=mid;
			}else{
				//increase the divisor then sum will less 
				low=mid+1;
			}
		}
		return low;
    }
	
	public static int calSum(int[] nums,int divisor){
		int sum=0;
		for(int num:nums){
			sum+=(int)Math.ceil((double)num/divisor);
		}
		return sum;
	}
}