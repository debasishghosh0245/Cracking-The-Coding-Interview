import java.util.*;
public class getKPC {

    static String[] keys = {".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"};
	
	public static void main(String[] args) {
	    List<String> words=getKPC("23");
        System.out.println(words);
	}
    
	public static List<String> getKPC(String digits) {
		if (digits.length() == 0) {
		  List<String> list=Arrays.asList("");
		  return list;
		}
		char ch = digits.charAt(0);
		String ros = digits.substring(1);
		List<String> rresult = getKPC(ros);
		List<String> mresult = new ArrayList<String>();
		for (String strItr : rresult) {
			 String chcode = keys[ch - '0'];
			 for (int i = 0; i < chcode.length(); i++) {
				mresult.add(chcode.charAt(i)+strItr);
			 }
		}
		return mresult;
    }
}


