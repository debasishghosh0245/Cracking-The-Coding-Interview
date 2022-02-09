package LeetCode;

public class SearchA2DMatrix_74 {

     public static void main(String[] args) {
         
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}}; int target = 60;
        System.out.println(searchForRow(matrix,target));
     }
     
     public static boolean searchMatrix(int[][] matrix, int target) {
            int low=0; int row=matrix.length;
            int col=matrix[0].length;
            int high=row * col -1;
            System.out.println("High  >> "+high);
            while(low<=high) {
                int mid=low+(high-low)/2;
                if(target==matrix[mid/col][mid%col]) {
                    System.out.println("row >> " +mid/col+"  column >>  "+mid%col);
                    return true;
                } else if(target>matrix[mid/col][mid%col]) {
                    low=mid+1;
                }
                else   {
                    high=mid-1;
                }
            }
            return false;
     }
     
     public static boolean searchForRow(int[][] matrix, int target) {
            int low=0; int high=matrix.length-1;
            int col=matrix[0].length-1;
            System.out.println("High  >> "+high);
            while(low<=high) {
                int mid=low+(high-low)/2;
                if(target>=matrix[mid][0] && target <= matrix[mid][col]) {
                    System.out.println("Search In Row >> "+mid+" col >> "+col);
                    searchForColumn(matrix,target,mid);
                    return true;
                } else if(target>matrix[mid][col]) {
                    low=mid+1;
                }
                else   {
                    high=mid-1;
                }
            }
            return false;
     }
     
     public static boolean searchForColumn(int[][] matrix, int target,int row) {
            int low=0; int high=matrix[0].length-1;
            System.out.println("High  >> "+high);
            while(low<=high) {
                int mid=low+(high-low)/2;
                if(target==matrix[row][mid]) {
                    System.out.println("Search In Row >> "+row+" col >> "+mid);
                    return true;
                } else if(target>matrix[row][mid]) {
                    low=mid+1;
                }
                else {
                    high=mid-1;
                }
            }
            return false;
     }
}