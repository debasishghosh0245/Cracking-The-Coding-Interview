public class Permutations2 {

    public static void main(String[] args) {
       permutations(1,3,0,2,"",new int[2]);
    }
    
    public static void permutations(int cb,int tb,int ssf,int ts,String asf,int[] items){
        if(cb>tb){
             if(ssf==ts){
                System.out.println(asf);
            }
            return;
        }
        for(int i=0;i<items.length;i++) {
            if(items[i]==0) {
                items[i]=1;
                permutations(cb+1,tb,ssf+1,ts,asf+(i+1),items); 
                items[i]=0;
            }
        }
        permutations(cb+1,tb,ssf,ts,asf+"_",items);
    }
}

 