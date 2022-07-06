public class LetterCasePermutation_784{
	
	public static void main(String[] args){
		//String str="a1b2";
		String str="3z4";
		permutaion(str,0,"");
	}
	
	public static void permutaion(String str,int idx,String ans){
		if(idx==str.length()){
			System.out.println(ans);
			return;
		}
		String currentStr=str.charAt(idx)+"";
		while(idx+1 < str.length() && Character.isDigit(str.charAt(idx+1))){
			currentStr+=str.charAt(idx+1)+"";
			idx++;
		}
		System.out.println(currentStr);
		permutaion(str,idx+1,ans+currentStr.toUpperCase());
		permutaion(str,idx+1,ans+currentStr.toLowerCase());
	}
}