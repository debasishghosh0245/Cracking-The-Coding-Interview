import java.util.*;

public class NQueens {

	public static void main(String[] args) {
		int[][] chess = new int[4][4];
		nqueens(chess, 0);
	}
	
	public static void nqueens(int[][] chess, int row) {
		if (row > chess.length - 1) {
			for (int i = 0; i < chess.length; i++) {
				for (int j = 0; j < chess.length; j++) {
					System.out.print(chess[i][j]);
				}
				System.out.println();
			}
			System.out.println();
			return;
		}
		for (int col = 0; col < chess.length; col++) {
			if (chess[row][col]==0 && isQueenSafe(chess, row, col)) {
				chess[row][col]=col+1;
				nqueens(chess,row + 1);
				chess[row][col]= 0;
			}
		}
	}

	public static boolean isQueenSafe(int[][] chess, int row, int col) {
		for (int i = row; i >= 0; i--) {
			if (chess[i][col] != 0) {
				return false;
			}
		}
		for (int j = col; j >= 0; j--) {
			if (chess[row][j] != 0) {
				return false;
			}
		}
		for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
			if (chess[i][j] != 0) {
				return false;
			}
		} 
		for (int i = row, j = col; i >= 0 && j < chess.length; i--, j++) {
			if (chess[i][j] != 0) {
				return false;
			}
		}
		return true;
	}
}