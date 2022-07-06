public class AnyBaseAddition {

	public static void main(String[] args){
		/* int b=8;
		int n1=236;
		int n2=754; */
		int b=2;
		/* int n1=1;
		int n2=11; */
		int n1=1110110101;
		int n2=1110111011;
		getSum(b,n1,n2);
	}
	
	public static int getSum(int base, int num1, int num2){
		int i=0;
		int result=0;
		int carry=0;
		int power=1;
		while(num1>0 || num2>0 || carry>0){
			int digit1=num1%10;
			int digit2=num2%10;
			int sum=digit1+digit2+carry;
			result+=power*(sum%base);
			i++;
			power=power*10;
			carry=sum/base;	
			num1=num1/10;
			num2=num2/10;
		}
		System.out.println(result);
		return result;
	}

}