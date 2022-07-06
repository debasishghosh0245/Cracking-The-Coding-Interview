public class RotateANumber{

    public static void main(String[] args){
		 int n = 12340056;
         int k = 3;
		 rotate(n,k);
	}
	
	public static void rotate(int number, int k) {
		while(number!=0) {
			System.out.println(number%10);
			number=number/10;
		}
	}
}
