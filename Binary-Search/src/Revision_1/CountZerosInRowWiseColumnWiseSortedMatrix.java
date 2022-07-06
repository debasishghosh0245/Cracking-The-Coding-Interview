public class CountZerosInRowWiseColumnWiseSortedMatrix {
	
	public static void main(String[] args){
		int[][] matrix={{0, 0, 0, 0, 1},{0, 0, 0, 1, 1},{0, 1, 1, 1, 1},
		{1, 1, 1, 1, 1},{1, 1, 1, 1, 1}};
		System.out.println(countZeros(matrix));
	}

	public static int countZeros(int[][] matrix){
		int row_index=0;
		int col_index=matrix[0].length-1;
		int oneCount=0;
		int zeroCount=0;
		while(row_index < matrix.length & col_index >=0){
			if(matrix[row_index][col_index]==1){
				oneCount+=matrix[0].length-row_index;
				col_index--;
			}
			else if(matrix[row_index][col_index]==0){
				zeroCount+=col_index+1;
				row_index++;
			}
		}
		return zeroCount;
	}
}