public class IsAPowerOfTwo{
	
	public static void main(String[] args){
		//1024
		//32
		System.out.println("Is Power Of Two >> "+isPowerOfTwoIII(20));
	}

	//Approache 1
	public static boolean isPowerOfTwo(int num){
		if(num<1) return false;
		int temp=num;
		while(temp==0){
			temp=temp/2;
		}
		return temp==1;
	}
	
	//Approache 2
	// 2^x=n ==2Logx=Logn==2
	public static boolean isPowerOfTwoII(int num){
		return Math.log10(num)/Math.log10(2)%1==0;
	}
	
	//apprache 3
	//O(N)
	public static boolean isPowerOfTwoIII(int num){
		return num>0 && (num & (num-1))==0;
	}
}