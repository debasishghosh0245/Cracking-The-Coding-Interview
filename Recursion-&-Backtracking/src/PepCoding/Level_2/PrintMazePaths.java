import java.util.*;
public class PrintMazePaths{

	public static void main(String[] args){
		int[][] board=new int[2][2];
		getMazePath(board,0,0,new ArrayList<String>());
	}
	
	public static void getMazePath(int[][] board,int row,int col,List<String> path){
		if(row==board.length-1 && col==board.length-1){
			System.out.println(path);
			return;
		}
		if(col < board.length){
			path.add("H");
			getMazePath(board,row,col+1,path);
			path.remove(path.size()-1);
		}
	    if(row < board.length){
			path.add("V");
			getMazePath(board,row+1,col,path);
			path.remove(path.size()-1);
		}
	}
}