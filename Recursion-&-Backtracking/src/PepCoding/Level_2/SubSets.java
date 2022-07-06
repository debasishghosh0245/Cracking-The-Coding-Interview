import java.util.*;
public class SubSets{

	public static void main(String[] args){
		String str="abc";
		int idx=0;
		List<List<String>> ans=generateSubset(str);
		System.out.println(ans);
	}
	
	public static List<List<String>> generateSubset(String str){
		List<List<String>> subsets;
		if(str.length()==0){
			subsets=new ArrayList<List<String>>();
			List<String> list=new ArrayList<String>();
			subsets.add(list);
			return subsets;
		}
		char ch=str.charAt(0);
		System.out.println("Character >> "+ch);
		String remaining=str.substring(1,str.length());
		System.out.println("Remaining >> "+remaining);
		subsets=generateSubset(remaining);
		List<List<String>> result=new ArrayList<List<String>>();
		for(List<String> list: subsets){
			result.add(new ArrayList<>(list));
		} 
		for(List<String> list: subsets){
			list.add(ch+"");
			result.add(list);
		} 
		return result;
	}
}