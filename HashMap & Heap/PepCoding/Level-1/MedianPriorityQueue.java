import java.util.*;
public class MedianPriorityQueue {
	
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    public MedianPriorityQueue() {
		maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		minHeap = new PriorityQueue<>();
    }

    public void add(int val){
        if(!minHeap.isEmpty() && minHeap.peek() < val){
			minHeap.offer(val);
		}else{
			maxHeap.offer(val);
		}
		if(maxHeap.size()-minHeap.size() > 1) {
			minHeap.offer(maxHeap.poll());
		}else if(minHeap.size()-maxHeap.size() > 1){
			maxHeap.offer(minHeap.poll());
		}
    }

    public int remove() {
		if(this.size()==0){
			System.out.println("Underflow");
			return -1;
		}
		if(maxHeap.size() >= minHeap.size()){
			return maxHeap.poll();
		}
		else return minHeap.poll();
    }

    public int peek() {
		if(this.size()==0){
			System.out.println("Underflow");
			return -1;
		}
		if(maxHeap.size() >= minHeap.size()){
			return maxHeap.peek();
		}
		else return minHeap.peek();
    }

    public int size() {
       return maxHeap.size()+minHeap.size();
    }
	
	public double findMedian() {
        if(maxHeap.size()> minHeap.size()){
			return maxHeap.peek();
		}
		else if(minHeap.size() > maxHeap.size()){
			return minHeap.peek();
		}else{
			return ((double) minHeap.peek() + maxHeap.peek()) * 0.5;
		}
    }
	
	
	public static void main(String[] args){
		
		MedianPriorityQueue priorityQueue=new MedianPriorityQueue();
		priorityQueue.add(1);
		priorityQueue.add(2);
		priorityQueue.add(3);
		

		System.out.println("Max Heap >> "+priorityQueue.maxHeap);
		System.out.println("min Heap >> "+priorityQueue.minHeap);
		System.out.println(priorityQueue.findMedian());
		
	}

}