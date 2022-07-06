import java.util.*;
public class MyHashMap_706<K,V>{
	
	private int size;
	private int capacity;

	private class ListNode {
		K key;
		V value;
		ListNode(K key,V value){
		   this.key=key;
		   this.value=value;
		}
	}

	private LinkedList<ListNode>[] buckets;
	
	MyHashMap_706(int capacity){
		this.capacity=capacity;
		buckets=new LinkedList[capacity];
		for(int i=0;i<capacity;i++){
			buckets[i]=new LinkedList<ListNode>();
		}
	}
	
	public void put(K key,V val) throws Exception {
	    int bucketIdx=calBucketIndex(key);
		int keyIdx=getKeyIndex(bucketIdx,key);
		if(keyIdx==-1){
			ListNode listNode=new ListNode(key,val);
			buckets[bucketIdx].addLast(listNode);
			size++;
		}else{
			ListNode node=buckets[bucketIdx].get(keyIdx);
			node.value=val;
		}
		double loadFactor=size*1.0/capacity;
		System.out.println("loadFactor "+loadFactor);
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
				put(node.key,node.value);
			}
		}
	}
	
	public V get(K key) throws Exception {
		int bucketIdx=calBucketIndex(key);
		int keyIdx=getKeyIndex(bucketIdx,key);
		if(keyIdx!=-1){
			LinkedList<ListNode> linkedList=buckets[bucketIdx];
			return linkedList.get(keyIdx).value;
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
	
	public V remove(K key) throws Exception {
		int bucketIdx=calBucketIndex(key);
		int keyIdx=getKeyIndex(bucketIdx,key);
		if(keyIdx!=-1){
			LinkedList<ListNode> linkedList=buckets[bucketIdx];
			ListNode node=linkedList.remove(keyIdx);
			size--;
			return node.value;
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
		MyHashMap_706<String,String> hashMap=new MyHashMap_706<>(8);
		System.out.println(Arrays.toString(hashMap.buckets));
		hashMap.put("Koushik","K");
		hashMap.put("Debasish","D");
		hashMap.put("Ramakrishna","R");
		hashMap.put("Madhumita","M");
		hashMap.put("Asit","A");
		hashMap.put("Bijoy","B");
		hashMap.put("Swapan","S");
		hashMap.put("Subhash","S");
		hashMap.put("Krishana","K");
		System.out.println(Arrays.toString(hashMap.buckets));
		System.out.println("Size >>"+hashMap.size);
	}
}