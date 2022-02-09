package LeetCode;

class ArrangingCoins_441{
	
	public static void main(String[] args) {
		System.out.println(arrangeCoins(1804289383));
	}

	//This is Brutforce Approach
	public static int arrangeCoins(int n) {
		int left=1; int right=n;
		while(left<=right) {
			long mid=left+(right-left)/2;
			long sum=mid*(mid+1)/2;
			if(sum==n) return (int)mid;
			else if(sum>n) {
               right=(int)mid-1;
			}else{
               left=(int)mid+1;
			}
		}
		return right;
    }

	public static int calculateSum(int num) {
		int sum=num*(num+1)/2;
		return sum;
	}
}