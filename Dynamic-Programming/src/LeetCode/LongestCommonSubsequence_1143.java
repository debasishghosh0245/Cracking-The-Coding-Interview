public class LongestCommonSubsequence_1143{

	public static void main(String[] args){
		/* String text1 = "abcde";
		String text2 = "ace";  */
		/* String text1 = "abc";
		String text2 = "def"; */
		/**/
		String text1="abc";
		String text2="abc";
		System.out.println(lcsTabulation(text1,text2));
		//Integer[][] memo=new Integer[text1.length()+1][text2.length()+1];
		//System.out.println(lcsMemo(text1,text2,text1.length()-1,text2.length()-1,memo));
	}
	
	//Approach 1: Recursion
	//Time Complexity  : 2^m*2^n~(Exponentials)
	//Space Complexity :Maximum lenght of m and n
	public static int lcsRec(String str1,String str2,int idx1,int idx2){
		if(idx1 < 0 || idx2 < 0){
			return 0;
		}
		int lcs=0;
		if(str1.charAt(idx1)==str2.charAt(idx2)){
			lcs=1+lcsRec(str1,str2,idx1-1,idx2-1);
		}else{
			lcs=Math.max(lcsRec(str1,str2,idx1-1,idx2),lcsRec(str1,str2,idx1,idx2-1));
		}
		return lcs;
	}
	
	//Approach 2: Memoization
	//Time Complexity: O(m*n) where m and n is length of String1 and String 2
	//Space Compleixty; O(m*n
	public static int lcsMemo(String str1,String str2,int idx1,int idx2,Integer[][] memo){
		if(idx1 < 0 || idx2 < 0){
			return 0;
		}
		if(memo[idx1][idx2]!=null) return memo[idx1][idx2];
		int lcs=0;
		if(str1.charAt(idx1)==str2.charAt(idx2)){
			lcs=1+lcsMemo(str1,str2,idx1-1,idx2-1,memo);
		}else{
			lcs=Math.max(lcsMemo(str1,str2,idx1-1,idx2,memo),
				lcsMemo(str1,str2,idx1,idx2-1,memo));
		}
		memo[idx1][idx2]=lcs;
		return lcs;
	}
	
	//Approach 3: Tabulation 
	//Time Compleixty  :
	//Space Complexity :
	public static int lcsTabulation(String str1,String str2){
		int[][] dp=new int[str1.length()+1][str2.length()+1];
		for(int idx1=1;idx1<=str1.length();idx1++){
			for(int idx2=1;idx2<=str2.length();idx2++){
				if(str1.charAt(idx1-1)==str2.charAt(idx2-1)){
					dp[idx1][idx2]=1+dp[idx1-1][idx2-1];
				}else{
					dp[idx1][idx2]=Math.max(dp[idx1-1][idx2],
					dp[idx1][idx2-1]);
				}
			}
		}
		for(int idx1=0;idx1<=str1.length();idx1++){
			for(int idx2=0;idx2<=str2.length();idx2++){
				System.out.print(dp[idx1][idx2]);
			}
			System.out.println("");
		}
		return dp[str1.length()][str2.length()];
	}
}