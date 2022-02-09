public class Combinations1 {
    
    public static void main(String[] args) {
        combinations(1,3,0,2,"");
    
    }
    
    public static void combinations(int cb,int tb,int ssf,int ts,String asf){
        if(cb>tb) {
            if(ts==ssf) {
                System.out.println(asf);
            }
            return;
        }       
        combinations(cb+1,tb,ssf,ts,asf+"-");
        combinations(cb+1,tb,ssf+1,ts,asf+"i");
    }
}