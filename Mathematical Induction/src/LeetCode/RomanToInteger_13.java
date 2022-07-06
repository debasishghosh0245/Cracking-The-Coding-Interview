import java.util.*;
public class RomanToInteger_13{
    
	public static LinkedHashMap<String,Integer> hashMap=new LinkedHashMap<>();
	
	static {
		   hashMap.put("M",1000);
		   hashMap.put("D",500);
		   hashMap.put("C",100);
		   hashMap.put("L",50);
		   hashMap.put("X",10);
		   hashMap.put("V",5);
		   hashMap.put("I",1);
	}
	
	public static void main(String[] args) {
		String str="III";
		System.out.println(romanToInteger("MCMXCIV"));
	}
	
	public static int romanToInteger(String str) {
		int result=0;
		int i=0;
		for(i=0;i<str.length();i++) {
			   String currentStr=str.substring(i,i+1);
			   int currentVal=hashMap.get(currentStr);
			   int nextVal=0;
			 if(i<str.length()-1){
			   String nextStr=str.substring(i+1,i+2);
			   nextVal=hashMap.get(nextStr);
			 }
			 if(currentVal<nextVal){
				result+=nextVal-currentVal;
				i++;
			 }
			 else{
				result+=currentVal; 
			 }
		}
		return result;
	}
}