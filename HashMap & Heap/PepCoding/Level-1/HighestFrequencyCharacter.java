import java.util.*;
public class HighestFrequencyCharacter{

    public static void main(String[] args) {
        String str="zmszeqxllzvheqwrofgcuntypejcxovtaqbnqyqlmrwitc";
        getHighestFrequencyElement(str);
    }
    
    public static void getHighestFrequencyElement(String str){
        HashMap<Character,Integer> hashMap=new HashMap<Character,Integer>();
        for(char ch: str.toCharArray()){
            hashMap.put(ch,hashMap.getOrDefault(ch,0)+1);
        } 
        char hightestFreq='\0';
        int max=Integer.MIN_VALUE;
        for(Map.Entry<Character,Integer> entry : hashMap.entrySet()){
            if(entry.getValue()>max){
               max=entry.getValue();
               hightestFreq=entry.getKey();
            }
        } 
        System.out.println("Higest Frequenty Character >> "+hightestFreq);
    }
}