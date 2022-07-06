import java.util.*;
public class Combination {

	public static void main(String[] args){
		Integer[] boxes=new Integer[3];
		boolean[] usedItems=new boolean[3];
		int[] items={1,2};
		permutation(boxes,items,usedItems,0,0);
	}
	
	//Permutation 
	public static void permutation(Integer[] boxes,int[] items,
		boolean[] usedItems,int boxIdx,int itemCount){
		if(boxIdx==boxes.length){
			if(itemCount==2){
				for(int i=0;i<boxes.length;i++){
					System.out.print(boxes[i]==null ? "_" : boxes[i]);
				}
				System.out.println("");
			}
			return;
		}
		for(int itemIdx=0;itemIdx<items.length;itemIdx++){
			if(boxes[boxIdx]==null){
				if(usedItems[itemIdx]==false) {
					usedItems[itemIdx]=true;
					boxes[boxIdx]=items[itemIdx];
					permutation(boxes,items,usedItems,boxIdx+1,itemCount+1);
					boxes[boxIdx]=null;
					usedItems[itemIdx]=false;
				}
			}
		}
		permutation(boxes,items,usedItems,boxIdx+1,itemCount);
	}
	
	//Combniation 
	public static void combination(Integer[] boxes,int item,int boxIdx){
		if(boxIdx==boxes.length){
			if(item==5){
				for(int i=0;i<boxes.length;i++){
					System.out.print(boxes[i]==null ? "_" : boxes[i]);
				}
				System.out.println("");
			}
			return;
		}
		boxes[boxIdx]=1;
		combination(boxes,item+1,boxIdx+1);
		boxes[boxIdx]=null;
		combination(boxes,item,boxIdx+1);
	}
	
}