import java.util.*;
public class LongestPalindromicSubstring{

	public static void main(String[] args){
		String str="babad";
		/* String str="cbbd"; */
		//int[][] memo=new int[str.length()][str.length()];
		System.out.println(lpss_tabbluar(str));
	}

	//Approach 1: Dynamic Programming 
	public static int lpss_tabbluar(String str){
		int maxLength=0;
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
					if(str.charAt(idx1)==str.charAt(idx2) && dp[idx1+1][idx2-1]>0){
						dp[idx1][idx2]=2+dp[idx1+1][idx2-1];
					}
					else{
						dp[idx1][idx2]=0;
					}
				}
				maxLength=Math.max(maxLength,dp[idx1][idx2]);
			}
		}
		return maxLength;
	}
}