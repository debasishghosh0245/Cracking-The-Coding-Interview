import java.util.*;
public class LongestSubstringWithAtMostTwoDistinctCharacters_159{
	
	
	public static void main(String[] args){
		String str="eceba";
		System.out.println("Length >> "+lengthOfLongestSubstringTwoDistinct(str));
	}

	public static int lengthOfLongestSubstringTwoDistinct(String str) {
        int length=0,result=0;
		HashMap<Character,Integer> charFreqMap=new HashMap<>();
		int i=0,j=0;
		while(true){
			boolean flag1=false;
			boolean flag2=false;
			//acuire and print
			while(i<str.length()) {
				flag1=true;
				char ch=str.charAt(i++);
				charFreqMap.put(ch,charFreqMap.getOrDefault(ch,0)+1);
				if(charFreqMap.size()>2){
					break;
				}
				else {
					int currSubStrLngth=str.substring(j,i).length();
					if(result==0 
						|| result< 
							currSubStrLngth){
						result=currSubStrLngth;
					}
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
				if(charFreqMap.size()<=2){
					break;
				}
			}
			if(flag1==false && flag2==false){
				break;
			}
		}
		return result;
    }

}