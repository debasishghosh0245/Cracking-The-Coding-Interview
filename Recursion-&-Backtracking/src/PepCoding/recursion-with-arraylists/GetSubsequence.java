import java.util.*;
class GetSubsequence1 {
    
    public static void main(String[] args) {
        String str="abc";
        ArrayList<String> output=getSubsequence(str);
        System.out.println(output);
    }
    
    public static ArrayList<String> getSubsequence(String str) {
        if(str.length()==0){
           ArrayList newList=new ArrayList<>();
           newList.add(" ");           
           return newList;
        }
        char ch=str.charAt(0);
        String newStr=str.substring(1);
        ArrayList<String> returnedStr=getSubsequence(newStr);
        ArrayList<String> list=new ArrayList<>();
        for(String rstr :returnedStr ) {
            list.add(rstr);
        }
        for(String rstr :returnedStr) {
            list.add(ch+rstr);
        }
        return list; 
    }
}