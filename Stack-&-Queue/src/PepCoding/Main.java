import java.util.Arrays;

public class Main {

  public static void main(String[] args) throws Exception {
     int[] arr1=new int[5];
	 int[] arr2=new int[10];
	 
	 arr2[0]=0;
	 arr2[1]=1;
	 arr2[2]=2;
	 arr2[3]=3;
	 arr2[4]=4;
     
	 //Java is Copy By Reference 
	 arr1=arr2;
	 
	 System.out.println(Arrays.toString(arr1));
	 
	 
  }
  
  
  
  }
