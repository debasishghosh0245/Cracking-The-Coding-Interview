import java.util.*;
public class LongestPalindromicSubsequence_516{

	public static void main(String[] args){
		String str="bbbab";
		/* String str="cbbd"; */
		Integer[][] memo=new Integer[str.length()][str.length()];
		System.out.println("Longest Palindromic Subsequence >> "+lps_tabbluar(str));
	}
	
	//Approach1: Recursive 
	public static int lps_recursive(String str,int idx1,int idx2){
		if(idx1==idx2) return 1;
		if(idx1 > idx2) return 0;
		int lps=0;
		if(str.charAt(idx1)==str.charAt(idx2)){
			lps=2+lps_recursive(str,idx1+1,idx2-1);
		}
		else{
			lps=Math.max(lps_recursive(str,idx1+1,idx2),lps_recursive(str,idx1,idx2-1));
		}
		return lps;
	}
	
	//Appraoch2: Memoization
	public static int lps_memo(String str,int idx1,int idx2,Integer[][] memo){
		if(idx1==idx2) return 1;
		if(idx1 > idx2) return 0;
		if(memo[idx1][idx2]!=null){
			return memo[idx1][idx2];
		}
		int lps=0;
		if(str.charAt(idx1)==str.charAt(idx2)){
			lps=2+lps_memo(str,idx1+1,idx2-1,memo);
		}
		else{
			lps=Math.max(lps_memo(str,idx1+1,idx2,memo),lps_memo(str,idx1,idx2-1,memo));
		}
		memo[idx1][idx2]=lps;
		return lps;
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