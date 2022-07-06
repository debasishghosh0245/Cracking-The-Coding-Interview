public class SearchA2DMatrix_74{
	
	public static void main(String[] args){
		int[][] matrix ={{1,3,5,7},{10,11,16,20},{23,30,34,60}};
		int target=13;
		System.out.println(searchMatrixII(matrix,target));
	}
	
	public static boolean searchMatrix(int[][] matrix, int target) {
        int left=0;
		int col_length=matrix[0].length;
		int row_length=matrix.length;
		int right=row_length*col_length-1;
		while(right>left){
			int mid=left+(right-left/2);
			if(target==matrix[mid/col_length][mid%col_length]){
				return true;
			}
			else if(target>matrix[mid/col_length][mid%col_length]){
				left=mid+1;
				
			}
			else {
				right=mid-1;
			}
		}
	    return false;
	}
	
	public static boolean searchMatrixII(int[][] matrix, int target) {
        int left=0;
		int right=matrix.length-1;
		int col=matrix[0].length-1;
		while(right>=left){
			int mid=left+(right-left)/2;
			if(target>matrix[mid][col]){
				left=mid+1;
			}
			else if(target<matrix[mid][0]){
				right=mid-1;
			}
			else {
				int row=mid;
				left=0;
				right=col;
				while(right >= left){
					mid=left+(right-left/2);
					if(target==matrix[row][mid]){
						return true;
					}
					else if(target>matrix[row][col]){
						left=mid+1;
					}
					else{
						right=mid-1;
					}
				}
			}
		}
	    return false;
	}


}