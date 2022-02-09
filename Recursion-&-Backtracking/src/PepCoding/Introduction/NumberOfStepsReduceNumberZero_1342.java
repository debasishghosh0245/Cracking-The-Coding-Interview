package PepCoding.Introduction;

public class NumberOfStepsReduceNumberZero_1342{
    
	public static void main(String[] args) {
		int num=123;
		System.out.println(numberOfSteps(num,0));
	}
	
	public static int numberOfSteps(int num,int count) {
        if(num==0) return count;
		if(num%2==0) {
			num=numberOfSteps(num/2,count+1);
		}else{
			num=numberOfSteps(num-1,count+1);
		}
		return num;
    }
}