import java.util.*;
public class ValidAnagram242{
	
	public static void main(String args[]){
		String str1="pepcoding";
		String str2="codingpep";
		System.out.println(isAnamgram(str1,str2));
	}
	
	public static boolean isAnamgram(String str1,String str2){
		if(str1.length()!=str2.length()) return false;
		HashMap<Character,Integer> charFrqMap=new HashMap<>();
		for(int i=0;i<str1.length();i++){
			char ch=str1.charAt(i);
			charFrqMap.put(ch,charFrqMap.getOrDefault(ch,0)+1);
		}
		for(int i=0;i<str2.length();i++){
			char ch=str2.charAt(i);
			if(charFrqMap.getOrDefault(ch,0)==1){
				charFrqMap.remove(ch);
			}
			else{
				charFrqMap.put(ch,charFrqMap.getOrDefault(ch,0)-1);
			}
			
		}
		return charFrqMap.size()==0;
	}
}