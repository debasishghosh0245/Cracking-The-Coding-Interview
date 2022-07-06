public class Combinations2 {
    //Print Combination From Permutaion //
    
    public static void main(String[] args) {
        Integer[] boxes=new Integer[5];
        combination(boxes,0,3,0);
    }
    
    public static void combination(Integer[] boxes,int item,int items,int last){
        if(items==item){
            for(int box=0;box<boxes.length;box++){
                System.out.print(boxes[box]!=null ? "p" : "-");
            }
                System.out.println("");
            return;
        }
        for(int box=last;box<boxes.length;box++){
            if(boxes[box]==null){
                boxes[box]=item;
                combination(boxes,item+1,items,box);
                boxes[box]=null; 
            }
        }
    }
}