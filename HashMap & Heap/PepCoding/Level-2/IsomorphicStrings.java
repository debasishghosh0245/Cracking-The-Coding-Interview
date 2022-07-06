import java.util.*;
public class IsomorphicStrings {
	
	public static void main(String[] args){
		/* String  s = "badc";
		String	t = "baba";  */
		String  s = "paper";
		String	t = "title"; 
		/* String s="pepcoding";
		String t="sosherlok"; */

		System.out.println(isIsomorphic(s,t));
	}
	
	public static boolean isIsomorphic(String s, String t) {
		if(s.length()!=t.length()) return false;
        HashMap<Character,Character> isomorphoicMap=new HashMap<>();
		HashMap<Character,Boolean> isUsed=new HashMap<>();
		int i=0;
		while(i<s.length()){
			char chfroms=s.charAt(i);
			char chfromt=t.charAt(i++);
			if(isomorphoicMap.containsKey(chfroms)){
				if(chfromt!=isomorphoicMap.get(chfroms)) return false;
			}else{
				if(isUsed.containsKey(chfromt)) return false;
				isomorphoicMap.put(chfroms,chfromt);
				isUsed.put(chfromt,true);
			}
		}
		return true;
    }
}