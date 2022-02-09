public class QueensCombinations2dAs2d {
    
    public static void main(String[] args){
       queensCombinations(0, 2, 0, 0, "");
    }
    
    public static void combination(int ssf,int tb,int qpsf,int tq,String ansf) {
        if(ssf==tb){
            if(qpsf==tq) {
                 System.out.println(ansf);
            }
            return;
        }
        combination(ssf+1,tb,qpsf+1,tq,ansf+"q");
        combination(ssf+1,tb,qpsf,tq,ansf+"-");
    }
    
    public static void queensCombinations(int qpsf,int tq,int row,int col,String asf){
        if(row==tq){
            if(qpsf==tq) {
                 System.out.println(asf);
            }
            return;
        }
        String yasf="";
        String nasf="";
        if(col==tq-1){
            row++;
            col=0;
            yasf=asf+"q\n";
            nasf=asf+"-\n";
        }
        else{
            col++;
            yasf=asf+"q";
            nasf=asf+"-";
        }
        queensCombinations(qpsf+1,tq,row,col,yasf);
        queensCombinations(qpsf,tq,row,col,nasf);
    }


}