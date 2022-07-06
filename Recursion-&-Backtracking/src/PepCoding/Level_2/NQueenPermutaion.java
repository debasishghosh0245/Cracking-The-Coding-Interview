import java.util.*;
public class NQueenPermutaion{

	public static void main(String[] args){
		String[][] board=new String[4][4];
		nQueenSolver(board,0,4);
	}
	
	public static void nQueenSolver(String[][] board,
		int currQueen,int totalQueen){
		if(currQueen == totalQueen){
			for(int row=0;row<board.length;row++){
				for(int col=0;col<board.length;col++){
					if(board[row][col]!=null){
						System.out.print(board[row][col]);
					}
					else{
						System.out.print("- ");
					}
				}
				System.out.println();
			}
			System.out.println();
			return;
		}
		for(int row=0;row<board.length;row++){
			for(int col=0;col<board.length;col++){
				if(null==board[row][col] && isValid(board,row,col)){
					board[row][col]="q"+currQueen;
					nQueenSolver(board,currQueen+1,totalQueen);
					board[row][col]=null;
				}
			}
		}
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
		for (int i=row, j=col; i<board.length && j<board.length;i++,j++) {
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
		for (int i=row,j=col; i<board.length && j >= 0;i++,j--) {
			if (board[i][j]!=null) {
				return false;
			}
		}
		return true;
	}
}