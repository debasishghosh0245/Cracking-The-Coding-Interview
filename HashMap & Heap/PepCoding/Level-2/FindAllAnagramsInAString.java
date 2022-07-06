import java.util.*;
public class FindAllAnagramsInAString{
	
	public static void main(String[] args){
		/* String str1="cbaebabacd";
		String str2="abc"; */
		String str1="abab";
		String str2="ab";
		findAnagrams(str1,str2);
	}
	
	public static void findAnagrams(String str1, String str2) {
		HashMap<Character, Integer> charFeqMap2 = new HashMap<>();
		HashMap<Character, Integer> charFeqMap1 = new HashMap<>();
		int j = 0, i = 0;
		int count=0;
		String ans="";
		for (int k = 0; k < str2.length(); k++) {
			char ch = str2.charAt(k);
			charFeqMap2.put(ch, charFeqMap2.getOrDefault(ch, 0) + 1);
		}
		while (i < str2.length() - 1) {
			char ch = str1.charAt(i++);
			charFeqMap1.put(ch, charFeqMap1.getOrDefault(ch, 0) + 1);
		}

		while (i < str1.length()) {
			char ch = str1.charAt(i++);
			charFeqMap1.put(ch, charFeqMap1.getOrDefault(ch, 0) + 1);
			if (compare(charFeqMap1, charFeqMap2) == true) {
				ans+=(i - charFeqMap1.size());
				count++;
			}
			char ch2 = str1.charAt(j++);
			if (charFeqMap1.getOrDefault(ch2, 0) == 1) {
				charFeqMap1.remove(ch2);
			} else {
				charFeqMap1.put(ch2, charFeqMap1.getOrDefault(ch2, 0) - 1);
			}
		}
		System.out.println(count);
		System.out.println(ans);
    }
	
	
	public static boolean compare(HashMap<Character,Integer> hashMap1,
		HashMap<Character,Integer> hashMap2){
		int values=0;
		if(hashMap1.size()!=hashMap2.size()) return false;
		for(Map.Entry<Character,Integer> entry:hashMap1.entrySet()){
			int value=entry.getValue();
		    Character key=entry.getKey();
			if(hashMap2.getOrDefault(key,0)!=value) return false;
		}
		return true;
	}
}