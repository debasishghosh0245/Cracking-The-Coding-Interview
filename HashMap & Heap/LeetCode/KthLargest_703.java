import java.util.*;
public class KthLargest_703 {
	
    public PriorityQueue<Integer> queue=null;
    public int K=0;
    
	public KthLargest_703(int k,int[] nums){
		queue=new PriorityQueue<>();
        for(int i:nums){
			queue.add(i);
		}
		while(!queue.isEmpty() 
				&& queue.size()!=k){
			System.out.println("Removed >> "+queue.remove());
		}
        this.K=k;
    }
    
    public int add(int val){
        queue.add(val);
        if(queue.size() > K){
		   queue.remove();
        }
		return queue.peek();
    }
	
	public static void main(String[] args){
		/* KthLargest_703 kthLargest = new KthLargest_703(3,new int[]{4,5,8,2});
		//System.out.println(kthLargest.queue.peek());
		System.out.println(kthLargest.add(3));   // return 4
		System.out.println(kthLargest.add(5));   // return 5
		System.out.println(kthLargest.add(10));  // return 5
		System.out.println(kthLargest.add(9));   // return 8
		System.out.println(kthLargest.add(4));   // return 8 */
		KthLargest_703 kthLargest=new KthLargest_703(1,new int[]{});
		System.out.println(kthLargest.add(-3));
		System.out.println(kthLargest.add(-2));
		System.out.println(kthLargest.add(-4));
		System.out.println(kthLargest.add(0));
		System.out.println(kthLargest.add(4));
	}
}
