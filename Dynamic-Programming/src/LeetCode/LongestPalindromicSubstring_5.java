import java.util.*;
public class LongestPalindromicSubstring_5 { 

	public static void main(String[] args){
		//String str="babad";
		//String str="aacabdkacaa";
		//String str="cbbd";
		System.out.println("Longest Palidromic SubString >> "+lpss_tabbluar(str));
	}
	
	public static String lpss_tabbluar(String str){
		int maxLength=0;
		String largestStr="";
		int[][] dp=new int[str.length()][str.length()];
		for(int idx1=str.length()-1;idx1>=0;idx1--){
			for(int idx2=0;idx2<str.length();idx2++){
				if(idx1==idx2){
					dp[idx1][idx2]=1;
				}
				else if(idx1 > idx2){
					dp[idx1][idx2]=0;
				}
				else if(idx2-idx1==1 && str.charAt(idx1)==str.charAt(idx2)){
					dp[idx1][idx2]=2;
				}
				else if(str.charAt(idx1)==str.charAt(idx2) 
					&& dp[idx1+1][idx2-1]>0){
					dp[idx1][idx2]=2+dp[idx1+1][idx2-1];
				}
				else{
					dp[idx1][idx2]=0;
				} 
				if(dp[idx1][idx2] > maxLength){
					maxLength=dp[idx1][idx2];
					System.out.println("Index >. "+idx1+" "+idx2);
					largestStr=str.substring(idx1,idx2+1);
				}
			}
		}
		
		for(int row=0;row<dp.length;row++){
			for(int col=0;col<dp[0].length;col++){
				System.out.print(dp[row][col]+" ");
			}
			System.out.println("");
		}
		
		return largestStr;
	}
}