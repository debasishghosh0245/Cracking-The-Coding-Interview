import java.util.*;
public class CountPalindromicSubsequence{

	public static void main(String[] args){
		String str="bbbab";
		/* String str="cbbd"; */
		Integer[][] memo=new Integer[str.length()][str.length()];
		System.out.println("Longest Palindromic Subsequence >> "+lps_tabbluar(str));
	}

	//Approach 3: Dynamic Programming 
	public static int lps_tabbluar(String str){
		int[][] dp=new int[str.length()][str.length()];
		for(int idx1=str.length()-1;idx1>=0;idx1--){
			for(int idx2=0;idx2<str.length();idx2++){
				if(idx1==idx2){
					dp[idx1][idx2]=1;
				}
				else if(idx1 > idx2){
					dp[idx1][idx2]=0;
				}
				else {
					int lps=0;
					if(str.charAt(idx1)==str.charAt(idx2)){
						dp[idx1][idx2]=2+dp[idx1+1][idx2-1];
					}
					else{
						dp[idx1][idx2]=Math.max(dp[idx1+1][idx2],dp[idx1][idx2-1]);
					}
				}
			}
		}
		for(int idx1=0;idx1<dp.length;idx1++){
			for(int idx2=0;idx2<dp.length;idx2++){
				System.out.print(dp[idx1][idx2]);
			}
			System.out.println();
		}
		return dp[0][dp.length-1];
	}
}