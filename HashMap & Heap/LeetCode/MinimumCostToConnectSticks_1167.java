import java.util.*;
public class MinimumCostToConnectSticks_1167{
	
	public static void main(String[] args){
		int[] sticks={2,4,3};
		System.out.println("total Cost >> "+connectSticks(sticks));
	}
	
	public static int connectSticks(int[] sticks) {
		PriorityQueue<Integer> minpq=new PriorityQueue<>();
        int totalCost=0;
		for(int i=0;i<sticks.length;i++){
			minpq.add(sticks[i]);
		}
		
		while(minpq.size()>1){
			int cost1=minpq.remove();
			int cost2=minpq.remove();
			int cost=cost1+cost2;
			totalCost+=cost;
			minpq.add(cost);
		}
		return totalCost;
    }
}