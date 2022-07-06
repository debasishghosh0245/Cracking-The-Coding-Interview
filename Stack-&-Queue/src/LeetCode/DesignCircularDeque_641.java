import java.util.*;
public class DesignCircularDeque_641{
	
	public int size=0;
	LinkedList<Integer> list=null;
	
	public static void main(String[] args){
		DesignCircularDeque_641 myCircularDeque=new DesignCircularDeque_641(3);
		myCircularDeque.insertLast(1);  // return True
		myCircularDeque.insertLast(2);  // return True
		myCircularDeque.insertFront(3); // return True
		myCircularDeque.insertFront(4);
		System.out.println(myCircularDeque.toString());
		System.out.println(myCircularDeque.getRear());

	}
	
	public DesignCircularDeque_641(int k) {
		this.size=k;
        list=new LinkedList<>();
    }
    
    public boolean insertFront(int value) {
        if(list.size() >= size) {
			return false;
		}
		else{
			list.addFirst(value);
			return true;
		}
    }
    
    public boolean insertLast(int value) {
        if(list.size() >=size) {
			return false;
		}
		else{
			list.addLast(value);
			return true;
		}
    }
    
    public boolean deleteFront() {
		if(list.size()>0){
			 list.removeFirst();
			 return true;
		}
		return false;
    }
    
    public boolean deleteLast() {
        if(list.size() > 0){
			list.removeLast();
			return true;
		}
		else  return false;
    }
    
    public int getFront() {
        if(list.size()==0) return -1;
		else return list.getFirst();
    }
    
    public int getRear() {
        if(list.size()==0) return -1;
		else return list.getLast();
    }
    
    public boolean isEmpty() {
        return list.size()==0;
    }
    
    public boolean isFull() {
        return list.size()==this.size;
    }


}