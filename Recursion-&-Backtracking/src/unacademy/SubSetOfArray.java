package unacademy;
import java.util.*;

public class SubSetOfArray {

    public static void main(String[] args) {
        Integer[] arr={1,2};
        List<List<Integer> > list=new ArrayList<List<Integer> >();
        findSubsets(list, Arrays.asList(arr), new ArrayList<Integer>(), 0);
        System.out.println(list);
    }

    public static void findSubsets(List<List<Integer>> subset, List<Integer> nums, ArrayList<Integer> output,
            int index) {
        if(nums.size()==index) {
            subset.add(output);
            return;
        }
        output.add(nums.get(index));           
        findSubsets(subset, nums, new ArrayList<Integer>(output), index+1);
        output.remove(nums.get(index));           
        findSubsets(subset, nums, new ArrayList<Integer>(output), index+1);
    }


}
