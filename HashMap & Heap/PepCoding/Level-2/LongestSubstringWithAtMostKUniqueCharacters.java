import java.util.*;
public class LongestSubstringWithAtMostKUniqueCharacters {

	public static void main(String[] args){
		String str="aabcbcdbca";
		System.out.println("Length >> "+longesSubstringNonRepating(str,2));
	}

	public static int longesSubstringNonRepating(String str,int k){
		int length=0;
		HashMap<Character,Integer> charFreqMap=new HashMap<>();
		int i=0,j=0;
		while(true){
			boolean flag1=false;
			boolean flag2=false;
			//acuire and print
			while(i<str.length()){
				flag1=true;
				char ch=str.charAt(i++);
				charFreqMap.put(ch,charFreqMap.getOrDefault(ch,0)+1);
				if(charFreqMap.size()>k){
					break;
				}
				else{
					System.out.println("SubString Accuired >> "+str.substring(j,i));
					length+=i-j;
				}
			}
			//release
			while(j<i){
				flag2=true;
				char ch=str.charAt(j++);
				if(charFreqMap.getOrDefault(ch,0)==1){
					charFreqMap.remove(ch);
				}else{
					charFreqMap.put(ch,charFreqMap.getOrDefault(ch,0)-1);
				}
				if(charFreqMap.size()==k) {
					System.out.println("SubString Released >> "+str.substring(j,i));
					length+=i-j;
					break;
				}
			}
			if(flag1==false && flag2==false){
				break;
			}
		}
		return length;
	}
}