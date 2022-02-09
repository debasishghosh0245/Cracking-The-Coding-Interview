import java.util.*;
public class GetKeypadcombination {
    
    public static String[] key={".;","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};

    public static void main(String[] argd) {
        System.out.println(getKayPadCombination("78"));
    }
                              
    public static ArrayList<String> getKayPadCombination(String str) {
        if(str.length()==0) {
            ArrayList<String> newlist=new ArrayList<>();
            newlist.add("");
            return newlist;          
        }
        char ch=str.charAt(0); 
        String restOfStr=str.substring(1); 
        ArrayList<String> recrssnrslt=getKayPadCombination(restOfStr);
        ArrayList<String> output=new ArrayList<String>();
            for(char crrChar:key[ch-'0'].toCharArray()) {
                 for(String reStr: recrssnrslt ) {  
                 output.add(crrChar+reStr);
            }
        }
        return output;
   } 

}