package PepCoding.Introduction;

public class SumOfNaturalsNumbers {
     
	 public static void main(String[] args) {
		int num=5; 
        System.out.println(sumOfNaturalsNums(num));		
	 }
	 
	 public static int sumOfNaturalsNums(int num) {
		 if(num==0) return 0; 
		 return num+sumOfNaturalsNums(num-1);
	 } 
	 
	 //1+2+3+4+5
} 