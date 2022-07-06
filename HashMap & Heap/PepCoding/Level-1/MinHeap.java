import java.util.*;
public class MinHeap{

	int[] minHeap;
	//the maximum element heap can contains
	int heapSize;
	//the number of element heap is containing now
	int realSize=0;
	
	public MinHeap(int heapSize){
		this.heapSize=heapSize;
		minHeap=new int[heapSize];
		realSize=0;
	}

	public void add(int val){
		if(realSize > (heapSize-1)){
			System.out.println("Added too many elements!");
			return;
		} 
		int index=realSize;
		realSize++;
		minHeap[index]=val;
		int parent=(index-1)/2;
		while(index > 0 
			&& minHeap[parent] > minHeap[index]){
			int temp=minHeap[parent];
			minHeap[parent]=minHeap[index];
			minHeap[index]=temp;
			index=parent;
			parent=(index-1)/2;
		}
	}
	
	public void delete(){
		minHeap[0]=minHeap[realSize-1];
		realSize--;
		int index=0;
		while(index <= realSize / 2){
			int left=index*2+1;
			int right=index*2+2;
			if(minHeap[index]>minHeap[left] 
				|| minHeap[index] > minHeap[right]) {
				if(minHeap[left] < minHeap[right]) {
					int temp=minHeap[left];
					minHeap[left]=minHeap[index];
					minHeap[index]=temp;
					index=left;
				}else {
					int temp=minHeap[right];
					minHeap[right]=minHeap[index];
					minHeap[index]=temp;
					index=right;
				}
			}
		}
	}
	
	public int peek(){
		return minHeap[0];
	}

	public void print(){
		for(int i=0;i<realSize;i++){
			System.out.print(minHeap[i]+" ");
		}
		System.out.println("");
	}
	
	public static void main(String[] args){
		
		MinHeap minHeap=new MinHeap(10);
		minHeap.add(10);
		minHeap.add(20);
		minHeap.add(30);
		minHeap.add(5);
		minHeap.add(50);
		System.out.println("Print min Heap >> ");
		minHeap.print();
		minHeap.delete();
		System.out.println("Delete Min Heap >> ");
		minHeap.print();
	}
}