public class DecimalToAnyBase{

	public static void main(String[] args){
		System.out.println(getValueInBase(57,8));
	}

	public static int getValueInBase(int num,int base){
		int temp=num;
		int result=0;
		int i=0;
		while(temp>0){
			int rem=temp%base;
			result+=Math.pow(10,i)*rem;
			temp=temp/base;
			i++;
		}
		return result;
	}

}