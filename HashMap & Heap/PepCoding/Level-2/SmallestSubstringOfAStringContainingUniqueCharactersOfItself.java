import java.util.*;
public class SmallestSubstringOfAStringContainingUniqueCharactersOfItself{

	public static void main(String[] args){
		String str="aabcbcdbca";
		findSmallerSubString(str);
	}
	
	public static void findSmallerSubString(String str) {
		int i=0,j=0;
		String result="";
		HashSet<Character> unique=new HashSet<>();
		for(char ch: str.toCharArray()){
			unique.add(ch);
		}
		System.out.println("Unique Character >> "+unique.toString());
		//acuire //
		HashMap<Character,Integer> map=new HashMap<>();
		while(true){
			boolean flag1=false;
			boolean flag2=false;
			while(i<str.length() && map.size()!=unique.size()){
				char ch=str.charAt(i++);
				map.put(ch,map.getOrDefault(ch,0)+1);
				flag1=true;
			}
			System.out.println(map.toString());
			//print and release  
			while(j<i && map.size()==unique.size()){
				String currRes=str.substring(j,i);
				if(result.length()==0 || currRes.length() < result.length()){
					result=currRes;
					System.out.println("Result >> "+result);
				}
				char ch=str.charAt(j);
				if(map.get(ch)==1){
					map.remove(ch);
				}else{
					map.put(ch,map.get(ch)-1);
				}
				j++;
				flag2=true;
			}
			if(flag1==false && flag2==false){
				break;
			}
		}
	}
}