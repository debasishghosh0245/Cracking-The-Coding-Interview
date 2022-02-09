import java.util.*;
public class ClimbingStairs_70 {
    
	public static void main(String[] args) {
	   System.out.println(climbStairs(45,"",new ArrayList<String>()).size());
	}
	
	public static List<String> climbStairs(int n) {
		if(n==0) {
			ArrayList<String> newlist=new ArrayList<String>();
			newlist.add("");
			return newlist;
		}
		List<String> rmPath1=null;
		List<String> rmPath2=null;
		if(n-1>=0){
			 rmPath1=climbStairs(n-1);
		}
		if(n-2>=0) {
			 rmPath2=climbStairs(n-2);
		}
		List<String> myResult=new ArrayList<String>();
		if(rmPath1!=null) {
			for(String rmStr1:rmPath1) {
				myResult.add("1"+rmStr1);
			}
		}
		if(rmPath2!=null) {
		    for(String rmStr2:rmPath2) {
				myResult.add("2"+rmStr2);
			}	
		}
		return myResult;
    }
	
	
	public static List<String> climbStairs(int n,String ans,List<String> output) {
        HashMap<Integer,List<String>> cache=new HashMap<Integer,List<String>>();
        List<String> result=null;
        if(cache.containsKey(n)) {
          return cache.get(n);  
        }
		if(n==0) {
			output.add(ans);
			return output;
		}
		if(n-1>=0){
			result=climbStairs(n-1,ans+"1",output);
		}
		if(n-2>=0) {
			result=climbStairs(n-2,ans+"2",output);
		}
        cache.put(n,result);
		return output;
    }
}