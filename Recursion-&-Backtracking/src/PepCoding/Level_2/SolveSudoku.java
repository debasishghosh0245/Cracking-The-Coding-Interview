import java.util.*;
public class SolveSudoku{

	public static void main(String[] args){
		int[][] board= {{3,0,6,5,0,8,4,0,0},
					    {5,2,0,0,0,0,0,0,0},
						{0,8,7,0,0,0,0,3,1},
						{0,0,3,0,1,0,0,8,0},
						{9,0,0,8,6,3,0,0,5},
						{0,5,0,0,9,0,6,0,0},
						{1,3,0,0,0,0,2,5,0},
						{0,0,0,0,0,0,0,7,4},
						{0,0,5,2,0,6,3,0,0}};
		solveSudoku(board,0,0);
	}
	
	public static void sudokoSolver(int[][] board,int row,int col){
		if(row == board.length) {
			for(int i=0;i<board.length;i++){
				for(int j=0;j<board.length;j++){
					System.out.print(board[i][j]);
				}
				System.out.println();
			}
			System.out.println();
			return ;
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
		if(board[row][col]!=0){
			sudokoSolver(board,nextRow,nextCol);
		}else{
			for(int i=1;i<=9;i++){
				if(isValid(board,row,col,i)){
					board[row][col]=i;
					sudokoSolver(board,nextRow,nextCol);
					board[row][col]=0;
				}
			}
		}
		
	}
	
	public static void solveSudoku(int[][] board, int i, int j) {
		if (i == board.length) {
			for(int row=0;row<board.length;row++){
				for(int col=0;col<board.length;col++){
					System.out.print(board[row][col]);
				}
				System.out.println();
			}
			return;
		}
		int ni = 0;
		int nj = 0;
		if (j == board[0].length - 1) {
			ni = i + 1;
			nj = 0;
		} else {
			ni = i;
			nj = j + 1;
		}

		if (board[i][j] != 0) {
			solveSudoku(board, ni, nj);
		} 
		else {
			for (int val = 1; val <= 9; val++) {
				if (isValid(board, i, j, val)) {
					board[i][j] = val;
					solveSudoku(board, ni, nj);
					board[i][j] = 0;
				}
		}
	  }
	}
	
	public static boolean isValid(int[][] board, int row, int col, int val) {
		int n = board.length;
		for (int i=row;i>=0;i--) {
			if (board[i][col] == val) {
			  return false;
			}
		}
		for (int j=col;j>=0;j--) {
			if(board[row][j] == val) {
			  return false;
			}
		}
		row = row/3*3;
		col = col/3*3;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
			  if (board[row + i][col + j] == val) {
				return false;
			  }
			}
		}
		return true;
	}

}