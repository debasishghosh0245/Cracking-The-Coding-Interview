public class MinimumNumberSwapsMakeStringBalanced_1963{

	public static void main(String[] args){
		/* String str="][]["; */
		//String str="]]][[[";
		String str="[]";
		System.out.println(minSwap(str));
	}
	
	public static int minSwap(String str){
		int bal=0;int ans=0;
		for(int i=0;i<str.length();i++){
			char ch=str.charAt(i);
			if(ch=='['){
				bal++;
			}
			else if(ch==']'){
				bal--;
			}
			if(bal < 0){
				bal++;
				ans++;
			}
		}
		int unbalancedPair=(ans+bal)/2;
		return (unbalancedPair+1)/2;
	}

}