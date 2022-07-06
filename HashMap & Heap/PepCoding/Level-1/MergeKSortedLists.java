import java.util.*;
public class MergeKSortedLists {
	
	public static void main(String[] args){
		List<Integer> list1=new ArrayList<>(Arrays.asList(10,20,30,40,50));
		List<Integer> list2=new ArrayList<>(Arrays.asList(5,7,9,11,19,55,57));
		List<Integer> list3=new ArrayList<>(Arrays.asList(1,2,3));
		
		List<List<Integer>> list=new ArrayList<List<Integer>>();
		list.add(list1);
		list.add(list2);
		list.add(list3);
		System.out.println(mergeKSortedLists(list));
	}
	
	public static List<Integer> mergeKSortedLists(List<List<Integer>> lists){
		ArrayList<Integer> result = new ArrayList<>();
		PriorityQueue<Pair> heap=new PriorityQueue<>();
		for(int i=0;i<lists.size();i++){
			heap.offer(new Pair(i,lists.get(i).get(0),0));
		}
		while(!heap.isEmpty()){
			Pair pair=heap.poll();
			result.add(pair.val);
			pair.dataIndex++;
			if(pair.dataIndex < lists.get(pair.listIndex).size()){
				heap.offer(new Pair(pair.listIndex,
				lists.get(pair.listIndex).get(pair.dataIndex),
				pair.dataIndex));
			}
		}
		return result;
	}
   
   
	public static class Pair implements Comparable<Pair>{
		int listIndex;
		int val;
		int dataIndex;
		
		Pair(int index,int val,int dataIndex){
			this.listIndex=index;
			this.val=val;
			this.dataIndex=dataIndex;
		}
		
		public int compareTo(Pair pair){
			return this.val-pair.val;
		}
	}

}