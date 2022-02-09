import java.util.*;
public class PermutationsWords1 {
    
    public static void main(String[] args) {
        String str="aabb";
        HashMap<Character,Integer> hashMap=new HashMap<Character,Integer>();
        for(char ch: str.toCharArray()){
            hashMap.put(ch,hashMap.getOrDefault(ch,0)+1);
        }
        generateWords(hashMap," ",0,4);
    }
    
    public static void generateWords(HashMap<Character,Integer> fmap,String asf,
        int cb,int tb) {
        if(cb==tb){
            System.out.println(asf);
            return;
        }
        for(char ch:fmap.keySet()){
            if(fmap.get(ch)>0){
                fmap.put(ch,fmap.get(ch)-1);
                generateWords(fmap,asf+ch,cb+1,tb);
                 fmap.put(ch,fmap.get(ch)+1);
            }
        }
    }
}