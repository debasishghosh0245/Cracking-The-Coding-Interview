import java.util.*;
public class MyHashSet<K>{
	
	private int size;
	private int capacity;

	private class ListNode {
		K key;
		ListNode(K key){
		   this.key=key;
		}
	}

	private LinkedList<ListNode>[] buckets;
	
	MyHashSet(int capacity) {
		this.capacity=capacity;
		buckets=new LinkedList[capacity];
		for(int i=0;i<capacity;i++){
			buckets[i]=new LinkedList<ListNode>();
		}
	}
	
	public void add(K key) throws Exception {
	    int bucketIdx=calBucketIndex(key);
		int keyIdx=getKeyIndex(bucketIdx,key);
		if(keyIdx==-1){
			ListNode listNode=new ListNode(key);
			buckets[bucketIdx].addLast(listNode);
			size++;
		}else{
			ListNode node=buckets[bucketIdx].get(keyIdx);
			node.key=key;
		}
		double loadFactor=size*1.0/capacity;
		//System.out.println("loadFactor "+loadFactor);
		if(loadFactor>0.5) {
			rehash();
		}
	}
	
	private void rehash() throws Exception{
		LinkedList<ListNode>[] oldbuckets=buckets;
		this.capacity=capacity*2;
		this.size=0;
		buckets=new LinkedList[capacity];
		for(int i=0;i<capacity;i++){
			buckets[i]=new LinkedList<ListNode>();
		}
		for(int bi=0;bi<oldbuckets.length;bi++){
			LinkedList<ListNode> linkedList=oldbuckets[bi];
			for(ListNode node: linkedList){
				add(node.key);
			}
		}
	}
	
	public K get(K key) throws Exception {
		int bucketIdx=calBucketIndex(key);
		int keyIdx=getKeyIndex(bucketIdx,key);
		if(keyIdx!=-1){
			LinkedList<ListNode> linkedList=buckets[bucketIdx];
			return linkedList.get(keyIdx).key;
		}else{
			return null;
		}
	}

    public boolean containsKey(K key){
		int bucketIdx=calBucketIndex(key);
		int keyIdx=getKeyIndex(bucketIdx,key);
		if(keyIdx==-1) return false;
		else return true;
    }
	
	public int calBucketIndex(K key) {
	    return Math.abs(key.hashCode())%capacity;	
	}
	
	public int getKeyIndex(int bucketIdx,K key){
		int idx=0;
		LinkedList<ListNode> linkedList=buckets[bucketIdx];
		for(ListNode node:linkedList){
			if(node.key.equals(key)) return idx;
			idx++;
		}
		return -1;
	}
	
	public K remove(K key) throws Exception {
		int bucketIdx=calBucketIndex(key);
		int keyIdx=getKeyIndex(bucketIdx,key);
		if(keyIdx!=-1){
			LinkedList<ListNode> linkedList=buckets[bucketIdx];
			ListNode node=linkedList.remove(keyIdx);
			size--;
			return node.key;
		}else{
			return null;
		}
    }

    public ArrayList<K> keyset() throws Exception {
		ArrayList<K> list=new ArrayList<K>();
		for(int bi=0;bi<buckets.length;bi++){
			for(ListNode node : buckets[bi]){
				list.add(node.key);
			}
		}
		return list;
    }

    public int size() {
        return this.size;
    }
	
	public static void main(String[] args) throws Exception {
		MyHashSet<String> hashset=new MyHashSet<>(8);
		System.out.println(Arrays.toString(hashset.buckets));
		hashset.add("Koushik");
		hashset.add("Debasish");
		hashset.add("Ramakrishna");
		hashset.add("Madhumita");
		hashset.add("Asit");
		hashset.add("Bijoy");
		hashset.add("Swapan");
		hashset.add("Subhash");
		hashset.add("Krishana");
		System.out.println(Arrays.toString(hashset.buckets));
		System.out.println("Size >>"+hashset.size);
	}
}