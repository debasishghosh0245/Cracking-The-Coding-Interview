import java.util.*;
public class LRUCache {

	public HashMap<Integer, ListNode> hashMap;
	public ListNode head;
	public ListNode tail;
	public int capacity;
	public int size;

	public class ListNode {
		ListNode next;
		ListNode prev;
		int key;
		int val;
		ListNode(int key,int val) {
			this.key=key;
			this.val= val;
		}
		@Override
		public String toString() {
			return this.val+" ";
		}
	}

	public LRUCache(int capacity) {
		this.capacity=capacity;
		hashMap=new HashMap<>();
	}

	public int get(int key) {
		ListNode node=hashMap.get(key);
		if(node==null){
			return -1;
		}else{
			removeNode(node);
			insertAtForntOfLinkedList(node);
		}
		return node.val;
	}

	public void removeNode(ListNode node) {
		if(node==null) return;
		if(node.prev!=null) node.prev.next=node.next;
		if(node.next!=null) node.next.prev=node.prev;
		ListNode prevNode = node.prev;
		ListNode nextNode = node.next;
		// remove head
		if (node == head) head = node.next;
		// remove tail
		if (node == tail)  tail = node.prev;
	}

	public void insertAtForntOfLinkedList(ListNode node) {
		if (head == null) {
			head = tail = node;
		} else {
			head.prev = node;
			node.next = head;
			head = node;
		}
	}
	
	public void removeKey(int key){
		ListNode node=hashMap.get(key);
		removeNode(node);
		hashMap.remove(key);
	}

	public void put(int key, int value) {
		//remove if already their
		removeKey(key);
		//if full,remove lease recently used items from cache //
		if(hashMap.size() >= capacity && tail!=null ){
			removeKey(tail.key);
		}
		//insert new node 
		ListNode listNode = new ListNode(key,value);
		insertAtForntOfLinkedList(listNode);
		hashMap.put(key,listNode);
		
	}

	public static void main(String[] args) {
		LRUCache lruCache = new LRUCache(2);
		lruCache.put(1,1);
		lruCache.put(2,2);
		System.out.println("Head Node "+lruCache.head);
		System.out.println("Tail Node "+lruCache.tail);
		System.out.println(lruCache.get(1));
		System.out.println("Head Node "+lruCache.head);
		System.out.println("Tail Node "+lruCache.tail);
		lruCache.put(3,3);
		System.out.println(lruCache.get(2));
		lruCache.put(4, 4);
		System.out.println(lruCache.get(1));
	}
}