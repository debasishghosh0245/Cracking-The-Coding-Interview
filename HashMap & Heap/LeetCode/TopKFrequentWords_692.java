import java.util.*;
public class TopKFrequentWords_692{
	
	public static void main(String[] args){
		String[] words = {"i","love","leetcode","i","love","coding"};
		int k = 2;
		System.out.println(topKFrequent(words,k));
		//System.out.println(Arrays.toString(topKFrequent(words,k)));
	}
	
	public static List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> hashMap=new HashMap<>();
		for(String str:words){
			hashMap.put(str,hashMap.getOrDefault(str,0)+1);
		}
		PriorityQueue<Map.Entry<String,Integer>> heap = new PriorityQueue<>(
		(a,b) -> a.getValue()==b.getValue() ? b.getKey().compareTo(a.getKey()) 
		: a.getValue()-b.getValue());
		for(Map.Entry<String,Integer> entry:hashMap.entrySet()){
			heap.add(entry);
			if(heap.size()>k){
				 heap.remove();
			}
		}
		List<String> list=new ArrayList<String>();
		while(!heap.isEmpty()  ){
			 list.add(0,heap.poll().getKey());
		}
		return list;
    }
}