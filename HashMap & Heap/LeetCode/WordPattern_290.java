import java.util.*;
public class WordPattern{

	public static void main(String[] args){
		String pattern="abba";
		String s="dog dog dog dog";
		System.out.println(wordPattern(pattern,s));
	}
	
	public static boolean wordPattern(String pattern, String str) {
		HashMap<Character,String> pttrnStrMap=new HashMap<>();
		HashMap<String,Boolean> isUsed=new HashMap<>();
		String[] strArr=str.split(" ");
		if(strArr.length!=pattern.length()) return false;
		for(int i=0;i<pattern.length();i++){
			char ch=pattern.charAt(i);
			String st=strArr[i];
			if(pttrnStrMap.containsKey(ch)){
				if(!pttrnStrMap.get(ch).equals(st)) return false;
			}else{
				System.out.println("Used > "+isUsed);
				if(isUsed.containsKey(st)){
					return false;
				} 
				else{
					pttrnStrMap.put(ch,st);
					isUsed.put(st,true);
				}
			}
		}
		return true;
	}

}