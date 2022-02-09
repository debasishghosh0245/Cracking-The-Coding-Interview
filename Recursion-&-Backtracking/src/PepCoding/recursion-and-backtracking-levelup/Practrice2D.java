import java.util.*;
public class Practrice2D {
    
    public static void main(String[] args) {
       
        Integer[][] chess=new Integer[2][2];
        queensPermutations(0,2,chess);
    }
    
    public static void queensPermutations(int qpsf,int tq,Integer[][] chess){
        if(qpsf==tq){
            for(int row=0;row<chess.length;row++){
                for(int col=0;col<chess[0].length;col++){
                    System.out.print(chess[row][col]!=null ? "q"+chess[row][col]+" " :"- ");
                }
                System.out.println(" ");
            }
            return;
        }
        for(int row=0;row<chess.length;row++){
            for(int col=0;col<chess[0].length;col++){
                if(chess[row][col]==null){
                    chess[row][col]=qpsf+1;
                    queensPermutations(qpsf+1,tq,chess);
                    chess[row][col]=null; 
                }
            }
        }
        return;
    }
}