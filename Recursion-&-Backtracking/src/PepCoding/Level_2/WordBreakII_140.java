import java.util.*;
public class WordBreakII_140 {
	
	public static void main(String[] args){
		
		HashSet<String> set=new HashSet<>();
		String str="pineapplepenapple";
		set.add("apple");
		set.add("pen");
		set.add("applepen");
		set.add("pine");
		set.add("pineapple"); 
		
		List<List<String>> result=new ArrayList<>();
		wordBreak(str,new ArrayList<String>(),set,result);
		/* List<String> ret = new ArrayList<String>();
        for (List<String> words : result) {
            StringBuffer sentence = new StringBuffer();
            for (String word : words) {
                sentence.append(word);
                sentence.append(" ");
            }
            ret.add(sentence.toString().strip());
        } */
		System.out.println(result);
	}
	
	public static List<List<String>> wordBreak(String str,List<String> ansofar,
		HashSet<String> set,List<List<String>> result){
		if(str.length()==0){
			result.add(new ArrayList<String>(ansofar));
			return result;
		}
		for(int i=1;i<=str.length();i++){
			String prefix=str.substring(0,i);
			String postfix=str.substring(i,str.length()); 
			if(set.contains(prefix)){
				ansofar.add(prefix);
				wordBreak(postfix,ansofar,set,result);
				ansofar.remove(ansofar.size()-1);
			}
		}
		return result;
	}

}