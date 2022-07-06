import java.util.*;
public class RandomizedSet_380 {

	HashMap<Integer,Integer> valueIndexMap=null;
	ArrayList<Integer> list=null;
	
    public RandomizedSet_380() {
        valueIndexMap=new HashMap<>();
		list=new ArrayList<>();
    }
    
    public boolean insert(int val) {
        if(valueIndexMap.containsKey(val)){
			return false;
		} 
		else {
			valueIndexMap.put(val,list.size());
			list.add(val);
			return true;
		}
    }
    
    public boolean remove(int val) {
        if(!valueIndexMap.containsKey(val)){
			return false;
		} 
		else {
			//removing the last element from list is constanct Time
			//every time we swap the value with last element from list
			//but how we get the index;
			int index=valueIndexMap.get(val);
			int listElement=list.get(index);
			int lastElement=list.get(list.size()-1);
			list.set(list.size()-1,listElement);
			list.set(index,lastElement);
			//remove from list
			valueIndexMap.put(lastElement,index);
			valueIndexMap.put(listElement,list.size()-1);
			list.remove(list.size()-1);
			valueIndexMap.remove(val);
			return true;
		}
    }
    
    public int getRandom() {
		Random rand=new Random();
		return list.get(rand.nextInt(list.size()));
    }
	
	
	public static void main(String[] args){
		/* ["RandomizedSet", "insert", "remove", "insert", 
			"getRandom", "remove", "insert", "getRandom"]
			[[], [1], [2], [2], [], [1], [2], []] */
		RandomizedSet_380 randome=new RandomizedSet_380();
		System.out.println(randome.insert(0));
		System.out.println(randome.insert(1));
		System.out.println(randome.remove(0));
		System.out.println(randome.insert(2));
		System.out.println(randome.remove(1));
		System.out.println("Print Random >> "+randome.getRandom());
		System.out.println("Map >> "+randome.valueIndexMap);
		System.out.println("List >> "+randome.list);
	}
}