import java.util.*;
public class NqueensCombination2dAs1dQueenChooses{
    
    public static void main(String[] args) {
        String[][] chess=new String[4][4];
        int tq=4;
        nqueensCombination(1,tq,chess,0);
    }
    
    public static void nqueensCombination(int qpsf,int tq,String[][] chess,int lastCell) {
        if(qpsf>tq){
            for(int i=0;i<chess.length;i++) {
                for(int j=0;j<chess.length;j++){
                    if(chess[i][j]!=null) {
                        System.out.print(chess[i][j]+" ");
                    }else{
                        System.out.print("-  ");
                    }
                }
                System.out.println(" ");
            }
            System.out.println(" ");
            return;
        }
        for(int cell=lastCell;cell<chess.length*chess.length;cell++){
            int row=cell/chess.length;
            int col=cell%chess.length;
            if(chess[row][col]==null && isQueenSafeToPlace(chess,row,col)){
                chess[row][col]="q";
                nqueensCombination(qpsf+1,tq,chess,row*chess.length+col); 
                chess[row][col]=null; 
            }
        }
    }
    
    public static boolean isQueenSafeToPlace(String[][] chess,int row,int col) {
        //check row wise up
        for(int i=row,j=col;i>=0;i--) {
            if(chess[i][j]!=null) return false;
        }
        //check row wise down
        for(int i=row,j=col;i<chess.length;i++) {
            if(chess[i][j]!=null) return false;
        }
        //check column diagoals up
        for(int i=row,j=col;j>=0;j--) {
            if(chess[i][j]!=null) return false;
        }
         //check column diagoals down
        for(int i=row,j=col;j<chess[0].length;j++) {
            if(chess[i][j]!=null) return false;
        }
        //check left diagonals
        for(int i=row,j=col;i>=0 && j>=0;i--,j--) {
            if(chess[i][j]!=null) return false;
        }
        //check left diagonals
        for(int i=row,j=col;i<chess[0].length && j>=0;i++,j--) {
            if(chess[i][j]!=null) return false;
        }
        //check right diagoals
        for(int i=row,j=col;i>=0 && j<chess.length; i--,j++) {
            if(chess[i][j]!=null) return false;
        }
        //check right diagoals
        for(int i=row,j=col; i<chess.length && j<chess.length; i++,j++) {
            if(chess[i][j]!=null) return false;
        }

        return true;
    }
}