import java.util.*;
public class LongestSubstringWithExactlyKUniqueCharacters {

	public static void main(String[] args){
		String str="aabcbcdbca";
		System.out.println("Length >> "+findLongestSubstringNonRepating(str,2));
	}

	public static int findLongestSubstringNonRepating(String str,int k){
		int length=0;
		String result="";
		HashMap<Character,Integer> charFreqMap=new HashMap<>();
		int i=0;
		int j=0;
		while(true){
			boolean flag1=false;
			boolean flag2=false;
			//acuire and print
			while(i<str.length()) {
				flag1=true;
				char ch=str.charAt(i++);
				charFreqMap.put(ch,charFreqMap.getOrDefault(ch,0)+1);
				if(charFreqMap.size()>k){
					break;
				}
				if(charFreqMap.size()==k){
					//result
					if(result.length()==0 
						|| result.length() < 
							str.substring(j,i).length()){
						result=str.substring(j,i);
					}
				}
			}
			//release
			while(charFreqMap.size()!=k){
				flag2=true;
				char ch=str.charAt(j++);
				if(charFreqMap.getOrDefault(ch,0)==1){
					charFreqMap.remove(ch);
				}else{
					charFreqMap.put(ch,charFreqMap.getOrDefault(ch,0)-1);
				}
			}
			if(flag1==false && flag2==false){
				break;
			}
		}
		return result.length();
	}
}