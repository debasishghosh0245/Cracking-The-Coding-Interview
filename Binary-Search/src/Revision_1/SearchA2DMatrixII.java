public class SearchA2DMatrixII{
	
	public static void main(String[] args){
		int[][] matrix ={{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}}; 
		int target=144;
		System.out.println(searchMatrix(matrix,target));
	}
	
	public static boolean searchMatrix(int[][] matrix, int target) {
		int row_index=0;
		int col_index=matrix[0].length-1;
        while(row_index < matrix.length 
			&& col_index >=0){
			if(target==matrix[row_index][col_index]){
				return true;
			}
			else if(target < matrix[row_index][col_index]){
				col_index=col_index-1;
			}
			else if(target > matrix[row_index][col_index]){
				row_index=row_index+1;
			}
		}
		return false;
    }

}