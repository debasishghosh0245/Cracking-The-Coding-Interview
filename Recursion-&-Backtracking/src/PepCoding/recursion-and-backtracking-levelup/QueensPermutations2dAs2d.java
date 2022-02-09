public class QueensPermutations2dAs2d {
    
    
    public static void main(String[] args){
        int[][] chess=new int[3][3];
        boolean[][] visited=new boolean[3][3];
        queensPermutations(chess,0,2,visited);
    }
    
    public static void queensPermutations(int[][] chess,int qpsf,int tq,boolean[][] visited){
        if(qpsf==tq){
            for(int i=0;i<chess.length;i++) {
                for(int j=0;j<chess[0].length;j++) {
                    System.out.print(chess[i][j] != 0
                           ? "q" + chess[i][j] + "	" : "-	");
                }
                System.out.println();
            }
            System.out.println();
            return;
        }
        for(int i=0;i<chess.length;i++) {
            for(int j=0;j<chess[0].length;j++) {
                if(!visited[i][j]){
                    chess[i][j]=qpsf+1;
                    visited[i][j]=true;
                    queensPermutations(chess,qpsf+1,tq,visited);
                    visited[i][j]=false;
                    chess[i][j]=0;
                }
            }
            
        }
        
    }
}