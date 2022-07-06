import java.util.*;
public class NQueenPermutaion2{

	public static void main(String[] args){
		String[][] board=new String[4][4];
		nQueenSolver(board,0,4,0,0);
	}
	
	public static void nQueenSolver(String[][] board,
		int currQueen,int totalQueen,int row,int col){
		if(currQueen > totalQueen){
			for(int i=0;i<board.length;i++){
				for(int j=0;j<board.length;j++){
					if(board[i][j]!=null){
						System.out.print(board[i][j]);
					}
					else{
						System.out.print("- ");
					}
				}
				System.out.println();
			}
			row=0;
			col=0;
			System.out.println();
			return;
		}
		int nextRow=0;
		int nextCol=0;
		if(col==board.length-1){
			nextRow=row+1;
			nextCol=0;
		}
		else{
			nextCol=col+1;
			nextRow=row;
		}
		if(null==board[row][col] && isValid(board,row,col)){
			board[row][col]="q"+currQueen;
			nQueenSolver(board,currQueen+1,totalQueen,nextRow,nextCol);
			
		}else{
			nQueenSolver(board,currQueen,totalQueen,nextRow,nextCol);
		}
		board[row][col]=null;
	}
	
	public static boolean isValid(String[][] board, int row, int col) {
		// vertical
		for (int i=row,j=col;i>=0;i--) {
			if (board[i][j] != null) {
				return false;
			}
		}
		for (int i=row,j=col;i<board.length;i++) {
			if (board[i][j] != null) {
				return false;
			}
		}
		// horizontal
		for (int i=row,j=col;j>=0;j--) {
			if (board[i][j] != null) {
				return false;
			}
		}
		for (int i=row,j=col;j<board.length;j++) {
			if (board[i][j] != null) {
				return false;
			}
		}
		// diagonal
		for (int i=row,j=col;i>=0&&j>=0;i--,j--) {
			if (board[i][j] != null) {
				return false;
			}
		}
		for (int i=row,j=col; i<board.length && j<board.length;i++,j++) {
			if (board[i][j] != null) {
				return false;
			}
		}
		// anti-diagonal
		for (int i=row,j=col;i>=0&&j<board.length;i--,j++) {
			if (board[i][j]!=null) {
				return false;
			}
		}
		for (int i=row,j=col;i<board.length && j>=0;i++,j--) {
			if (board[i][j]!=null) {
				return false;
			}
		}
		return true;
	}
}