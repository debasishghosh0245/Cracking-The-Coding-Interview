import java.util.*;
public class SmallestSubstringOfAStringContainingAllCharactersOfAnotherString{
	
	public static void main(String[] args) {
		String str1="timetopractice";
		String str2="toc";
		System.out.println(findSmallerSubString(str1,str2));
	}
	
	public static String findSmallerSubString(String str1,String str2){
		HashMap<Character,Integer> targetMap=new HashMap<>();
		HashMap<Character,Integer> originalMap=new HashMap<>();
		int requiredCnt=str2.length();
		int currCnt=0;
		int j=0;
		int i=0;
		String result="";
		for(int c=0;c<str2.length();c++){
			char ch=str2.charAt(c);
			targetMap.put(ch,targetMap.getOrDefault(ch,0)+1);
		}
		while(true){	
			boolean flag1=false;
			boolean flag2=false;
			while(currCnt != requiredCnt && i < str1.length()){
				char ch=str1.charAt(i++);
				originalMap.put(ch,originalMap.getOrDefault(ch,0)+1);
				if(targetMap.getOrDefault(ch,0) >=
					originalMap.getOrDefault(ch,0)){
					currCnt++;
				}
				flag1=true;
			}
			while(currCnt==requiredCnt && j < i) {
				String currRes=str1.substring(j,i);
				if(result.length()==0 
					|| result.length() > currRes.length()){
					result=currRes;
				}
				char ch=str1.charAt(j++);
				if(originalMap.get(ch)==1){
					originalMap.remove(ch);
				}else{
					originalMap.put(ch,originalMap.get(ch)-1);
				}
				if(targetMap.getOrDefault(ch,0) >
					originalMap.getOrDefault(ch,0)){
					currCnt--;
				}
				flag2=true;
			}
			
			if(flag1==false && flag2==false){
				break;
			}
		}
		return result;
	}
}