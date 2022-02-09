import java.util.*;
import java.io.*;
public class PrintMazePathsWithJumps {
   
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        List<String> list=printMazePaths(0,0,n-1,m-1,"",new ArrayList<String>());
        System.out.println(list);
        
	}
	
	public static List<String> printMazePaths(int sr, int sc, int dr, int dc,String psf,List<String> list) {
        if(sr == dr && sc == dc) {
           list.add(psf);
           return list;
        }
        for (int move = 1; move <= dc - sc; move++) {
           printMazePaths(sr, sc + move, dr, dc, psf + "h" + move,list);
        }
        for (int move = 1; move <= dr - sr; move++) {
           printMazePaths(sr + move, sc, dr, dc, psf + "v" + move,list);
        }
        for (int move = 1; move <= dc - sc && move <= dr - sr; move++) {
           printMazePaths(sr + move, sc + move, dr, dc, psf + "d" + move,list);
        }
        return list;        
    }
}

