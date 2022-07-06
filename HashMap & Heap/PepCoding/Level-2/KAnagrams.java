import java.util.*;
public class KAnagrams{
	
	public static void main(String args[]){
		String str1="fodr";
		String str2="gork";
		int k=2;
		System.out.println(areKAnagrams(str1,str2,k));
	}
	
	public static boolean areKAnagrams(String str1,String str2,int k){
		int feq=0;
		HashMap<Character,Integer> charFrqMap=new HashMap<>();
		for(int i=0;i<str1.length();i++){
			char ch=str1.charAt(i);
			charFrqMap.put(ch,charFrqMap.getOrDefault(ch,0)+1);
		}
		for(int i=0;i<str2.length();i++){
			char ch=str2.charAt(i);
			if(charFrqMap.getOrDefault(ch,0)>1){
				charFrqMap.put(ch,charFrqMap.get(ch,0)-1);
			}
		}
		for(int val:charFrqMap.values()){
			feq+=val;
		}
		return feq<k;
	}
}