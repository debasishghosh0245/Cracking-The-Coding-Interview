import java.util.*;
public class LetterCombinationsOfPhoneNumber17 {
	 
	  public static String[] keys={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
	 
	  public static void main(String[] args){
		 String digits = "";
		 List<String> output=null;
		 if(digits.equals("")){
			 System.out.println(new ArrayList<>());
		 }else{
			 output=letterCombinationsHelper("");
			 System.out.println(output);
		 }
		 
	  }
	 
      public static List<String> letterCombinationsHelper(String digits) {
         if(digits.length()==0){
			List<String> list=Arrays.asList("");
			return list; 
	     }
		 char ch=digits.charAt(0);
		 String ros=digits.substring(1);
		 List<String> rresult=letterCombinationsHelper(ros);
		 List<String> result=new ArrayList<String>();
		 for(String strItr: rresult) {
	           String str=keys[ch-'0'];
			   for(int i=0;i<str.length();i++) {
				   char ch2=str.charAt(i);
				   result.add(ch2+strItr);
			   }
		 }
         return result;
     }
}

