import java.util.*;
public class FractionToRecurringDecimal_166 {
	
	public static void main(String[] args){
		int numerator=4;
		int denominator=333;
		System.out.println(fractionToDecimal(numerator,denominator));
	}
	
	public static String fractionToDecimal(int numerator, int denominator) {
         if (numerator == 0) {
            return "0";
        }
        StringBuilder fraction=new StringBuilder();
         // If either one is negative (not both)
        if (numerator < 0 ^ denominator < 0) {
            fraction.append("-");
        }
        // Convert to Long or else abs(-2147483648) overflows
        long dividend = Math.abs(Long.valueOf(numerator));
        long divisor = Math.abs(Long.valueOf(denominator));
		long quotient=dividend/divisor;
		long remainder=dividend%divisor;
        fraction.append(quotient);
		if(remainder==0){
			return fraction.toString();
		}else{
			HashMap<Long,Integer> remainderMap=new HashMap<>();
			fraction.append(".");
            
			while(remainder!=0){
				if(remainderMap.containsKey(remainder)){
					int len=remainderMap.get(remainder);
					fraction.insert(len,"(");
					fraction.append(")");
					break;
				}
				else {
					remainderMap.put(remainder,fraction.length());
                    remainder=10*remainder;
					quotient=remainder/divisor;
					remainder=remainder%divisor;
                    fraction.append(quotient);
				}
			}
	    }
      return fraction.toString(); 
    }
	
}