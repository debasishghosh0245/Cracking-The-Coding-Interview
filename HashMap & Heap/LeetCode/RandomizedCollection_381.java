import java.util.*;
public class RandomizedCollection_381 {
        
    HashMap<Integer,HashSet<Integer>> indexMap=null;
	ArrayList<Integer> list=null;
	
    public RandomizedCollection_381() {
        indexMap=new HashMap<>();
		list=new ArrayList<>();
    }
    
    public boolean insert(int val) {
        if(indexMap.containsKey(val)){
			HashSet<Integer> set=indexMap.get(val);
			set.add(list.size());
			indexMap.put(val,set);
			list.add(val);
			return false;
		} 
		else {
			HashSet<Integer> set=new LinkedHashSet<>();
			set.add(list.size());
			indexMap.put(val,set);
			list.add(val);
			return true;
		}
    }
    
    public boolean remove(int val) {
        if(!indexMap.containsKey(val)){
			return false;
		} 
		else {
			HashSet<Integer> indexes=indexMap.get(val);
			int remove_index=indexes.iterator().next();
			indexes.remove(remove_index);
			if(indexes.size()==0){
				indexMap.remove(val);
			}
			
			int last_elment=list.get(list.size()-1);
			list.set(remove_index,last_elment);
			int lastIndex=list.size()-1;
			list.remove(lastIndex);
			
			if(indexMap!=null && indexMap.get(last_elment)!=null) {
                indexMap.get(last_elment).add(remove_index);
			    indexMap.get(last_elment).remove(lastIndex);
            }
			
			return true;
		}
    }
    
    public int getRandom() {
		Random rand=new Random();
		return list.get(rand.nextInt(list.size()));
    }
	
	public static void main(String[] args){
		RandomizedCollection_381 randome=new RandomizedCollection_381();
		System.out.println(randome.insert(0));
		System.out.println(randome.insert(1));
		System.out.println(randome.remove(0));
		//System.out.println(randome.insert(2));
		//System.out.println(randome.getRandom());
		
		System.out.println("Index Map >> "+randome.indexMap);
		System.out.println("List >> "+randome.list);
	}
}
