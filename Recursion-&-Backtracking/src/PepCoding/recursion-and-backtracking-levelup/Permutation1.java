public class  Permutation1 {
    
    public static void main(String[] args) {
        permutations(new int[3],1,3);
    }
    
    public static void permutations(int[] boxes,int citem,int ritem){
        if(citem>ritem) {
            for(int i=0;i<boxes.length;i++) {
                System.out.print(boxes[i]);
            }
                System.out.println("");
            return;
        }       
        for(int i=0;i<boxes.length;i++) {
            if(boxes[i]==0){
                boxes[i]=citem;
                permutations(boxes,citem+1,ritem);
                boxes[i]=0;
            }
        }
    }
} 