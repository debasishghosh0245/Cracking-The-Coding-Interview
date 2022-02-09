public class PrintStairPathWithVariableJump{
    
    public static void main(String[] args){
       int[] jumps={2,3,0,1,2,3};    
       printStairPath(jumps,0,"");
    }
    
    public static void printStairPath(int[] jumps,int idx,String ansf){
        if(idx==5){
            System.out.println(ansf);
            return;
        }
        for(int jump=1;jump<=jumps[idx];jump++){
            if(jumps[idx+jump]>0){
                printStairPath(jumps,idx+jump,ansf+jumps[idx]); 
            }
        } 
    }
}