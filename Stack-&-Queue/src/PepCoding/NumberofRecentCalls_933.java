import java.util.*;
public class NumberofRecentCalls_933{
	
	Queue<Integer> queue=null;
	
	public NumberofRecentCalls_933() {
		queue=new ArrayDeque<>();
    }
    
    public int ping(int t) {
        queue.add(t);
		while(!queue.isEmpty()){
			int diff=t-queue.peek();
			if(diff>3000) queue.remove();
			else break;
		}
	   return queue.size();
    }

	public static void main(String[] args){
		NumberofRecentCalls_933 recentCounter = new NumberofRecentCalls_933();
		System.out.println(recentCounter.ping(1));     // requests = [1], range is [-2999,1], return 1
		System.out.println(recentCounter.ping(100));   // requests = [1, 100], range is [-2900,100], return 2
		System.out.println(recentCounter.ping(3001));  // requests = [1, 100, 3001], range is [1,3001], return 3
		System.out.println(recentCounter.ping(3002));  // requests = [1, 100, 3001, 3002], range is [2,3002], return 3
	}

}