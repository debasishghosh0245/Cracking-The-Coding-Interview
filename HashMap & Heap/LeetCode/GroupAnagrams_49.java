import java.util.*;
public class GroupAnagrams_49 {

	public static void main(String[] args){
		//String[] strs ={"eat","tea","tan","ate","nat","bat"};
		//String[] strs = {"a"};
		String[] strs={"ddddddddddg","dgggggggggg"};
		System.out.println(groupAnagrams(strs));
	}
	
	public static List<List<String>> groupAnagrams(String[] strs) {
		
        HashMap<HashMap<Character,Integer>,List<String>> map=new HashMap<>();
		for(String str:strs){
			HashMap<Character,Integer> charFrqMap=charFeqMap(str);
			if(map.containsKey(charFrqMap)){
				List<String> list=map.get(charFeqMap(str));
				list.add(str);
			}else{
				List<String> list=new ArrayList<>();
				list.add(str);
				map.put(charFeqMap(str),list);
			}
		}
		List<List<String>> result=new ArrayList<>();
		for(List<String> value: map.values()){
			result.add(value);
		}
		return result;
    }
	
	public static HashMap<Character,Integer> charFeqMap(String str){
		int i=0;
		HashMap<Character,Integer> charFeqMap=new HashMap<>();
		while(i<str.length()){
			char ch=str.charAt(i++);
			charFeqMap.put(ch,charFeqMap.getOrDefault(ch,0)+1);
		}
		return charFeqMap;
	}
}