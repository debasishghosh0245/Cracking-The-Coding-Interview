import java.util.*;
public class LetterCombinationsPhoneNumber{
	
	public static String[] keys={".:","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};
	private static List<String> combinations = new ArrayList<>();
	
	public static void main(String[] args){
		generateLetterCombination("12","");
		System.out.println(combinations);
	}
	//Approach 1:
	//Time Complexity: 
	//Space Complexity:
	public static ArrayList<String> letterCombinations(String digits) {
		ArrayList<String> allLetterCombination;
        if(digits.length()==0){
			allLetterCombination=new ArrayList<>();
			allLetterCombination.add("");
			return allLetterCombination;
		}
		char ch=digits.charAt(0);
		String remaningStr=digits.substring(12,digits.length());
		allLetterCombination=letterCombinations(remaningStr);
		ArrayList<String> newLettrCombination=new ArrayList<>();
		String characters=keys[ch-'0'];
		for(char ch1 : characters.toCharArray()){
			for(String str: allLetterCombination){
				newLettrCombination.add(ch1+str);
			}
		}
		return newLettrCombination;
    }
	
	//Approach 2 :
	//Time Complexcity : O(n) 
	//Space Complexicty: O(1)
	public static void generateLetterCombination(String digits,String str) {
        if(digits.length()==0){
			combinations.add(str);
			return;
		}
		String currentStr=digits.substring(0,1);
		String restOfStr=digits.substring(1,digits.length());
		String characters=keys[Integer.parseInt(currentStr)];
		for(int i=0;i<characters.length();i++) {
			generateLetterCombination(restOfStr,str+characters.charAt(i));
		}
    }
}