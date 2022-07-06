public class CountPalindromicSubstrings{
	
	public static void main(String[] args){
		System.out.println("Cout palindromic Substring >>"+lpss_tabbluar("bbbab"));
	}

	public static int lpss_tabbluar(String str){
		int result=0;
		int[][] dp=new int[str.length()][str.length()];
		for(int idx1=str.length()-1;idx1>=0;idx1--){
			for(int idx2=0;idx2<str.length();idx2++){
					// Base case: Single letter substrings
					if(idx1==idx2){
						dp[idx1][idx2]=1;
					}
					//Base case : out of range
					else if(idx1 > idx2){
						dp[idx1][idx2]=0;
					}
					// Base case: double letter substrings
					else if(idx2-idx1==1 && str.charAt(idx1)==str.charAt(idx2)){
						dp[idx1][idx2]=1;
					}
					// All other cases: substrings of length 3 to n
					else if(str.charAt(idx1)==str.charAt(idx2) && dp[idx1+1][idx2-1]>0){
							dp[idx1][idx2]=2+dp[idx1+1][idx2-1];
					}
					else{
						dp[idx1][idx2]=0;
					}
					
					//count final result
					if(dp[idx1][idx2]>0){
						result++;
					}
				}			
			}
		return result;
	}

}