public class AddStrings_415{

    public static void main(String[] args){
        //String num1="1234";
        //String num2="798";
        //String num1 = "9999";
        //String num2 = "111123";
        String num1="12416496194691284988142198924690621404721421441124124159807070147907920947";
        String num2="1274912469491698641247914789182479792740";
        System.out.println(addString(num1,num2));
    }
    //Time Complexity:O(n)
    //Space Complexity:O(1)
    public static String addString(String str1,String str2){
        int carry=0;
        StringBuilder result=new StringBuilder();
        int i=str1.length()-1;
        int j=str2.length()-1;
        while(i>=0 || j>=0 || carry!=0){
            int num1=i>=0 ? str1.charAt(i)-'0' : 0;
            int num2=j>=0 ? str2.charAt(j)-'0' : 0;
            int sum=num1+num2+carry;
            carry=sum/10;
            result.append(sum%10);
            i--;
            j--;
        }
        return result.toString();
    }
}
