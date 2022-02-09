package PepCoding.Introduction;

public class PowerLinear {
	
	public static void main(String[] args) {
		 int x=2;
		 int n=4;
		 System.out.println(powLog(x,n));
	}
	
	public static int powLinear(int x,int n) {
		if(n<=0) return 1;
		int xpnb2=powLinear(x,n-1);
		return x*xpnb2;
	}
	
	public static int powLog(int x,int n) {
		if(n==0) return 1;
		int recursionResult=powLog(x,n/2);
		int output=recursionResult*recursionResult;
		if(n%2==1) {
			output=output*x;
		}
	   return output;
	}

}