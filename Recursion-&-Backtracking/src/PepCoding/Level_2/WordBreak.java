import java.util.*;
public class WordBreakII_140 {
	
	public static void main(String[] args){
		HashSet<String> set=new HashSet<>();
		String str="catsanddog";
		
		set.add("cat");
		set.add("cats");
		set.add("and");
		set.add("sand");
		set.add("dog"); 
		/* String str="applepenapple";
		set.add("apple");
		set.add("pen"); */
		
		wordBreak(str,"",set);
	}
	
	public static void wordBreak(String str,String ans,HashSet<String> set){
		if(str.length()==0){
			System.out.println("Ans >> "+ans);
			return;
		} 
		for(int i=1;i<=str.length();i++){
			String left=str.substring(0,i);
			String right=str.substring(i,str.length()); 
			if(set.contains(left)){
				wordBreak(right,ans+" "+left,set);
			}
		}	
	}

}