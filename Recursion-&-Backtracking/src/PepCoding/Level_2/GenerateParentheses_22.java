import java.util.*;
public class GenerateParentheses_22 {
	
	public static void main(String[] args){
		int n=3;
		char[] boxes=new char[2*n];
		List<String> result=new ArrayList<>();
		//generateParentheses(boxes,0,result);
		generateValidParenthes(0,0,n,new StringBuilder(),result);
		System.out.println(result);
	}
	
	public static void generateParentheses(char[] current,int idx,
		List<String> result){
		if(idx >= current.length){
			if(valid(current)){
				result.add(new String(current));
			}			
			return;
		}
		current[idx]='(';
		generateParentheses(current,idx+1,result);
		current[idx]=')';
		generateParentheses(current,idx+1,result);
	}
	
	public static boolean valid(char[] current) {
        int balance = 0;
        for (char c: current) {
            if (c == '(') balance++;
            else balance--;
            if (balance < 0) return false;
        }
        return (balance == 0);
    }

	//Time Complexity : O(n) Exponential 
	//Space Compleity : O(n) 
	public static List<String> generateValidParenthes(int open,int close,
		int n,StringBuilder curr,List<String> result){
		if(open==n && close==n){
			result.add(new String(curr));
			return result;
		}
		if(open < n){
			curr.append("(");
			generateValidParenthes(open+1,close,n,curr,result);
			curr.deleteCharAt(curr.length()-1);
		}
		//if numbers of open is less then number of close then
		//no need call recursion for this invalid case
		// () < ) ==going to be invalid 
		if(close < open && close <n){
			curr.append(")");
			generateValidParenthes(open,close+1,n,curr,result);
			curr.deleteCharAt(curr.length()-1);
		}
		return result;
	}
}



