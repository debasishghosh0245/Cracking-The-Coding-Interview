import java.util.*;
public class CountOfSubstringsHavingAtMostKUniqueCharacters {

	public static void main(String[] args){
		String str="aabcbcdbca";
		System.out.println("Length "+findLongestSubstringNonRepating(str));
	}

	public static int countSubStringHavingAtMostKUniqueCharacter(String str){
		int length=0;
		HashMap<Character,Integer> charFreqMap=new HashMap<>();
		int i=0;
		int j=0;
		while(true){
			boolean flag1=false;
			boolean flag2=false;
			//acuire and print
			while(i<str.length()){
				flag1=true;
				char ch=str.charAt(i++);
				charFreqMap.put(ch,charFreqMap.getOrDefault(ch,0)+1);
				if(charFreqMap.getOrDefault(ch,0)>1){
					break;
				}
				else{
					String currentStr=str.substring(j,i);
					length+=i-j;
				}
			}
			//release
			while(j<i){
				flag2=true;
				char ch=str.charAt(j++);
				charFreqMap.put(ch,charFreqMap.getOrDefault(ch,0)-1);
				if(charFreqMap.getOrDefault(ch,0)==1) {
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