import java.util.*;
public class Permutaion{

	public static void main(String[] args){
		Integer[] boxes=new Integer[5];
		int[] items={1,2,3};
		combination(boxes,items,0,-1);
		//permution(boxes,items,0);
	}

	//permutation
	public static void permution(Integer[] boxes,int[] items,int itemIdx){
		if(itemIdx==items.length){
			System.out.println(Arrays.toString(boxes));
			return;
		}
		for(int boxIdx=0;boxIdx < boxes.length;boxIdx++){
			if(boxes[boxIdx]==null){
				boxes[boxIdx]=items[itemIdx];
				permution(boxes,items,itemIdx+1);
				boxes[boxIdx]=null;
			}
		}
	}
	
	//Combination
	public static void combination(Integer[] boxes,int[] items,int itemIdx,int lastBoxIdx){
		if(itemIdx == items.length){
			System.out.println(Arrays.toString(boxes));
			return;
		}
		for(int boxIdx=lastBoxIdx+1; boxIdx < boxes.length; boxIdx++){
			if(boxes[boxIdx]==null){
				boxes[boxIdx]=items[itemIdx];
				lastBoxIdx=boxIdx;
				combination(boxes,items,itemIdx+1,lastBoxIdx);
				boxes[boxIdx]=null;
			}
		}
	}
}
