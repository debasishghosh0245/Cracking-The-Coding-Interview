public class IsAPowerOfFour{
	
	public static void main(String[] args){
		System.out.println("Is Power Of Two >> "+isPowerOfFourIII(64));
	}
	
	//approache 1
	public static boolean isPowerOfFour(int num){
		if(num<1) return false;
		int temp=num;
		while(temp%4==0){
			temp=temp/4;
		}
		return temp==1;
	}
	
	//approache 2
	// 2^x=n ==2Logx=Logn==2
	public static boolean isPowerOfFourII(int num){
		return Math.log10(num)/Math.log10(4)%1==0;
	}
	
	//apprache 3
	//Time Complexity :: O(N)
	public static boolean isPowerOfFourIII(int num){
		return (num>0) && ((num & (num-1))==0) && ((num & 0b10101010101010101010101010101010)==0);
	}
}