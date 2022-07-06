public class TransposeMatrix_867{

    public static void main(String[] args){
        int[][] matrix={{2,4,-1},{-10,5,11},{18,-7,6}};
        matrix=trasponse(matrix);
        for(int row=0;row<matrix.length;row++){
            for(int col=0;col<matrix[0].length;col++){
                System.out.print(matrix[row][col]+" ");
            }
            System.out.println("");
        }
    }

    public static int[][] trasponse(int[][] matrix){
        int[][] result=new int[matrix[0].length][matrix.length];
        for(int row=0;row<matrix.length;row++){
            for(int col=0;col<matrix[0].length;col++){
                result[col][row]=matrix[row][col];
            }
        }
        return result;
    }
}
