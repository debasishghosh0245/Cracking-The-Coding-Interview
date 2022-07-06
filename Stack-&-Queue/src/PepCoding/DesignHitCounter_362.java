import java.util.*;
public class DesignHitCounter_362{
	
	Queue<Integer> queue=null;
	
	public DesignHitCounter_362() {
        queue=new ArrayDeque<Integer>();
    }
    
    public void hit(int timestamp) {
        queue.add(timestamp);
    }
    
    public int getHits(int timestamp) {
		while(!queue.isEmpty()){
			if(timestamp-queue.peek()>=300){
				queue.poll();
			}else break;
		}
	   return queue.size();
    }
	
	public static void main(String[] args){
		DesignHitCounter_362 hitCounter = new DesignHitCounter_362();
		hitCounter.hit(1);       // hit at timestamp 1.
		hitCounter.hit(2);       // hit at timestamp 2.
		hitCounter.hit(3);       // hit at timestamp 3.
		System.out.println(hitCounter.getHits(4));
		hitCounter.hit(300);     // hit at timestamp 300.
		System.out.println(hitCounter.getHits(300));
		System.out.println(hitCounter.getHits(301)); 
	}
}