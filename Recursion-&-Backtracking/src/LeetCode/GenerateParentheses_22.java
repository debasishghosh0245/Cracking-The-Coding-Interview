import java.util.*;
public class GenerateParentheses_22{

    public static void main(String[] args) {
		
		List<String> output=generateParenthesis(2);
		System.out.println(output);
		
	} 

	//["(())","()()"] >> [()()() ((())) (()()) (())(),()(())],
	public static List<String> generateParenthesis(int n) {
		if(n==1){
			List<String> newList=new ArrayList<>();
			newList.add("");
			return newList;
		}
        List<String> rresult=generateParenthesis(n-1);
		List<String> myresult=new ArrayList<>();
		
		for(String str: rresult) {
			myresult.add("("+str+")");
		}
		
		return myresult;
	
	}



}
	
	
	