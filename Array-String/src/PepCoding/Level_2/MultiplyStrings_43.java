import java.util.*;
public class MultiplyStrings_43{

    public static void main(String[] args){
        String num1="123";
        String num2="456";
        System.out.println(multiply(num1,num2));
    }

    public static String multiply(String str1,String str2){
        int j=str2.length()-1;
        int[] result=new int[str1.length()+str2.length()];
        int factor=0;
        while(j>=0){
            int num2=str2.charAt(j)-'0';
            int carry=0;
            int i=str1.length()-1;
            int k=(result.length-1)-factor;
            while(i>=0 || carry!=0){
                int num1=i>=0 ? str1.charAt(i)-'0':0;
                int product=num1*num2+carry+result[k];
                carry=product/10;
                result[k]=product%10;
                k--;
                i--;
            }
            factor++;
            j--;
        }
        StringBuilder sb=new StringBuilder();
        boolean leadingZero=true;
        for(int i=0;i<result.length;i++){
            if(result[i]==0 && leadingZero){
                continue;
            }else{
                sb.append(result[i]);
                leadingZero=false;
            }
        }
        return sb.toString()=="" ? "0" : sb.toString() ;
    }
}
