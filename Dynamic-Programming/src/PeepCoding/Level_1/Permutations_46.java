import java.util.*;
public class Permutations_46{

	public static void main(String[] args){
		int[] nums={1,2,3};
		//LinkedList<LinkedList<Integer>> list=new LinkedList<LinkedList<Integer>>();
		System.out.println(permuationRec(nums,nums.length-1));
	}
	
	//Approach 1 
	public static LinkedList<LinkedList<Integer>> permuationRec(int[] nums,int idx){
		if(idx == 0) {
			LinkedList<LinkedList<Integer>> result=new LinkedList<LinkedList<Integer>>();
			LinkedList<Integer> linkedList=new LinkedList<>();
			linkedList.add(nums[0]);
			result.add(linkedList);
			return result;
		}
		LinkedList<LinkedList<Integer>> tempResult=permuationRec(nums,idx-1);
		LinkedList<LinkedList<Integer>> finalResult=new LinkedList<LinkedList<Integer>>();
		for(LinkedList<Integer> list: tempResult){
			for(Integer i:list){
				
			}
			LinkedList linkedList=new LinkedList<>(list);
			linkedList.addFirst(nums[idx]);
			finalResult.add(linkedList);
		}
		for(LinkedList<Integer> list: tempResult){
			LinkedList linkedList=new LinkedList<>(list);
			linkedList.addLast(nums[idx]);
			finalResult.add(linkedList);
		}
		return finalResult;
	}
	
	//Approach 2 : 
	public static void permuation(Integer[] boxes,int[] nums,int idx) {
		if(idx==nums.length){
			for(int i=0;i<boxes.length;i++){
				System.out.print(boxes[i]==null ? "_" : boxes[i]);
			}
			System.out.println("");
			return ;
		}
		for(int bx=0;bx<boxes.length;bx++){
			if(boxes[bx]==null){
				boxes[bx]=nums[idx];
				permuation(boxes,nums,idx+1);
				boxes[bx]=null;
			}
		}
	}
	
	//Apparocah 3 : 
	public static void permuation(int[] nums,int idx,List<Integer> ans){
		if(idx==nums.length){
			System.out.println(ans);
		}
		for(int i=0;i<nums.length;i++){
			ans.add(nums[i]);
			permuation(nums,idx+1,ans);
			ans.remove(ans.size()-1);
		}
	}
}