import java.util.*;
public class GetMazePaths {
   
    public static void main(String[] args) {
		getMazePathsSol2(1,1,3,3,"");
	   //System.out.println(getMazePathsSol2(1,1,3,3,""));
	}
	
	public static List<String> getMazePaths(int sr, int sc, int dr, int dc) {
        if(sr==dr && sc==dc) {
			List<String> al=new ArrayList<String>();
			al.add("");
			return al;
		}
		List<String> recursionResultH=null;
		List<String> recursionResultV=null;
		if(sc<dc) {
			recursionResultH=getMazePaths(sr,sc+1,dr,dc);
		}
		
		if(sr<dr) {
			recursionResultV=getMazePaths(sr+1,sc,dr,dc);
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
	
	
	public static void getMazePathsSol2(int sr,int sc,int dr,int dc,String psf) {
        if(sr==dr && sc==dc) {
			System.out.print(psf);
			System.out.println(psf);
			return;
		}
		if(sc<dc) {
			getMazePathsSol2(sr,sc+1,dr,dc,psf+"H");
		}
		
		if(sr<dr) {
			getMazePathsSol2(sr+1,sc,dr,dc,psf+"V");
		}
    }
	
	public static List<String> getMazePathsSol3(int sr, int sc, int dr, int dc,String ans,List<String> output) {
        if(sr==dr && sc==dc) {
			output.add(ans);
			return output;
		}
		if(sc<dc) {
			getMazePathsSol3(sr,sc+1,dr,dc,ans+"H",output);
		}
		
		if(sr<dr) {
			getMazePathsSol3(sr+1,sc,dr,dc,ans+"V",output);
		}
		return output;
    }
}

