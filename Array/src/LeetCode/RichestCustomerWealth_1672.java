package LeetCode;

public class RichestCustomerWealth_1672{

   public static void main(String[] args) {
	   int[][] accounts = {{1,2,3},{3,2,1}};
	   int max=maximumWealth(accounts);
	   System.out.println("Maximum Target "+max);
	   
   }
   public static int maximumWealth(int[][] accounts) {
        int max=0;
        for(int row=0;row<accounts.length;row++){
			int sum=0;
            for(int col=0;col<accounts[row].length;col++) {
                int element=accounts[row][col];
				sum+=element;
                max=Math.max(max,sum);
            }
        }
        return max;
  }
}
 
 
