import java.util.*;
public class WordBreak_139{

	public static void main(String[] args){
		HashSet<String> set=new HashSet<>();
		String str="catsandog";
		set.add("cat");
		set.add("cats");
		set.add("and");
		set.add("sand");
		set.add("dog"); 
		/* String str="applepenapple";
		set.add("apple");
		set.add("pen"); */
		Boolean[] memo=new Boolean[str.length()+1];
		System.out.println(wordBreakMemo(str,set,memo,0));
	}
	
	//Time Complexity  :
	//Space Complexity :
	public static boolean wordBreak(String str,HashSet<String> set){
		if(str.length()==0){
			return true;
		} 
		for(int i=1;i<=str.length();i++){
			String left=str.substring(0,i);
			String right=str.substring(i,str.length()); 
			if(set.contains(left)&& wordBreak(right,set)){
				return true;
			}
		}
		return false;
	}
	
	//Time Complexity :
	//Space Complecity:
	public static boolean wordBreakMemo(String str,HashSet<String> set,Boolean[] memo,int start){
		if(str.length()==0){
			return true;
		} 
		if(memo[start]!=null) return memo[start];
		for(int i=start+1;i<=str.length();i++){
			String left=str.substring(0,i);
			String right=str.substring(i,str.length()); 
			if(set.contains(left) && wordBreakMemo(right,set,memo,start)){
				memo[i]=true;
				return true;
			}
			memo[i]=false;
		}
		return false;
	}
}