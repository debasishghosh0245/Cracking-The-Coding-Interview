import java.util.*;
public class UniquePaths_62{

    public static void main(String[] args) {
		 //System.out.println(getUniquePaths(0,0,2-1,3-1).size());
		// System.out.println(getUniquePaths(0,0,12-1,23-1).size());
		 System.out.println(getUniquePathsOptimized(0,0,12-1,23-1,"",new ArrayList<String>()));
	}
	
	// Recursion 1 
	public static List<String> getUniquePaths(int sr, int sc, int dr, int dc) {
        if(sr==dr && sc==dc) {
			List<String> al=new ArrayList<String>();
			al.add("");
			return al;
		}
		List<String> recursionResultH=null;
		List<String> recursionResultV=null;
		if(sr<dr) {
			recursionResultH=getUniquePaths(sr+1,sc,dr,dc);
		}
		
		if(sc<dc) {
			recursionResultV=getUniquePaths(sr,sc+1,dr,dc);
		}
		
		List<String> output=new ArrayList<String>();
		if(recursionResultH!=null){
			for(String strH:recursionResultH) {
				output.add("h"+strH);
			}
		}
		if(recursionResultV!=null) {
			for(String strV:recursionResultV) {
				output.add("v"+strV);
			}
		}
		return output;
    }
	
	// Recursion Optimized Still Not acceptable 
	public static List<String> getUniquePathsOptimized(int sr, int sc, int dr, int dc,String ans,ArrayList<String> output) {
        if(sr==dr && sc==dc) {
			output.add(ans);
			return output;
		}

		if(sc<dc) {
			getUniquePathsOptimized(sr,sc+1,dr,dc,ans+"H",output);
		}
		
		if(sr<dr) {
			getUniquePathsOptimized(sr+1,sc,dr,dc,ans+"V",output);
		}
		return output;
    }


}