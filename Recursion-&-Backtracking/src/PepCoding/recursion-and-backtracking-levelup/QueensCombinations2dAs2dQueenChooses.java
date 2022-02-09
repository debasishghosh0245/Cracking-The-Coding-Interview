public class QueensCombinations2dAs2dQueenChooses {
    
    public static void main(String[] args){
        boolean[][] chess=new boolean[2][2];
        queensCombinations(chess,2,0,0);
    }
    
  /*   public static void queensCombinations(Integer[][] chess,int tq,int cq,int lastRow,
        int lastCol){
        if(cq> tq){
            for(int row=0;row<chess.length;row++){
                for(int col=0;col<chess[0].length;col++){
                    System.out.print(chess[row][col]!=null ? "q\t" : "-\t");
                }
                System.out.println(" ");
            } 
            return;
        }
        for(int row=lastRow;row<chess.length;row++){
            for(int col=(row==lastRow?lastCol+1:0);col<chess[0].length;col++){
                if(chess[row][col]==null){
                    chess[row][col]=cq;
                    queensCombinations(chess,tq,cq+1,row,col);
                    chess[row][col]=null;
                }
            }
        }
    } */
    
    public static void queensCombinations(boolean[][] chess,int tq,int cq,int lastCell){
        if(cq==tq){
            for(int row=0;row<chess.length;row++){
                for(int col=0;col<chess[0].length;col++){
                    if(chess[row][col]){
                        System.out.print("q ");
                    }else{
                        System.out.print("- ");
                    } 
                }
                        System.out.println();
            } 
                        System.out.println();
            return;
        }
        for(int cell=lastCell;cell<chess.length*chess.length;cell++){
            int row=cell/chess.length; //1
            int col=cell%chess.length; //1
            if(!chess[row][col]){
                    chess[row][col]=true;
                    queensCombinations(chess,tq,cq+1,row*chess.length+col);
                    chess[row][col]=false;
            }
        }
    }
}