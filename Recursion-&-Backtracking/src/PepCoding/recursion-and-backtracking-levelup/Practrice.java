import java.util.*;
public class Practrice {
    
    public static void main(String[] args) {
       
        Integer[] boxes=new Integer[5];
        /* int[] nums ={1,1,2};
        List<List<Integer>> op=calPermution(boxes,nums,0,new ArrayList<List<Integer>>());
        System.out.println(op); */
        combination(boxes,0,3,"");
    }
    
    public static List<List<Integer>> calPermution(Integer[] boxes,int[] nums, int item,
        List<List<Integer>> output){
        if(nums.length==item){
            output.add(new ArrayList<Integer>(Arrays.asList(boxes)));
            return output;
        }
        for(int box=0;box<boxes.length;box++){
            if(boxes[box]==null){
                boxes[box]=nums[item];
                calPermution(boxes,nums,item+1,output);
                boxes[box]=null; 
            }
        }
        return output;
    }
    
    public static void combination(Integer[] boxes,int item,int items,String ans){
        if(items==item){
            for(int box=0;box<boxes.length;box++){
                System.out.print(boxes[box]!=null ? "i" : "-");
            }
                System.out.println("");
            return;
        }
        for(int box=0;box<boxes.length;box++){
            if(boxes[box]==null){
                boxes[box]=item;
                combination(boxes,item+1,items,ans);
                boxes[box]=null; 
            }
        }
    }
}