public class LongestCommonSubstring{

	public static void main(String[] args){
		String str2="abcde";
		String str1="acd";
		System.out.println(longestCommonSubString(str1,str2));
	}
	
	public static int longestCommonSubString(String str1,String str2){
		int[][] dp=new int[str1.length()+1][str2.length()+1];
		int maxLength=0;
		for(int idx1=1;idx1<=str1.length();idx1++){
			for(int idx2=1;idx2<=str2.length();idx2++){
				if(str1.charAt(idx1-1)==str2.charAt(idx2-1)){
					dp[idx1][idx2]=1+dp[idx1-1][idx2-1];
				}else{
					dp[idx1][idx2]=0;
				}
				maxLength=Math.max(maxLength,dp[idx1][idx2]);
			}
		}
		for(int idx1=0;idx1<=str1.length();idx1++){
			for(int idx2=0;idx2<=str2.length();idx2++){
				System.out.print(dp[idx1][idx2]);
			}
			System.out.println("");
		}
		return maxLength;
	}
}