import java.util.*;

public class NQueens_51 {
   
    //https://leetcode.com/problems/n-queens/submissions/
   
    public static void main(String[] args) {
        List<List<String>> list=solveNQueens(5);
        System.out.println(list);
        
    }
    
    public static List<List<String>> solveNQueens(int n) {
        int[][] chess=new int[n][n];
        return helper(chess,0,new ArrayList<List<String>>());
    }
    
    public static List<List<String>> helper(int[][] chess,int row,List<List<String>> list) {
        if(row==chess.length) {
            List<String> op=new ArrayList<String>();
            for(int i=0;i<chess.length;i++) {
                StringBuilder sb=new StringBuilder();
                for(int j=0;j<chess[0].length;j++) {
                    if(chess[i][j]==1){
                        sb.append("Q");
                    }
                    else{
                        sb.append(".");
                    }
                }
                op.add(sb.toString());
            }
            list.add(op);
            return list;
        }
        for(int col=0;col<chess[0].length;col++) {
            if(isPossible(chess,row,col)){
                chess[row][col]=1;
                helper(chess,row+1,list);
                chess[row][col]=0;
            }
        }
        return list;
    }
    
    public static boolean isPossible(int[][] chess,int row,int col) {
        for(int i=row-1,j=col;i>=0;i--) {
            if(chess[i][j]==1){
               return false;
            }
        }
        for(int i=row-1,j=col-1;i>=0&&j>=0;i--,j--) {
            if(chess[i][j]==1){
               return false;
            }
        }
        for(int i=row-1,j=col+1;i>=0 && j<chess.length;i--,j++) {
            if(chess[i][j]==1){
               return false;
            }
        }
        return true;
    }
}