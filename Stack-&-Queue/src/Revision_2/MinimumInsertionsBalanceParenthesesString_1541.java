public class MinimumInsertionsBalanceParenthesesString_1541{
	public static void main(String[] args){
		//String str="())";
		//String str="(()))";
		String str="))())(";
		System.out.println(minInsertion(str));
		
	}

	public static int minInsertion(String str){
		int bal=0;
		int ans=0;
		int closing=0;
		for(int i=0;i<str.length();i++){
			char ch=str.charAt(i);
			if(ch=='('){
				bal++;
			}
			else if(ch==')'){
				closing++;
			}
			//if 2 closing parenthis then the string has
			// to balance
			if(closing==2){
				bal--;
				closing=0;
			}
			if(bal < 0){
				bal+=1;
				ans+=1;
			}
		}
		return ans+2*bal-closing;
	}

}