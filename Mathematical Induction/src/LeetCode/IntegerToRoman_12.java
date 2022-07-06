import java.util.*;
public class IntegerToRoman_12 {
	
	public static LinkedHashMap<Integer,String> hashMap=new LinkedHashMap<>();
	
	static {
		   hashMap.put(1000,"M");
		   hashMap.put(900,"CM");
		   hashMap.put(500,"D");
		   hashMap.put(400,"CD");
		   hashMap.put(100,"C");
		   hashMap.put(90,"XC");
		   hashMap.put(50,"L");
		   hashMap.put(40,"XL");
		   hashMap.put(10,"X");
		   hashMap.put(9,"IX");
		   hashMap.put(5,"V");
		   hashMap.put(4,"IV");
		   hashMap.put(1,"I"); 
	}
	
	public static void main(String[] args){
		int num=3;
		int num2=58;
		System.out.println(intToRoman(4));
	}
	
	public static String intToRoman(int num) {
		StringBuilder stringBuilder=new StringBuilder();
		while(num>0){
            for(Map.Entry mapElement :hashMap.entrySet()) {
			   int key=(Integer)mapElement.getKey();
					  if(key<=num){
						   num=num-key;
						   stringBuilder.append(hashMap.get(key));
						   break;
			    }
			}
		}
		return stringBuilder.toString();
    }
	
}