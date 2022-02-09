import java.util.*;
public class PermutationsII_47{
    public static void main(String[] args){
        int[] nums ={1,1,2};
        Integer[] boxes=new Integer[nums.length];
        List<List<Integer>> op=calPermution(boxes,nums,0,new ArrayList<List<Integer>>());
        System.out.println(op); 
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
}