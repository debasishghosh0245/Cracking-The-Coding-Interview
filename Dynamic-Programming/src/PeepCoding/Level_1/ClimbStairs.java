import java.util.*;
public class ClimbStairs {

	public static void main(String[] args){
		int n=3;
		System.out.println(getStairPathsSol(n));
	}

	public static List<String> getStairPaths(int n) {
		List<String> result=new ArrayList<>();
		helper(n,"",result);
		return result;
    }
	
	public static void helper(int n,String path,List<String> result) {
		if(n<=0) {
			if(n==0){
				result.add(path);
			}
			return;
		}
		helper(n-1,path+""+1,result);
		helper(n-2,path+""+2,result);
		helper(n-3,path+""+3,result);
	}
	
	public static List<String> getStairPathsSol(int n) {
		if(n==0){
			List<String> list=new ArrayList<>();
			list.add("");
			return list;
		}
		else if(n<0){
			return new ArrayList<>();
		}
		List<String> res1=getStairPaths(n-1);
		List<String> res2=getStairPaths(n-2);
		List<String> res3=getStairPaths(n-3);
		List<String> finallist=new ArrayList<>();
		for(String path: res1){
			finallist.add(path+"1");
		}
		for(String path: res2){
			finallist.add(path+"2");
		}
		for(String path: res3){
			finallist.add(path+"3");
		}
		return finallist;
    }

}