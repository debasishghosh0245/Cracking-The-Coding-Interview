import java.util.*;
public class Combinations_77{

    public static void main(String[] args) {
        List<List<Integer>> output=combine(4,2);
        System.out.println(output);
        //combinations(1,5,0,3,"");
    }
    
    public static List<List<Integer>> combine(int n, int k) {
       return helper(1,n,0,k,new ArrayList<Integer>(),new ArrayList<List<Integer>>());
    }
    
    public static List<List<Integer>> helper(int curr,int n, int currSel, int totalSel, 
        List<Integer> ans,List<List<Integer>> output){
        if(curr>n){
            if(currSel==totalSel) {
                output.add(new ArrayList<>(ans));
            }
            return output;
        }
        ans.add(curr);
        helper(curr+1,n,currSel+1,totalSel,ans,output);
        ans.remove(ans.size()-1);
        helper(curr+1,n,currSel,totalSel,ans,output); 
        return output;
    }
    
    public static void combinations(int cb, int tb, int ssf, int ts, String asf){
        if(cb>tb){
            if(ssf==ts) {
                 System.out.println(asf);
            }
            return;
        }
        combinations(cb+1,tb,ssf+1,ts,asf+"i");
        combinations(cb+1,tb,ssf,ts,asf+"-"); 
    }
}
